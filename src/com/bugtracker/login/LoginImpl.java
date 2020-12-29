package com.bugtracker.login;

import com.bugtracker.BugTracker;
import com.bugtracker.ReadHelper;
import com.bugtracker.model.User;
import java.util.Map;

// You need implement interface method for looging on an existing user
public class LoginImpl implements Login {
    private BugTracker bugTracker;

    public LoginImpl(BugTracker bugTracker){
        this.bugTracker = bugTracker;
    }

    @Override
    public User execute() {
        System.out.print("Username: ");
        String userName = ReadHelper.readString();
        System.out.print("Password: ");
        String password = ReadHelper.readString();
        for (Map.Entry<String, User> entry : bugTracker.getUsers().entrySet())
            if (entry.getKey().equals(userName) && entry.getValue().getPassword().equals(password)){
                System.out.println("Yeap !");
                return entry.getValue();
            }
        return null;
    }
}