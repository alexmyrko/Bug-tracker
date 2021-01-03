package com.bugtracker.commands;

import com.bugtracker.ReadHelper;
import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.model.User;

// You need implement interface method for viewing all active Tickets
public class RegisterImpl implements Login {
    private final UsersDAO usersDAO;
    String newUserName = "";
    String newPassword = "";
    String nameSurname = "";

    public RegisterImpl() {
        usersDAO = UsersDaoImpl.getInstance();
        usersDAO.initUsers();
    }

    @Override
    public User execute() {
        User existedUser;
        do {
            System.out.println("Please, enter your login:");
            newUserName = ReadHelper.readString();
            existedUser = usersDAO.getAllUsers().get(newUserName);
            if (existedUser != null) {
                System.out.println("This username have been existed. Please, enter another one!");
            }
        } while (existedUser != null);
        do {
            System.out.print("Please, enter your password:");
            newPassword = ReadHelper.readString();
            if (newPassword.isEmpty() || newPassword.length() < 3) {
                System.out.println("Your password isn`t safe. Use more symbols!");
            }
        } while (newPassword.isEmpty() || newPassword.length() < 3);

        do {
            System.out.print("Please, enter your name and surname:");
            nameSurname = ReadHelper.readString();
        } while (nameSurname.isEmpty() || nameSurname.length() < 3);
        User newUser = new User(newUserName,newPassword);
        return newUser;
    }
}
