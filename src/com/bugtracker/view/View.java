package com.bugtracker.view;

import com.bugtracker.BugTracker;
import com.bugtracker.Operation;
import com.bugtracker.login.LoginImpl;
import com.bugtracker.login.RegisterImpl;
import com.bugtracker.model.User;

import java.io.IOException;

public class View {
    private BugTracker bugTracker;

    public View(BugTracker bugTracker){
        this.bugTracker = bugTracker;
    }

    public User login() throws IOException {
        User user = null;
        while (true) {
            Operation operation = Operation.getLoginOperationByOrdinal();
            switch (operation) {
                case LOGIN -> user = new LoginImpl(bugTracker).execute();
                case REGISTER -> user = new RegisterImpl(bugTracker).execute();
                case EXIT -> System.exit(0);
            }
            if (user != null)
                return user;
        }
    }

    public void routine(){
        System.out.println("1 - Create, 2 - Edit, 3 - View, 4 - Exit\nChoose operation:");
        // TODO

    }

}
