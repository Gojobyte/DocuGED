package com.ged.docuged.utils;

import com.ged.docuged.entity.RoleEntity;
import com.ged.docuged.entity.UserEntity;

import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserUtils {

    public static UserEntity createUserEntity(String firstName, String lastName, String Email, RoleEntity role){
         return UserEntity.builder()
                 .userId(UUID.randomUUID().toString())
                 .firstName(firstName)
                 .lastName(lastName)
                 .email(Email)
                 .lastLogin(now())
                 .accountNonExpired(true)
                 .accountNonLocked(true)
                 .enabled(false)
                 .loginAttempts(0)
                 .qrCodeSecret(EMPTY)
                 .phone(EMPTY)
                 .bio(EMPTY)
                 .imageUrl("https://assistanteplus.fr/wp-content/uploads/2022/04/chat-midjourney.webp")
                 .role(role)
                 .build();

    }
}
