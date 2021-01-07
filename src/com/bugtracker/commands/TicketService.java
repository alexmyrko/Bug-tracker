package com.bugtracker.commands;

import com.bugtracker.model.Ticket;

import java.util.Map;

public interface TicketService {
    void create(Ticket ticket);
    Ticket getTicketByID(int id);
}
