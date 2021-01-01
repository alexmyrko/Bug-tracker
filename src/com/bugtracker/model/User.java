package com.bugtracker.model;

//  Class User should have an 'id'. 'firstname' and 'lastname' fields  with setters and getters
public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
