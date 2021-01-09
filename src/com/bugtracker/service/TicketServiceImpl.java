package com.bugtracker.service;

import com.bugtracker.BugTracker;
import com.bugtracker.dao.*;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.util.ArrayList;
import java.util.Map;

public class TicketServiceImpl implements TicketService {
    private final TicketsDAO ticketsDAO;
    private final UsersDAO usersDAO;
    public TicketServiceImpl() {
        if (BugTracker.getMemoryModel() == MemoryModel.INMEM) {
            ticketsDAO = TicketsDaoInMemImpl.getInstance();
            usersDAO = UsersDaoInMemImpl.getInstance();
        }
        else{
                ticketsDAO = TicketsDaoSQLImpl.getInstance();
                usersDAO = UsersDaoSQLImpl.getInstance();
            }

        }

    @Override
    public void create(Ticket ticket) {
        ticketsDAO.addTicket(ticket);
    }

    @Override
    public void printAll() {
        Map<Integer, Ticket> allTickets = ticketsDAO.getAllTickets();
        for (Map.Entry<Integer, Ticket> entry : allTickets.entrySet()) {
            Ticket ticket = entry.getValue();
            System.out.println(ticket);
        }
    }

    public Ticket getTicketByID(int id) {
        return ticketsDAO.getTicketByID(id);
    }

    @Override
    public ArrayList<Ticket> getTicketsByAssignee(User user) {
        ArrayList<Ticket> assigneeTickets = new ArrayList<>();
        Map<Integer, Ticket> allTickets = ticketsDAO.getAllTickets();
        if (user != null) {
            for (Map.Entry<Integer, Ticket> entry : allTickets.entrySet()) {
                Ticket ticket = entry.getValue();
                User assignee = ticket.getAssignee();

                if (user == assignee) {
                    assigneeTickets.add(ticket);
                }
            }
        }
        return assigneeTickets;
    }
}
