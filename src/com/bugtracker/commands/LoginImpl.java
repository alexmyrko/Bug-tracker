package com.bugtracker.commands;

import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.ReadHelper;
import com.bugtracker.model.User;
import java.util.Map;

// You need implement interface method for looging on an existing user
public class LoginImpl implements Login {
    private final UsersDAO usersDAO;

    public LoginImpl(){
        usersDAO = UsersDaoImpl.getInstance();
    }

    @Override
    public User execute() {
        System.out.print("Username: ");
        String userName = ReadHelper.readString();
        System.out.print("Password: ");
        String password = ReadHelper.readString();
        for (Map.Entry<String, User> entry : usersDAO.getAllUsers().entrySet())
            if (entry.getKey().equals(userName) && entry.getValue().getPassword().equals(password)){
                System.out.println(userName + " logged on successfully !");
                return entry.getValue();
            }
        return null;
    }


}