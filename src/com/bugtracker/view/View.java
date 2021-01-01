package com.bugtracker.view;

import com.bugtracker.Operation;
import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.commands.Login;
import com.bugtracker.commands.LoginImpl;
import com.bugtracker.commands.RegisterImpl;
import com.bugtracker.model.User;

import java.io.IOException;

public class View {
    private final Login login;
    private final Login register;
    private final UsersDAO usersDAO;

    public View(){
        login = new LoginImpl();
        register = new RegisterImpl();
        usersDAO = UsersDaoImpl.getInstance();
        usersDAO.initUsers();
    }

    public User login() throws IOException {
        User user = null;
        while (true) {
            Operation operation = Operation.getLoginOperationByOrdinal();
            switch (operation) {
                case LOGIN -> user = login.execute();
                case REGISTER -> user = register.execute();
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
