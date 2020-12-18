package com.bugtracker.view;

import com.bugtracker.BugTracker;
import com.bugtracker.User;

public class View {
    private BugTracker bugTracker;

    public View(BugTracker bugTracker){
        this.bugTracker = bugTracker;
    }

    public void login(){
        System.out.println("1 - Login, 2 - Register, 3 - Exit\nChoose operation:");
       // TODO
    }

    public void routine(){
        System.out.println("1 - Create, 2 - Edit, 3 - View, 4 - Exit\nChoose operation:");
        // TODO

    }

    public static void printUserTickets(User user){
        // TODO
    }
}
