package com.bugtracker;

import com.bugtracker.ticket.Ticket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BugTracker {
    // Untill tickets receiving will be implemented via DAO
    Map<Integer, Ticket> tickets = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BugTracker tracker = new BugTracker();

    }
}
