package com.bugtracker.commands;

import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

import java.util.Map;

public interface TicketService {
    void create();
    void print();
    Ticket getTicketByID(int id);
}
