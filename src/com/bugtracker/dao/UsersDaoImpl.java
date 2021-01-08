package com.bugtracker.dao;

import com.bugtracker.model.User;
import java.util.HashMap;
import java.util.Map;

public class UsersDaoImpl implements UsersDAO {
    private Map<String, User> users = new HashMap<>();
    private static UsersDaoImpl instance = null;
    private User currentUser;

    private UsersDaoImpl() {
        this.initUsers();
    }

    public static UsersDaoImpl getInstance() {
        if (instance == null)
            instance = new UsersDaoImpl();
        return instance;
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

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }

    @Override
    public void setCurrentUser(User user) {
        currentUser = user;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

}
