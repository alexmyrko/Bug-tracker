package com.bugtracker.commands;

import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;

public interface TicketService {
    void create(Ticket ticket);
    void printByAssigneeUser(User user);
    void printAll();
    Ticket getTicketByID(int id);
}
