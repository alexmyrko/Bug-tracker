package com.bugtracker.dao;
import com.bugtracker.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UsersDaoSQLImpl implements UsersDAO{
    private final Connection connection;
    private Statement statement = null;
    private ResultSet resultSet;
    private static UsersDaoSQLImpl instance = null;
    private User curentUser;

    private UsersDaoSQLImpl() {
        connection = SqlConnector.getConnection();
        initUsers();
    }

    public static UsersDaoSQLImpl getInstance(){
        if (instance == null)
            instance = new UsersDaoSQLImpl();
        return instance;
    }

    @Override
    public void initUsers() {
        String createTable = "CREATE TABLE IF NOT EXISTS users (\n" +
                "login varchar(16) NOT NULL,\n" +
                "username varchar(40) NOT NULL,\n" +
                "pass varchar(16) NOT NULL);";
        String initTable = "INSERT INTO users VALUES ('alex','Alexander Myrko','cursor1'),('max','Maksym Protsenko','cursor2')," +
                "('andrew','Andriy Farenyuk','cursor3'),('ivan','Ivan Hodachiy','cursor4')";

        System.out.println("Initialized !");
        try {
            Statement statement = connection.createStatement();
            statement.getConnection();
            statement.executeUpdate(createTable);
            if (!getResultSet("SELECT * FROM users").next())
                statement.executeUpdate(initTable);
            statement.clearBatch();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Map<String, User> getAllUsers() {
        Map<String, User> users = new HashMap<>();
            resultSet = getResultSet("SELECT * FROM users");
            try {
                while (resultSet.next()) {
                    User user;
                    String login = resultSet.getString("login");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("pass");
                    user = new User(username, password);
                    users.put(login, user);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return users;
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

    @Override
    public void addUser(String login, User user) {
        String addUserQuery = "INSERT INTO users(login,username,pass)\n" +
                "VALUES('" + login + "','" + user.getUserName() + "','" + user.getPassword() + "');";
        System.out.println(addUserQuery);
        try {
            Statement statement = connection.createStatement();
            statement.getConnection();
            statement.execute(addUserQuery);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        System.out.println("SELECT * FROM users WHERE login = '" + login + "'");
        resultSet = getResultSet("SELECT * FROM users WHERE login = '" + login + "'");
        try {
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("pass");
                user = new User(username, password);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void setCurrentUser(User user) {
        curentUser = user;
    }

    @Override
    public User getCurrentUser() {
        return curentUser;
    }

    @Override
    public String getLoginByUser(User user) {
        Map<String, User> usersMap = getAllUsers();
        for (Map.Entry<String, User> entry : usersMap.entrySet())
            if (entry.getValue().getUserName().equals(user.getUserName()) && entry.getValue().getPassword().equals(user.getPassword()))
                return entry.getKey();
        return "";
    }
}
