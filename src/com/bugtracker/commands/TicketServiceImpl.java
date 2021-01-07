package com.bugtracker.commands;

import com.bugtracker.dao.TicketsDAO;
import com.bugtracker.dao.TicketsDaoImpl;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.util.Map;

public class TicketServiceImpl implements TicketService {
    private final TicketsDAO ticketsDAO;


    public TicketServiceImpl() {
        ticketsDAO = TicketsDaoImpl.getInstance();
    }

    @Override
    public void create(Ticket ticket) {
        ticketsDAO.addTicket(ticket);
    }

    @Override
    public void printByAssigneeUser(User user) {
        Map<Integer, Ticket> allTickets = ticketsDAO.getAllTickets();
        if (user != null) {
            for (Map.Entry<Integer, Ticket> entry : allTickets.entrySet()) {
                Ticket ticket = entry.getValue();
                User assignee = ticket.getAssignee();
                if (assignee != null && user.equals(assignee)) {
                    System.out.println(ticket.toString());
                }
            }
        } else {
            System.out.println("This assignee isn`t exist!\n");
        }
    }

    @Override
    public void printAll() {
        Map<Integer, Ticket> allTickets = ticketsDAO.getAllTickets();
        for (Map.Entry<Integer, Ticket> entry : allTickets.entrySet()) {
            Ticket ticket = entry.getValue();
            System.out.println(ticket.toString());
        }
    }

    public Ticket getTicketByID(int id) {
        return ticketsDAO.getTicketByID(id);
    }
}
