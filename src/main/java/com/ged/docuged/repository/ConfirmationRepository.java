package com.ged.docuged.repository;

import com.ged.docuged.entity.ConfirmationEntity;
import com.ged.docuged.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {
    Optional<ConfirmationEntity> finByKey(String key);
    Optional<ConfirmationEntity> findByUserEntity(UserEntity userEntity);
}
