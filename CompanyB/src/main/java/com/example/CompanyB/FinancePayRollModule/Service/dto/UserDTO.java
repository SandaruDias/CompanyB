package com.example.CompanyB.FinancePayRollModule.Service.dto;

public class UserDTO {
    private String id;
    private String username;
    private String role;  // Roles such as 'admin' or 'user'

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
