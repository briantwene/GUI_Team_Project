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
public class Database {

    // variables for connection and for the resutls set
    Connection connection = null;

    String msAccDB = "Rent.accdb"; // path to the DB file
    String dbURL = "jdbc:ucanaccess://" + msAccDB;

    //constructor for the instance
    public Database() {

        try {

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

    //function for executing the query and returning the 
    public ResultSet executeQuery(String query) {

        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM Vehicle");
            
     
           

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {
            return resultSet;

        }

    }

    public static void main(String[] args) {
        ResultSet result = new Database().executeQuery("reee");
        try {
            System.out.println(result.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

} // End of Class

