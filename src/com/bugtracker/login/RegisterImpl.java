package com.bugtracker.login;

import com.bugtracker.BugTracker;
import com.bugtracker.model.User;


// You need implement interface method for viewing all active Tickets
public class RegisterImpl implements Login {
    private BugTracker bugTracker;

    public RegisterImpl(BugTracker bugTracker){
        this.bugTracker = bugTracker;
    }

    @Override
    public User execute() {
        return null;
    }
}
