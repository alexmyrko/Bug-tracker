package com.bugtracker.dao;

import com.bugtracker.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketsDaoImpl implements TicketsDAO{
    private static Map<Integer, Ticket> tickets = new HashMap<>();
    private static TicketsDaoImpl instance = null;

    private TicketsDaoImpl(){
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

    }

    @Override
    public void createTicket(Ticket ticket) {

    }

    @Override
    public void editTicket(Ticket ticket) {

    }
}
