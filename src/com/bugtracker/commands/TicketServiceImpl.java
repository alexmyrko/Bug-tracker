package com.bugtracker.commands;

import com.bugtracker.BugTracker;
import com.bugtracker.dao.MemoryModel;
import com.bugtracker.dao.TicketsDAO;
import com.bugtracker.dao.TicketsDaoInMemImpl;
import com.bugtracker.dao.TicketsDaoSQLImpl;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.util.ArrayList;
import java.util.Map;

public class TicketServiceImpl implements TicketService {
    private final TicketsDAO ticketsDAO;
    public TicketServiceImpl(){
        if (BugTracker.getMemoryModel() == MemoryModel.INMEM)
            ticketsDAO = TicketsDaoInMemImpl.getInstance();
        else ticketsDAO = TicketsDaoSQLImpl.getInstance();
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
                if (user.equals(assignee)) {
                    assigneeTickets.add(ticket);
                }
            }
        }
        return assigneeTickets;
    }
}
