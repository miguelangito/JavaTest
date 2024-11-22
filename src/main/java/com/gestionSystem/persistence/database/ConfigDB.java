package com.gestionSystem.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    //Contains the status of the db

    static Connection objConnection = null;

    //method to open the connection with java and the databse

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gestionSystem";
            String user = "root";
            String password = "tupassword";

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> driver not installed " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error >> cant make the connection with the database");
        }
        return objConnection;
    }


    public static void closeConnection() {
        try {
            if (objConnection != null) objConnection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}