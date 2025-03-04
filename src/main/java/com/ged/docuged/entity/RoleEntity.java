package com.ged.docuged.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.ged.docuged.enumeration.Authority;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name =  "roles")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RoleEntity extends Auditable{

    private String name;
    private Authority authorities;

}
