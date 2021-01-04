package com.bugtracker.commands;

import com.bugtracker.dao.TicketsDAO;
import com.bugtracker.dao.TicketsDaoImpl;
import com.bugtracker.model.User;

public class TicketServiceImpl implements TicketService{
    private final TicketsDAO ticketsDAO;
    public TicketServiceImpl(){
        ticketsDAO = TicketsDaoImpl.getInstance();
    }

    @Override
    public void create() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void print() {

    }
}
