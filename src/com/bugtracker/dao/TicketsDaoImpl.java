package com.bugtracker.dao;

import com.bugtracker.model.Priority;
import com.bugtracker.model.Status;
import com.bugtracker.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketsDaoImpl implements TicketsDAO {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private static TicketsDaoImpl instance = null;
    private int counter = 1;

    private TicketsDaoImpl() {
        this.initTickets();
    }

    public static TicketsDaoImpl getInstance() {
        if (instance == null)
            instance = new TicketsDaoImpl();
        return instance;
    }

    @Override
    public void initTickets() {
        addTicket(new Ticket("Creating project structure", UsersDaoImpl.getInstance().getUserByLogin("alex"),
                UsersDaoImpl.getInstance().getUserByLogin("alex"), Status.PLANNED, Priority.HIGH, 72));
        addTicket(new Ticket("Implementing Register class", UsersDaoImpl.getInstance().getUserByLogin("alex"),
                UsersDaoImpl.getInstance().getUserByLogin("max"), Status.PLANNED, Priority.MEDIUM, 24));
        addTicket(new Ticket("Implementing Ticket class", UsersDaoImpl.getInstance().getUserByLogin("max"),
                UsersDaoImpl.getInstance().getUserByLogin("andrew"), Status.PLANNED, Priority.LOW, 24));
    }

    @Override
    public void addTicket(Ticket ticket) {
        int id = counter++;
        ticket.setId(id);
        tickets.put(id, ticket);
    }

    @Override
    public Ticket getTicketByID(int id) {
        return tickets.get(id);
    }


    @Override
    public Map<Integer, Ticket> getAllTickets() {
        return tickets;
    }
}
