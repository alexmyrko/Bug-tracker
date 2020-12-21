package com.bugtracker.commands;

// You need implement interface method for exiting from current program
public class ExitCommand implements Login {
    @Override
    public void execute() {
        System.out.println("End of program executing");

    }
}
