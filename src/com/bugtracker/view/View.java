package com.bugtracker.view;

import com.bugtracker.Operation;
import com.bugtracker.ReadHelper;
import com.bugtracker.commands.*;
import com.bugtracker.dao.UsersDAO;
import com.bugtracker.dao.UsersDaoImpl;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import static com.bugtracker.model.Priority.*;
import static com.bugtracker.model.Status.PLANNED;

public class View {
    private static UsersDAO usersDao;
    private final Login login;
    private final Login register;
    private final TicketService ticketService;

    public View() {
        login = new LoginImpl();
        register = new RegisterImpl();
        ticketService = new TicketServiceImpl();
        usersDao = UsersDaoImpl.getInstance();
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
            case CREATE -> ticketService.create(createTicket());
            case EDIT -> ticketService.edit();
            case VIEW -> {
                System.out.println("Press Enter button to print all tickets or enter login to print certain user tickets:");
                ticketService.print();
            }
            case EXIT -> System.exit(0);
        }
    }

    public static Ticket createTicket() {
        Ticket ticket = new Ticket();
        ticket.setReporter(usersDao.getCurrentUser());

        System.out.println("\nEnter description for ticket or add/edit it later: ");
        String description = ReadHelper.readString();
        ticket.setDescription(description);

        System.out.println("\nEnter assignee login");
        String loginName = ReadHelper.readString();
        User assigneeUser = usersDao.getUserByLogin(loginName);
        if (assigneeUser != null) {
            ticket.setAssignee(assigneeUser);
        } else {
            ticket.setAssignee(null);
            System.out.println("This assignee doesn't exist. You can add it later.");
        }

        ticket.setStatus(PLANNED);

        System.out.println("\nEnter the digit to set priority: \n 1 - set \"Low\" priority\n 2 - set \"Medium\" priority \n 3 - set \"High\" priority");
        int variant = ReadHelper.readNumber();
        switch (variant) {
            case 1 -> ticket.setPriority(LOW);
            case 2 -> ticket.setPriority(MEDIUM);
            case 3 -> ticket.setPriority(HIGH);
            default -> {
                ticket.setPriority(LOW);
                System.out.println("You entered wrong variant. Priority has been changed to \"Low\". You can change it later.");
            }
        }

        System.out.println("\nSet estimated time (hours):");
        int estimatedTime = ReadHelper.readNumber();
        if (estimatedTime != 0) {
            ticket.setTimeEstimated(estimatedTime);
        } else {
            System.out.println("You can add estimated time later.");
        }
        System.out.println("\nTicket has been created!");
        return ticket;
    }

}
