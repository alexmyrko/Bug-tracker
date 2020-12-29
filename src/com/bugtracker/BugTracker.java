package com.bugtracker;

import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;
import com.bugtracker.view.View;

import java.io.IOException;
import java.util.*;

public class BugTracker {

    private Map<String, User> users = new HashMap<>();
    private Map<Integer, Ticket> tickets = new HashMap<>();
    public static int counter = 1;

    public static void main(String[] args) throws IOException {
        BugTracker bugTracker = new BugTracker();
        View view = new View(bugTracker);
        bugTracker.initUsers();

        User currentUser = view.login();
        System.out.println("Logged user: " + currentUser.getUserName());
    }

    public Map<String, User> getUsers() {
        return users;
    }

    private void initUsers(){
        users.put("alex", new User("Oleksandr Myrko", "cursor1"));
        users.put("max", new User("Maxym Protsenko", "cursor2"));
        users.put("andrew", new User("Andriy Farenyuk", "cursor3"));
    }
}
