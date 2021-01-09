package com.bugtracker.service;

import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;
import java.util.ArrayList;

public interface TicketService {
    void create(Ticket ticket);
    void printAll();
    Ticket getTicketByID(int id);
    ArrayList<Ticket> getTicketsByAssignee (User user);
}
