package com.bugtracker.service;

import com.bugtracker.BugTracker;
import com.bugtracker.dao.MemoryModel;
import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoInMemImpl;
import com.bugtracker.dao.UsersDaoSQLImpl;
import com.bugtracker.model.User;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private UsersDAO usersDAO;
    public UserServiceImpl() {
        if (BugTracker.getMemoryModel() == MemoryModel.INMEM)
            usersDAO = UsersDaoInMemImpl.getInstance();
        else usersDAO = UsersDaoSQLImpl.getInstance();
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
    public void addUser(String login, User user) {
        usersDAO.addUser(login, user);
    }
}
