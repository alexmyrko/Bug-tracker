package com.bugtracker.dao;

import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.util.Map;

public interface TicketsDAO {
    void initTickets();

    void addTicket(Ticket ticket);

    Ticket getTicketByID(int id);

    Map<Integer, Ticket> getAllTickets();
}
