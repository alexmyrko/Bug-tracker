package com.bugtracker.commands;

import com.bugtracker.ReadHelper;
import com.bugtracker.model.User;

public class RegisterImpl implements Login {
    private static User newUser;
    private final UserService userService;
    String newLogin = "";
    String newPassword = "";
    String newUserName = "";

    public RegisterImpl() {
        userService = new UserServiceImpl();
    }

    @Override
    public User execute() {
        User existedUser;
        do {
            System.out.print("Please, enter your login: ");
            newLogin = ReadHelper.readString();
            existedUser = userService.getAllUsers().get(newLogin);
            if (existedUser != null) {
                System.out.println("This username have been existed. Please, enter another one!");
            }
        } while (existedUser != null);
        do {
            System.out.print("Please, enter your password: ");
            newPassword = ReadHelper.readString();
            if (newPassword.isEmpty() || newPassword.length() < 3) {
                System.out.println("Your password isn`t safe. Use more symbols!");
            }
        } while (newPassword.isEmpty() || newPassword.length() < 3);

        do {
            System.out.print("Please, enter your name and surname: ");
            newUserName = ReadHelper.readString();
        } while (newUserName.isEmpty() || newUserName.length() < 3);
        newUser = new User(newLogin, newPassword);
        userService.addUser(newLogin, newUser);
        userService.setCurrentUser(newUser);
        return newUser;
    }
}