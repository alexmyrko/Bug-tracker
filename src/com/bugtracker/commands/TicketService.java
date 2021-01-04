package com.bugtracker.commands;

import com.bugtracker.model.User;

public interface TicketService {
    public void create(User currentUser);
    public void edit(User currentUser);
    public void print();
}
