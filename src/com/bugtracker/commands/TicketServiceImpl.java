package com.bugtracker.commands;

import com.bugtracker.dao.TicketsDAO;
import com.bugtracker.dao.TicketsDaoImpl;
import com.bugtracker.model.Ticket;

import com.bugtracker.dao.*;
import com.bugtracker.model.Ticket;


public class TicketServiceImpl implements TicketService {
    private final TicketsDAO ticketsDAO;
    public TicketServiceImpl(){
        ticketsDAO = TicketsDaoImpl.getInstance();
    }

    @Override
    public void create(Ticket ticket) {
        ticketsDAO.addTicket(ticket);
    }


    @Override
    public void print() {

    }

    public Ticket getTicketByID(int id){
        return ticketsDAO.getTicketByID(id);
    }


}
