package com.bugtracker.dao;

import com.bugtracker.model.User;
import java.util.HashMap;
import java.util.Map;

public class UsersDaoInMemImpl implements UsersDAO {
    private Map<String, User> users = new HashMap<>();
    private static UsersDaoInMemImpl instance = null;
    private User curentUser;

    private UsersDaoInMemImpl() {
        this.initUsers();
    }

    public static UsersDaoInMemImpl getInstance() {
        if (instance == null)
            instance = new UsersDaoInMemImpl();
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

    public String getLoginByUser(User user){
        for(Map.Entry<String, User> entry : users.entrySet()){
            if (entry.getValue().getUserName().equals(user.getUserName()) && entry.getValue().getPassword().equals(user.getPassword()))
                return entry.getKey();
        }
        return "";
    }

    @Override
    public void setCurrentUser(User user) {
        curentUser = user;
    }

    @Override
    public User getCurrentUser() {
        return curentUser;
    }

}
