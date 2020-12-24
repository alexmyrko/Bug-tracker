package com.bugtracker;

import java.util.List;
import java.util.ResourceBundle;
import com.bugtracker.login.Login;
import com.bugtracker.model.Ticket;

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
        for (User user : users)
            System.out.println(user.getUserName());
        User currentUser = new Login().execute();
        System.out.println(currentUser.getUserName());

    }

    public static List<User> getUsers() {
        return users;
    }

    public void initUsers(){
        for (String userName : validUsers.keySet())
            users.add(new User(userName));
    }
}
