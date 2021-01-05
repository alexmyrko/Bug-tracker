package com.bugtracker.commands;

import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.model.User;

public class UserServiceImpl implements UserService {
    private static UsersDAO usersDao;

    public UserServiceImpl() {
        usersDao = UsersDaoImpl.getInstance();
    }

    @Override
    public User getUserByLogin(String loginName) {
        return usersDao.getUserByLogin(loginName);
    }

    @Override
    public User getCurrentUser() {
        return usersDao.getCurrentUser();
    }
}
