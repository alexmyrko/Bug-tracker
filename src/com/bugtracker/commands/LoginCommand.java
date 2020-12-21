package com.bugtracker.commands;

import com.bugtracker.BugTracker;
import com.bugtracker.ReadHelper;

import java.util.ResourceBundle;

// You need implement interface method for looging on an existing user
public class LoginCommand implements Command{
    private ResourceBundle validUsers =
            ResourceBundle.getBundle(BugTracker.class.getPackage().getName() + ".resources.users");
    @Override
    public void execute() {
        System.out.print("Username: ");
        String userName = ReadHelper.readString();
        System.out.print("\nPassword:");
        String password = ReadHelper.readString();

    }
}
