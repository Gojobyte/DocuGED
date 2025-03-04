package com.ged.docuged.service;

import com.ged.docuged.entity.RoleEntity;

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);
    RoleEntity getRoleName(String name);
}
