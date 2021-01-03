package com.bugtracker.dao;

import com.bugtracker.model.Ticket;

import java.util.Map;

public interface TicketsDAO {
    void initTickets();
    Map<Integer, Ticket> getAllTickets();
    void createTicket(Ticket ticket);
    void editTicket(Ticket ticket);
}
