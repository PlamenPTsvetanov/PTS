package com.project.pts.entities;

import com.project.pts.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    private String insertedAt;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String password;
    private boolean isAuthenticated;
    private boolean isDeleted;

    public UserEntity(){}

    public UserEntity(
                Long id,
                String insertedAt,
                String firstName,
                String lastName,
                String username,
                String emailAddress,
                String password) {
        super.setId(id);
        this.insertedAt = insertedAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.emailAddress = emailAddress;
        this.isAuthenticated = false;
        this.isDeleted = false;
        this.password = password;
    }

    public String getInsertedAt() {
        return this.insertedAt;
    }

    public void setInsertedAt(String insertedAt) {
        this.insertedAt = insertedAt;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAuthenticated() {
        return this.isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
