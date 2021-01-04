package com.bugtracker.view;

import com.bugtracker.Operation;
import com.bugtracker.dao.TicketsDaoImpl;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.model.User;

public class View {
    private final UsersDaoImpl usersDao;
    private final TicketsDaoImpl ticketsDao;

    public View() {
        usersDao = UsersDaoImpl.getInstance();
        ticketsDao = TicketsDaoImpl.getInstance();
    }

    public void login() {
        User currentUser = null;
        while (true) {
            Operation operation = Operation.getLoginOperationByOrdinal();
            switch (operation) {
                case LOGIN -> currentUser = usersDao.getLogin().execute();
                case REGISTER -> currentUser = usersDao.getRegister().execute();
                case EXIT -> System.exit(0);
            }
            if (currentUser != null) {
                usersDao.setCurrentUser(currentUser);
                break;
            }
        }
    }

    public void routine() {
        Operation operation = Operation.getRoutineOperationByOrdinal();
        switch (operation) {
            case CREATE -> ticketsDao.getTicketService().create();
            case EDIT -> ticketsDao.getTicketService().edit();
            case VIEW -> {
                System.out.println("Press Enter button to print all tickets or enter login to print certain user tickets:");
                ticketsDao.getTicketService().print();
            }
            case EXIT -> System.exit(0);
        }
    }
}
