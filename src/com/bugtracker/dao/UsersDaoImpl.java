package com.bugtracker.dao;

import com.bugtracker.model.User;

import java.util.HashMap;
import java.util.Map;

public class UsersDaoImpl implements UsersDAO {
    private static Map<String, User> users = new HashMap<>();
    private static UsersDaoImpl instance = null;

    private UsersDaoImpl() {
        this.initUsers();
    }

    public static UsersDaoImpl getInstance() {
        if (instance == null)
            instance = new UsersDaoImpl();
        return instance;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void initUsers() {
        users.put("alex", new User("Oleksandr Myrko", "cursor1"));
        users.put("max", new User("Maksym Protsenko", "cursor2"));
        users.put("andrew", new User("Andriy Farenyuk", "cursor3"));
    }

    @Override
    public void addUser(String login, User user) {
        users.put(login, user);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return users;
    }
}
