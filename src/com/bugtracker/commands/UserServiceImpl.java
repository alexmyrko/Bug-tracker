package com.bugtracker.commands;

import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.model.User;
import java.util.Map;

public class UserServiceImpl implements UserService{
    UsersDAO usersDAO;
    public UserServiceImpl(){
        usersDAO = UsersDaoImpl.getInstance();
    }

    @Override
    public User getUserByLogin(String login) {
            return usersDAO.getUserByLogin(login);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    public User getCurrentUser() {
        return usersDAO.getCurrentUser();
    }

    @Override
    public void setCurrentUser(User user) {
        usersDAO.setCurrentUser(user);
    }

    @Override
    public void addUser(String loginName, User user) {
        usersDAO.addUser(loginName, user);
    }
}
