package com.bugtracker.dao;

import com.bugtracker.model.Priority;
import com.bugtracker.model.Status;
import com.bugtracker.model.Ticket;
import com.bugtracker.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TicketsDaoSQLImpl implements TicketsDAO{
    private final Connection connection;
    private ResultSet resultSet;
    private static TicketsDaoSQLImpl instance;
    private UsersDaoSQLImpl usersDaoSQL;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int counter = 1;

    private TicketsDaoSQLImpl(){
        connection = SqlConnector.getConnection();
        usersDaoSQL = UsersDaoSQLImpl.getInstance();
        initTickets();
    }

    public static TicketsDaoSQLImpl getInstance(){
        if (instance == null)
            instance = new TicketsDaoSQLImpl();
        return instance;
    }

    @Override
    public void initTickets() {
        String createTable = "CREATE TABLE IF NOT EXISTS tickets (\n" +
                "id int NOT NULL AUTO_INCREMENT,\n" +
                "description varchar(200) NOT NULL,\n" +
                "reporter varchar(16) NOT NULL,\n" +
                "assignee varchar(16) NOT NULL,\n" +
                "status varchar(10) NOT NULL,\n" +
                "priority varchar(10) NOT NULL,\n" +
                "timeSpent int NOT NULL,\n" +
                "timeEstimated int NOT NULL,\n" +
                "creationDate  DATETIME NOT NULL,\n" +
                "PRIMARY KEY (id));";
        LocalDateTime currentDateTime = LocalDateTime.now();
        String date = currentDateTime.format(dateTimeFormatter);

        String initTable = "INSERT INTO tickets VALUES (1,'Creating project structure','alex','alex','PLANNED','MEDIUM',0,36,'" + date + "')," +
                "(2,'Implementing Register class','alex','max','PLANNED','MEDIUM',0,24,'" + date + "')," +
                "(3,'Implementing Ticket class','max','andrew','PLANNED','LOW',0,18,'" + date + "')," +
                "(4,'Implementing User class','alex','ivan','PLANNED','LOW',0,20,'" + date + "')";


        try {
            Statement statement = connection.createStatement();
            statement.getConnection();
            statement.executeUpdate(createTable);
            if (!getResultSet("SELECT * FROM tickets").next())
                statement.executeUpdate(initTable);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Map<Integer, Ticket> getAllTickets() {
        Map<Integer, Ticket> ticketsMap = new HashMap<>();
        resultSet = getResultSet("SELECT * FROM tickets");
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                User reporter = usersDaoSQL.getUserByLogin(resultSet.getString("reporter"));
                User assignee = usersDaoSQL.getUserByLogin(resultSet.getString("assignee"));
                Status status = Status.valueOf(resultSet.getString("status"));
                Priority priority = Priority.valueOf(resultSet.getString("priority"));
                int timeSpent = resultSet.getInt("timeSpent");
                int timeEstimated = resultSet.getInt("timeEstimated");
                LocalDateTime dateTime = resultSet.getObject("creationDate", LocalDateTime.class);
                Ticket ticket = new Ticket(id, description, reporter, assignee, status, priority, timeSpent, timeEstimated, dateTime);
                ticketsMap.put(id, ticket);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticketsMap;
    }

    @Override
    public void addTicket(Ticket ticket) {
        int id = ticket.getId();
        String description = ticket.getDescription();
        String reporter = usersDaoSQL.getLoginByUser(ticket.getReporter());
        String assignee = usersDaoSQL.getLoginByUser(ticket.getAssignee());
        String status = ticket.getStatus().toString();
        String priority = ticket.getPriority().toString();
        int timeSpent = ticket.getTimeSpent();
        int timeEstimated = ticket.getTimeEstimated();
        int totalTime = ticket.getTimeSpent() + ticket.getTimeEstimated();
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);
        String queryAdd = "INSERT INTO tickets VALUES ('" + id + "','" + description + "','" + reporter + "','" + assignee + "','" +
            status + "','" + priority + "','" + timeSpent + "','" + timeEstimated + "','" + dateTime + "')";
        try {
            Statement statement = connection.createStatement();
            statement.getConnection();
            statement.executeUpdate(queryAdd);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Ticket getTicketByID(int id) {
        Ticket ticket = null;
        resultSet = getResultSet("SELECT * FROM tickets WHERE id = " + id);
        try {
            if (resultSet.next()) {
                String description = resultSet.getString("description");
                User reporter = usersDaoSQL.getUserByLogin(resultSet.getString("reporter"));
                User assignee = usersDaoSQL.getUserByLogin(resultSet.getString("assignee"));
                Status status = Status.valueOf(resultSet.getString("status"));
                Priority priority = Priority.valueOf(resultSet.getString("priority"));
                int timeSpent = resultSet.getInt("timeSpent");
                int timeEstimated = resultSet.getInt("timeEstimated");
                LocalDateTime dateTime = LocalDateTime.parse(resultSet.getString("creationDate"), dateTimeFormatter);
                ticket = new Ticket(id, description, reporter, assignee, status, priority, timeSpent, timeEstimated, dateTime);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticket;
    }

    public ResultSet getResultSet(String query){
        ResultSet resultSet = null;
        try{
            Statement statement = connection.createStatement();
            statement.getConnection();
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return resultSet;
    }
}
