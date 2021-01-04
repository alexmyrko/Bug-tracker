package com.bugtracker.commands;

import com.bugtracker.dao.TicketsDAO;
import com.bugtracker.dao.TicketsDaoImpl;
import com.bugtracker.model.User;

public class TicketServiceImpl implements TicketService{
    private TicketsDAO ticketsDAO;
    public TicketServiceImpl(){
        ticketsDAO = TicketsDaoImpl.getInstance();
    }

    @Override
    public void create(User currentUser) {

    }

    @Override
    public void edit(User currentUser) {

    }

    @Override
    public void print() {
        System.out.println("Press Enter button to print all tickets or enter login to print certain user tickets:");
    }
}
