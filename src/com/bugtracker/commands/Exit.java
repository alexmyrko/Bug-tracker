package com.bugtracker.commands;

// You need implement interface method for exiting from current program
<<<<<<< HEAD:src/com/bugtracker/commands/Exit.java
public class Exit {

=======
public class ExitCommand implements Login {
    @Override
    public void execute() {
        System.out.println("End of program executing");

    }
>>>>>>> main:src/com/bugtracker/commands/ExitCommand.java
}
