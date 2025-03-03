package com.GED.DocuGed.entity;

import com.GED.DocuGed.domain.RequestContext;
import com.GED.DocuGed.exception.ApiException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

@Getter
@Setter
//persister l'entiter dans lla base sans pour autant avoir la posibiliter de faire des requetes
@MappedSuperclass
//suivie de la creation et la modification d'un utilisateur
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public abstract class Auditable {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column( name = "id", updatable = false)
    private Long id;
    // number use to identify a specific resource in the server or in the database
    private String referenceId  = new AlternativeJdkIdGenerator().generateId().toString();
    @NotNull
    private Long createdBy;
    @NotNull
    private Long updatedBy;
    @NotNull
    @CreatedDate
    @Column(name = "created_at" , nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @CreatedDate
    @Column(name = "updated_at", nullable = false )
    private LocalDateTime updatedAt;




    // Called before any entity call in the datebase
    @PrePersist
    public void beforePersist(){
        var userId = RequestContext.getUserId();
        if(userId == null ){ throw new ApiException("Cannot persisit without user ID in Request context for this thread"); }
        setCreatedAt(now());
        setCreatedBy(userId);
        setUpdatedBy(userId);
        setUpdatedAt(now());
    }

    @PreUpdate
    public void beforeUpdate(){
        var userId = RequestContext.getUserId();
        if(userId == null ){ throw new ApiException("Cannot update without user ID in Request context for this thread"); }
        setUpdatedAt(now());
        setUpdatedBy(userId);
    }
}
