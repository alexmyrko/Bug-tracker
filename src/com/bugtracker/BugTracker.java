package com.bugtracker;

import java.util.List;
import java.util.ResourceBundle;
import com.bugtracker.login.Login;
import com.bugtracker.login.Register;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.io.IOException;
import java.util.*;

public class BugTracker {
    // Untill tickets receiving will be implemented via DAO
    private ResourceBundle validUsers =  ResourceBundle.getBundle(BugTracker.class.getPackage().getName() + ".resources.users");
    private static List<User> users = new ArrayList<>();
    Map<Integer, Ticket> tickets = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BugTracker bugTracker = new BugTracker();
        bugTracker.initUsers();

        User currentUser = new Login().execute();
        System.out.println("Logged user: " + currentUser.getUserName());

        currentUser = new Register().execute();
        System.out.println("Registered user: " + currentUser.getUserName());
    }

    public static List<User> getUsers() {
        return users;
    }

    private void initUsers(){
        for (String userName : validUsers.keySet())
            users.add(new User(userName));
    }
}
