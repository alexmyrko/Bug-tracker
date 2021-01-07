package com.bugtracker.commands;

import com.bugtracker.BugTracker;
import com.bugtracker.dao.MemoryModel;
import com.bugtracker.dao.TicketsDAO;
import com.bugtracker.dao.TicketsDaoInMemImpl;
import com.bugtracker.dao.TicketsDaoSQLImpl;
import com.bugtracker.model.Ticket;

public class TicketServiceImpl implements TicketService {
    private final TicketsDAO ticketsDAO;
    public TicketServiceImpl(){
        if (BugTracker.getMemoryModel() == MemoryModel.INMEM)
            ticketsDAO = TicketsDaoInMemImpl.getInstance();
        else ticketsDAO = TicketsDaoSQLImpl.getInstance();
    }

    @Override
    public void create(Ticket ticket) {
        ticketsDAO.addTicket(ticket);
    }

    public Ticket getTicketByID(int id){
        return ticketsDAO.getTicketByID(id);
    }

}
