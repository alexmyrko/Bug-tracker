package com.bugtracker.view;

import com.bugtracker.Operation;
import com.bugtracker.commands.*;
import com.bugtracker.model.User;

public class View {
    private final Login login;
    private final Login register;
    private final TicketService ticketService;
    public View() {
        login = new LoginImpl();
        register = new RegisterImpl();
        ticketService = new TicketServiceImpl();
    }

    public void login() {
        User currentUser = null;
        while (true) {
            Operation operation = Operation.getLoginOperationByOrdinal();
            switch (operation) {
                case LOGIN -> currentUser = login.execute();
                case REGISTER -> currentUser = register.execute();
                case EXIT -> System.exit(0);
            }
            if (currentUser != null) {
                break;
            }
        }
    }

    public void routine() {
        Operation operation = Operation.getRoutineOperationByOrdinal();
        switch (operation) {
            case CREATE -> ticketService.create();
            case EDIT -> ticketService.edit();
            case VIEW -> {
                System.out.println("Press Enter button to print all tickets or enter login to print certain user tickets:");
                ticketService.print();
            }
            case EXIT -> System.exit(0);
        }
    }
}
