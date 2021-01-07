package com.bugtracker.dao;

import com.bugtracker.model.User;
import java.util.Map;

public interface UsersDAO {

    Map<String, User> getAllUsers();

    void initUsers();

    void addUser(String login, User user);

    User getUserByLogin(String login);

    String getLoginByUser(User user);

    void setCurrentUser(User user);

    User getCurrentUser();

}
