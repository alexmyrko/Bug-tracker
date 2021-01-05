package com.bugtracker.commands;

import com.bugtracker.ReadHelper;
import com.bugtracker.dao.*;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import static com.bugtracker.model.Priority.*;
import static com.bugtracker.model.Status.*;

public class TicketServiceImpl implements TicketService {
    private final TicketsDAO ticketsDAO;
    private final UsersDAO usersDao;

    public TicketServiceImpl() {
        ticketsDAO = TicketsDaoImpl.getInstance();
        usersDao = UsersDaoImpl.getInstance();
    }

    @Override
    public void create() {
        Ticket ticket = new Ticket();
        ticket.setReporter(usersDao.getCurrentUser());

        System.out.println("\nEnter description for ticket or add/edit it later: ");
        String description = ReadHelper.readString();
        ticket.setDescription(description);

        System.out.println("\nEnter assignee login");
        String loginName = ReadHelper.readString();
        User assigneeUser = usersDao.getAllUsers().get(loginName);
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

        ticketsDAO.addTicket(ticket);
        System.out.println("\nTicket has been created!");
    }

    @Override
    public void edit() {

    }

    @Override
    public void print() {

    }
}
