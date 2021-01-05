package com.bugtracker.commands;

import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.ReadHelper;
import com.bugtracker.model.User;

// You need implement interface method for looging on an existing user
public class LoginImpl implements Login {
    private final UsersDAO usersDAO;

    public LoginImpl(){
        usersDAO = UsersDaoImpl.getInstance();
    }

    @Override
    public User execute() {
        System.out.print("Username: ");
        String loginName = ReadHelper.readString();
        System.out.print("Password: ");
        String password = ReadHelper.readString();
        User currentUser = usersDAO.getAllUsers().get(loginName);
        if (currentUser != null && currentUser.getPassword().equals(password)) {
            UsersDaoImpl.getInstance().setCurrentUser(currentUser);
            return currentUser;
        }
        else return null;
    }
}