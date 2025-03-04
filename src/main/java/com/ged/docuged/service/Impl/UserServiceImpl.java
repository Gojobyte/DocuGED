package com.ged.docuged.service.Impl;


import com.ged.docuged.entity.ConfirmationEntity;
import com.ged.docuged.entity.CredentialEntity;
import com.ged.docuged.entity.RoleEntity;
import com.ged.docuged.entity.UserEntity;
import com.ged.docuged.enumeration.Authority;
import com.ged.docuged.enumeration.EventType;
import com.ged.docuged.event.UserEvent;
import com.ged.docuged.exception.ApiException;
import com.ged.docuged.repository.ConfirmationRepository;
import com.ged.docuged.repository.CredentialRepository;
import com.ged.docuged.repository.RoleRepository;
import com.ged.docuged.repository.UserRepository;
import com.ged.docuged.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.ged.docuged.utils.UserUtils.createUserEntity;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;
    //private final BCryptPasswordEncoder encoder;
    private final ApplicationEventPublisher publisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        var userEntity = userRepository.save(createNewUser(firstName, lastName, email));
        var credentialEntity = new CredentialEntity(userEntity, password);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key",confirmationEntity.getKey())));
    }

    @Override
    public RoleEntity getRoleEntity(String name) {
        var role = roleRepository.findByNameIgnoreCase(name);
        return role.orElseThrow(() -> new ApiException("Role not found"));
    }

    private UserEntity createNewUser(String firstName, String lastName, String email) {
        var role = getRoleName(Authority.USER.name());
        return createUserEntity(firstName, lastName, email, role);
    }
}
