package com.bugtracker.commands;

import com.bugtracker.ReadHelper;
import com.bugtracker.model.User;

public class LoginImpl implements Login {
    private final UserService userService;

    public LoginImpl() {
        userService = new UserServiceImpl();
    }

    @Override
    public User execute() {
        System.out.print("Username: ");
        String loginName = ReadHelper.readString();
        System.out.print("Password: ");
        String password = ReadHelper.readString();
        User currentUser = userService.getAllUsers().get(loginName);
        if (currentUser != null && currentUser.getPassword().equals(password)) {
            userService.setCurrentUser(currentUser);
            return currentUser;
        } else return null;
    }
}