package com.bugtracker.commands;

import com.bugtracker.model.User;

public interface UserService {
    User getUserByLogin(String loginName);

    User getCurrentUser();
}
