package com.ged.docuged.service;

public interface EmailService {

    void sendNewAccountEmail(String name, String email, String token);
    void sendPasswordResetEmail(String name, String email, String token);
}
