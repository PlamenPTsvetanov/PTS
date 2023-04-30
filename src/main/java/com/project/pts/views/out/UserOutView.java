package com.project.pts.views.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserOutView {
    @JsonProperty("creationDate")
    private String insertedAt;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String emailAddress;

    public UserOutView(){}

    public UserOutView(
                      String insertedAt,
                      String firstName,
                      String lastName,
                      String username,
                      String emailAddress) {

        this.insertedAt = insertedAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.emailAddress = emailAddress;
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

}
