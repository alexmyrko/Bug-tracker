package com.bugtracker.login;

import com.bugtracker.BugTracker;
import com.bugtracker.ReadHelper;
import com.bugtracker.model.User;
import java.util.ResourceBundle;

// You need implement interface method for looging on an existing user
public class Login implements Logging {
    private ResourceBundle validUsers =  ResourceBundle.getBundle(BugTracker.class.getPackage().getName() + ".resources.users");
    @Override
    public User execute() {
        User currentUser = null;
        System.out.print("Username: ");
        String userName = ReadHelper.readString();
        System.out.print("Password: ");
        String password = ReadHelper.readString();
        if (validUsers.containsKey(userName) && validUsers.getString(userName).equals(password)){
            for (User user : BugTracker.getUsers()) {
                if (user.getUserName().equals(userName)) {
                    currentUser = user;
                }
            }
        }
        return currentUser;
    }
}
