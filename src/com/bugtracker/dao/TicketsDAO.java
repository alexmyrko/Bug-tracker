package com.bugtracker.dao;

import com.bugtracker.model.Ticket;
import java.util.Map;

public interface TicketsDAO {
    void initTickets();

    Map<Integer, Ticket> getAllTickets();

    void addTicket(Ticket ticket);

}
