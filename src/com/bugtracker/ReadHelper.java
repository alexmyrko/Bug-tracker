package com.bugtracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String text = null;
        try {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static int readNumber(){
        while(true) {
            try {
                int n = Integer.parseInt(readString());
                return n;
            } catch (IllegalArgumentException e){
                System.out.print("Enter a number: ");
            }
        }
    }


    // Should receive from console decimal id number, check and return ticket if id exist
    public int chooseTicketId(){
        int ticketId = 0;


        return ticketId;
    }

}
