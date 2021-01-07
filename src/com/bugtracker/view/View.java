package com.bugtracker.view;

import com.bugtracker.Operation;
import com.bugtracker.ReadHelper;
import com.bugtracker.commands.*;
import com.bugtracker.dao.MemoryModel;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.Priority;
import com.bugtracker.model.Status;
import com.bugtracker.model.User;
import java.util.Map;

public class View {
    private final Login login;
    private final Login register;
    private final TicketService ticketService;
    private final UserService userService;
    public View() {
        login = new LoginImpl();
        register = new RegisterImpl();
        ticketService = new TicketServiceImpl();
        userService = new UserServiceImpl();
    }

    public MemoryModel memoryModel(){
        System.out.println("Choose memory model:\n" +
                "1 - In Memory\n" +
                "2 - MySQL database");
        return MemoryModel.values()[ReadHelper.readNumber() - 1];
    }

    public void login() {
        User currentUser = null;
        while (true) {
            Operation operation = Operation.getLoginOperationByOrdinal();
            switch (operation) {
                case LOGIN -> currentUser = login.execute();
                case REGISTER -> currentUser = register.execute();
                case EXIT -> System.exit(0);
            }
            if (currentUser != null) {
                break;
            }
        }
    }

    public void routine() {
        while (true) {
            Operation operation = Operation.getRoutineOperationByOrdinal();
            switch (operation) {
                case CREATE -> ticketService.create(createTicket());
                case EDIT -> editTicket();
                case VIEW -> {
                    System.out.println("Press Enter button to print all tickets or enter login to print certain user tickets:");
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    public Ticket createTicket() {
        Ticket ticket = new Ticket();
        ticket.setReporter(userService.getCurrentUser());

        System.out.println("\nEnter description for ticket or add/edit it later: ");
        String description = ReadHelper.readString();
        ticket.setDescription(description);

        System.out.println("\nEnter assignee login");
        String loginName = ReadHelper.readString();
        User assigneeUser = userService.getUserByLogin(loginName);
        if (assigneeUser != null) {
            ticket.setAssignee(assigneeUser);
        } else {
            ticket.setAssignee(null);
            System.out.println("This assignee doesn't exist. You can add it later.");
        }

        ticket.setStatus(Status.PLANNED);

        System.out.println("\nEnter the digit to set priority: \n 1 - set \"Low\" priority\n 2 - set \"Medium\" priority \n 3 - set \"High\" priority");
        int variant = ReadHelper.readNumber();
        switch (variant) {
            case 1 -> ticket.setPriority(Priority.LOW);
            case 2 -> ticket.setPriority(Priority.MEDIUM);
            case 3 -> ticket.setPriority(Priority.HIGH);
            default -> {
                ticket.setPriority(Priority.LOW);
                System.out.println("You entered wrong variant. Priority has been changed to \"Low\". You can change it later.");
            }
        }

        System.out.println("\nSet estimated time (hours):");
        int estimatedTime = ReadHelper.readNumber();
        if (estimatedTime != 0) {
            ticket.setTimeEstimated(estimatedTime);
        } else {
            System.out.println("You can add estimated time later.");
        }
        System.out.println("\nTicket has been created!");
        return ticket;
    }


    public void editTicket() {
        Ticket ticket = null;
        int ticketOperation = 0;
        while(ticket == null) {
            System.out.println("Enter ticket ID, which should be edited: ");
            int id = ReadHelper.readNumber();
            ticket = ticketService.getTicketByID(id);
        }
        while(true) {
            System.out.println(ticket.toString());
            System.out.println("Choose ticket field to modify: \n1 - Description\n2 - Assignee\n3 - Status\n4 - Priority\n" +
                    "5 - Time Spent\n6 - Time estimated\n7 - Exit to main menu");
            ticketOperation = ReadHelper.readNumber();
            switch (ticketOperation){
                case 1 -> editDescription(ticket);
                case 2 -> editAssignee(ticket);
                case 3 -> editStatus(ticket);
                case 4 -> editPriority(ticket);
                case 5 -> editTimeSpent(ticket);
                case 6 -> editTimeEstimated(ticket);
                case 7 -> {return;}
            }
        }
    }
    private void editDescription(Ticket ticket){
        System.out.println("Current description: " + ticket.getDescription() + "\nEnter new description:");
        ticket.setDescription(ReadHelper.readString());
    }

    private void editAssignee(Ticket ticket){
        User user = null;
        System.out.print("Current assignee: ");
        if (ticket.getAssignee() == null)
            System.out.println("NONE");
        else System.out.printf(ticket.getAssignee().getUserName());
        System.out.println("\nAvailable assignees: ");
        for(Map.Entry<String, User> entry : userService.getAllUsers().entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue().getUserName());
        while(user == null) {
            System.out.print("Enter login corresponding to Assignee: ");
            user = userService.getUserByLogin(ReadHelper.readString());
        }
        System.out.println("Assignee is: " + user.getUserName() + "\n");
        ticket.setAssignee(user);
    }

    private void editStatus(Ticket ticket){
        Status status = null;
        Status currentStatus = ticket.getStatus();
        System.out.println("Current status is: " + currentStatus);
        if (currentStatus == Status.PLANNED)
            System.out.print("You can switch to next available INWORK status. Confirm 'y' to switch: ");
        else if (currentStatus == Status.INWORK)
            System.out.print("You can switch to next available DONE status. Confirm 'y' to switch: ");
        else {
            System.out.println("You cannot change it !");
            return;
        }
        String answer = ReadHelper.readString();
        if (!answer.equalsIgnoreCase("y"))
            return;
        else{
            switch (currentStatus) {
                case PLANNED -> status = Status.INWORK;
                case INWORK -> status = Status.DONE;
            }
            System.out.println("New status is: " + status);
            ticket.setStatus(status);
        }
    }

    private void editPriority(Ticket ticket) {
        Priority priority = null;
        System.out.println("Current priority is: " + ticket.getPriority());
        while (priority == null) {
            System.out.print("Choose one from available priorities: ");
            for(Priority element : Priority.values())
                System.out.print(element + "  ");
            System.out.println();
            priority = Priority.valueOf(ReadHelper.readString());
        }
        ticket.setPriority(priority);
        System.out.println("New priority is: " + priority);
    }

    private void editTimeSpent(Ticket ticket){
        int timeSpent = -1;
        System.out.println("Current time spent is: " + ticket.getTimeSpent() + " hrs");
        while (timeSpent < ticket.getTimeSpent()) {
            System.out.println("Enter new value in hours: ");
            timeSpent = ReadHelper.readNumber();
        }
        System.out.println("New time spent value: " + timeSpent);
        int totalTime = ticket.getTimeEstimated() + timeSpent;
        ticket.setTimeSpent(timeSpent);
        ticket.setTimeEstimated(totalTime - timeSpent);
    }

    private void editTimeEstimated(Ticket ticket){
        int timeEstimated = -1;
        System.out.println("Current time estimated is: " + ticket.getTimeEstimated() + " hrs");
        while (timeEstimated < 0) {
            System.out.println("Enter new value in hours: ");
            timeEstimated = ReadHelper.readNumber();
        }
        System.out.println("New time estimated value: " + timeEstimated);
        ticket.setTimeEstimated(timeEstimated);
    }


}
