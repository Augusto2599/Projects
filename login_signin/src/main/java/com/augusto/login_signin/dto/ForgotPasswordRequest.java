package com.augusto.login_signin.dto;


public class ForgotPasswordRequest {
    private String email;
    private String newPassword;

    public ForgotPasswordRequest() {
    }

    public ForgotPasswordRequest(String newPassword, String email) {
        this.newPassword = newPassword;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ForgotPasswordRequest{" +
                "email='" + email + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}