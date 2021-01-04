package com.bugtracker.dao;

import com.bugtracker.model.Priority;
import com.bugtracker.model.Status;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.util.HashMap;
import java.util.Map;

public class TicketsDaoImpl implements TicketsDAO{
    private static Map<Integer, Ticket> tickets = new HashMap<>();
    private static TicketsDaoImpl instance = null;
    int counter = 1;

    private TicketsDaoImpl(){
        this.initTickets();
    }

    public static TicketsDaoImpl getInstance(){
        if (instance == null)
            instance = new TicketsDaoImpl();
        return instance;
    }

    @Override
    public Map<Integer, Ticket> getAllTickets() {
        return tickets;
    }

    @Override
    public void initTickets() {
        int id = counter++;
        tickets.put(id, new Ticket(id, "Creating project structure", UsersDaoImpl.getInstance().getUserByLogin("alex"),
                UsersDaoImpl.getInstance().getUserByLogin("alex"), Status.PLANNED, Priority.HIGH, 72));
        id = counter++;
        tickets.put(id, new Ticket(id, "Implementing Register class", UsersDaoImpl.getInstance().getUserByLogin("alex"),
                UsersDaoImpl.getInstance().getUserByLogin("max"), Status.PLANNED, Priority.MEDIUM, 24));
        id = counter++;
        tickets.put(id, new Ticket(id, "Implementing Ticket class", UsersDaoImpl.getInstance().getUserByLogin("max"),
                UsersDaoImpl.getInstance().getUserByLogin("andrew"), Status.PLANNED, Priority.LOW, 24));
    }

    @Override
    public void addTicket(Integer id, Ticket ticket) {
        tickets.put(id, ticket);
    }
}
