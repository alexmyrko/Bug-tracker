package com.bugtracker.commands;

import com.bugtracker.model.User;
import java.util.Map;

public interface UserService {
    User getUserByLogin(String login);
    Map<String, User> getAllUsers();
    User getCurrentUser();
}
