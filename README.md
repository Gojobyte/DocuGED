# Application Overview: Secure Document Management System

## Introduction

The **Secure Document Management System (SDMS)** is a robust and user-friendly application designed to securely store, update, upload, and delete documents. This application addresses the need for a centralized and secure repository for sensitive information, offering a seamless and efficient solution for document management. The Secure Document Management System offers a comprehensive solution for organizations to securely store, manage, and collaborate on documents. With robust security measures and a user-friendly interface, it addresses the needs of businesses requiring a reliable and secure document management platform.

---

## Functional Requirements

### 1. User Account Management

#### New Account
- **Create Account**: Users can create a new account using basic information, a unique email, and a password.
- **Account Verification**: New accounts are disabled until verified via an email confirmation link.
- **Email Confirmation**: The system sends an email with a link to confirm the new account.
- **Login Restriction**: Only verified accounts can log in.

#### Reset Password
- **Password Reset**: Users can reset their password by requesting a reset link via email.
- **Reset Link**: Clicking the link redirects users to a password reset form.
- **Successful Reset**: After resetting the password, users can log in with the new password.
- **Unlimited Resets**: Users can reset their password as many times as needed.

#### Multi-Factor Authentication (MFA)
- **MFA Setup**: Users can set up MFA to secure their accounts.
- **QR Code**: MFA setup involves scanning a QR code using an authenticator app (e.g., Google Authenticator).
- **Login with MFA**: After entering the correct email and password, users must provide the MFA code from their authenticator app to log in.

#### Log In
- **Email and Password**: Users log in using their email and password.
- **MFA Integration**: If MFA is enabled, users must provide the MFA code after entering their credentials.
- **Account Lockout**: After 6 failed login attempts, the account is locked for 15 minutes to prevent brute force attacks.
- **Password Expiry**: Passwords expire after 90 days, requiring users to update them to log in.

#### Profile Management
- **Update Information**: Users can update their basic information while logged in.
- **Update Password**: Users can change their password while logged in.
- **Update Settings**: Users can modify their account settings while logged in.

---

### 2. Document Management

#### Document List
- **Document Display**: The homepage shows a list of all uploaded documents.
- **Document Details**: Each document displays details like name, size, owner, and type.
- **Upload Documents**: Logged-in users can upload new documents.
- **Pagination**: The document list supports pagination.
- **Customizable Display**: Users can set the number of documents displayed per page.
- **Search Functionality**: Users can search for documents by name, with results including pagination.
- **Document Click**: Clicking on a document opens its detailed view.

#### Document Details
- **Detailed View**: Displays detailed information about the document, including the owner.
- **Update Metadata**: Users can update the document's name and description.
- **Download**: Users can download the document.
- **Delete**: Users can delete the document (if they have the required permissions).

---

### 3. Access Control

#### User Roles
- **Role Assignment**: Users are assigned roles with specific permissions.
- **Role-Based Access**: Roles grant different access levels to users.
- **Restricted Actions**:
    - Only users with proper roles can perform specific actions (e.g., delete documents).
    - Non-user roles can update account settings and roles.
    - Only users with "delete" permission can delete documents.
    - Non-user roles can view other users in the system.

---

### 4. Audit Trail
- **Entity Tracking**: The system tracks:
    - Who created an entity (user, document, etc.).
    - When an entity was created.
    - Who updated an entity.
    - When an entity was updated.

---

## Key Features

### 1. User Authentication and Authorization
- Users must authenticate to access the system.
- Role-based access control ensures secure and restricted access to documents and features.

### 2. Multi-Factor Authentication (MFA)
- Adds an extra layer of security during login using QR codes and authenticator apps.

### 3. Document Upload and Management
- Users can upload documents in various formats (DOC, DOCX, XLS, PDF, etc.).
- Documents can be updated, downloaded, and deleted based on user permissions.

### 4. Access Control
- Roles and permissions ensure that only authorized users can perform specific actions (e.g., delete documents, update roles).

### 5. Audit Trail
- Tracks all changes made to entities (users, documents, etc.) for accountability and security.

---

## Technologies

### Front-End
- **TypeScript (TS)**: Adds type safety to JavaScript, improving code quality and maintainability.
- **React**: A JavaScript library for building user interfaces.
- **Redux**: A state management library for managing global application state.

### Back-End
- **Java Spring Boot**: A robust framework for building scalable and secure backend applications.
- **PostgreSQL**: A powerful, open-source relational database for storing application data.
- **Docker**: A containerization platform for deploying and managing the application in isolated environments.

---

## Application Workflow

1. **User Registration**:
    - User creates an account with email and password.
    - Account is disabled until email verification is completed.

2. **User Login**:
    - User logs in with email and password.
    - If MFA is enabled, user provides the MFA code from their authenticator app.

3. **Document Management**:
    - Logged-in users can upload, view, update, and delete documents based on their roles and permissions.
    - Document list supports pagination, search, and customizable display.

4. **Access Control**:
    - Users with specific roles can perform actions like deleting documents or updating roles.
    - Non-user roles can view other users and update account settings.

5. **Audit Trail**:
    - All actions (creation, updates, deletions) are logged for accountability.

---

## Security Measures
- **Account Verification**: Ensures only verified users can access the system.
- **MFA**: Adds an extra layer of security during login.
- **Password Policies**: Password expiry and account lockout mitigate brute force attacks.
- **Role-Based Access**: Ensures users can only perform actions they are authorized to do.
- **Audit Trail**: Tracks all changes for accountability and security.

---

## Conclusion

The **Secure Document Management System** is a feature-rich application designed to securely manage documents while providing a seamless user experience. With robust security measures like MFA, role-based access control, and audit trails, it ensures data integrity and user accountability. The use of modern technologies like TypeScript, React, Java Spring Boot, and PostgreSQL makes it scalable, maintainable, and secure.