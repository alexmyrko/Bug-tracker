package com.bugtracker.commands;

import com.bugtracker.model.Ticket;

public interface TicketService {
    void create(Ticket ticket);
    void print();
    Ticket getTicketByID(int id);
}
