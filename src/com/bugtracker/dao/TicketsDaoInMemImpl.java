package com.bugtracker.dao;

import com.bugtracker.model.Priority;
import com.bugtracker.model.Status;
import com.bugtracker.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketsDaoInMemImpl implements TicketsDAO{
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private static TicketsDaoInMemImpl instance = null;
    private int counter = 1;

    private TicketsDaoInMemImpl(){
        this.initTickets();
    }

    public static TicketsDaoInMemImpl getInstance(){
        if (instance == null)
            instance = new TicketsDaoInMemImpl();
        return instance;
    }

    @Override
    public Map<Integer, Ticket> getAllTickets() {
        return tickets;
    }

    @Override
    public void initTickets() {
        addTicket(new Ticket( "Creating project structure", UsersDaoInMemImpl.getInstance().getUserByLogin("alex"),
                UsersDaoInMemImpl.getInstance().getUserByLogin("alex"), Status.PLANNED, Priority.HIGH, 72));
        addTicket(new Ticket("Implementing Register class", UsersDaoInMemImpl.getInstance().getUserByLogin("alex"),
                UsersDaoInMemImpl.getInstance().getUserByLogin("max"), Status.PLANNED, Priority.MEDIUM, 24));
        addTicket(new Ticket("Implementing Ticket class", UsersDaoInMemImpl.getInstance().getUserByLogin("max"),
                UsersDaoInMemImpl.getInstance().getUserByLogin("andrew"), Status.PLANNED, Priority.LOW, 24));
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
}
