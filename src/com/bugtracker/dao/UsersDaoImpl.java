package com.bugtracker.dao;

import com.bugtracker.commands.Login;
import com.bugtracker.commands.LoginImpl;
import com.bugtracker.commands.RegisterImpl;
import com.bugtracker.model.User;

import java.util.HashMap;
import java.util.Map;

public class UsersDaoImpl implements UsersDAO {
    private Map<String, User> users = new HashMap<>();
    private static UsersDaoImpl instance = null;
    private User curentUser;

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
        curentUser = user;
    }

    @Override
    public User getCurrentUser() {
        return curentUser;
    }

    public Login getLogin(){
        return new LoginImpl();
    }

    public Login getRegister(){
        return new RegisterImpl();
    }
}
