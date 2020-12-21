package com.bugtracker;

import java.util.ArrayList;
import java.util.List;

//  Class User should have an 'id'. 'firstname' and 'lastname' fields  with setters and getters
public class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
