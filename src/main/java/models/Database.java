/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author twene
 */

// database class that executes all the queries from the DAOs (Data Access
// Objects)
public class Database {

    // variables for connection and for the resutls set
    Connection connection = null;

    String msAccDB = "Rent.accdb"; // path to the DB file
    String dbURL = "jdbc:ucanaccess://" + msAccDB;

    // constructor for the instance
    public Database() {

        try {
            // try and connect to the database catch any errors
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection
        // Step 2.A: Create and get connection using DriverManager class
        try {
            connection = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // function for executing the select queries returns a JDBC resultSet
    public ResultSet executeQuery(String query) {

        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery(query);

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {
            return resultSet;
        }

    }

    // function for executing insert and update queries retuns an int based on the
    // outcome
    public int executeUpdateQuery(String query) {

        Statement statement = null;

        int result = 0;
        try {

            // Creating JDBC Statement
            statement = connection.createStatement();

            // Executing SQL return an int that will determine if the query was successful-
            result = statement.executeUpdate(query);

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
        return result;

    }

    public static void main(String[] args) {

    }

} // End of Class
