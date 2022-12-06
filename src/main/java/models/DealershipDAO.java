package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

// Dealership Data Access Object

// one of the core DAOs

// holds methods for running queries to do with rentals, purchases and profle
public class DealershipDAO {

    Database db;

    // create a database instance to interact with
    public DealershipDAO() {

        db = new Database();

    }

    // the methods will execute a certain query and return the as an array of
    // Objects that are models for the different parts of the application
    // or nothing if its just for inserting or updating

    // getting the users rental history
    public ArrayList<Object[]> getRentals(int userId) {
        String query = "Select Rent.RentStartDate, Rent.RentReturnDate, Rent.RentNoOfDays, Vehicle.VehicleMake, Vehicle.VehicleModel, Vehicle.VehicleType from Vehicle LEFT JOIN Rent on Rent.VehicleID = Vehicle.VehicleID where Rent.RentReturnDate > NOW() and UserID ="
                + userId;
        ArrayList<Object[]> tableMap = new ArrayList<>();
        ResultSet results = db.executeQuery(query);

        try {
            while (results.next()) {

                Date rentStartDate = results.getDate("RentStartDate");
                Date rentReturnDate = results.getDate("RentReturnDate");
                int rentNoOfDays = results.getInt("RentNoOfDays");
                String vehicleMake = results.getString("VehicleMake");
                String vehicleModel = results.getString("vehicleModel");
                String vehicleType = results.getString("VehicleType");

                Object[] row = { rentStartDate, rentReturnDate, rentNoOfDays, vehicleMake, vehicleModel,
                        vehicleType };
                tableMap.add(row);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tableMap;

    }

    // getting the users current rental if any
    public CurrentRentalModel getCurrentRental(int userId) {
        String query = String.format(
                "Select Rent.RentID, Rent.RentStartDate, Rent.RentReturnDate, Rent.RentNoOfDays, Vehicle.VehicleMake, Vehicle.VehicleModel, Vehicle.VehicleImage Vehicle.VehicleType, Vehicle.VehicleRarity, Vehicle.VehiclePassengers, Vehicle.VehicleAvailability FROM Vehicle LEFT JOIN Rent on Rent.VehicleID = Vehicle.VehicleID where Rent.RentReturnDate > NOW() and Rent.UserID = %s",
                userId);

        CurrentRentalModel currentRent = null;
        ResultSet results = db.executeQuery(query);

        try {
            while (results.next()) {
                int rentId = results.getInt("RentID");
                Date rentStarDate = results.getDate("RentStartDate");
                Date rentReturnDate = results.getDate("RentReturnDate");
                int rentNoOfDays = results.getInt("RentNoOfDays");
                String vehicleMake = results.getString("VehicleMake");
                String vehicleModel = results.getString("VehicleModel");
                String vehicleType = results.getString("VehicleType");
                int vehiclePassengers = results.getInt("VehiclePassengers");
                Boolean vehicleAvailability = results.getBoolean("VehicleAvailability");
                String vehicleImage = results.getString("VehicleImage");
                currentRent = new CurrentRentalModel(rentStarDate, rentReturnDate,
                        rentNoOfDays, vehicleMake,
                        vehicleModel,
                        vehicleType, vehicleType, vehiclePassengers, vehicleAvailability, vehicleImage, rentId);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return currentRent;
    }

    // getting the users purchase history
    public ArrayList<Object[]> getPurchases(int userId) {

        String query = "SELECT Purchase.PurchaseID, Vehicle.VehicleMake, Vehicle.VehicleModel, Vehicle.VehiclePrice FROM Purchase LEFT JOIN Vehicle ON Purchase.VehicleID = Vehicle.VehicleID WHERE Purchase.UserID "
                + userId;
        ;
        ArrayList<Object[]> tableMap = new ArrayList<>();
        ResultSet results = db.executeQuery(query);

        if (results == null) {

        } else {
            try {
                while (results.next()) {

                    int purchaseId = results.getInt(1);
                    String vehicleMake = results.getString("VehicleMake");
                    String vehicleModel = results.getString("VehicleModel");
                    int vehiclePrice = results.getInt("VehiclePrice");

                    Object[] row = { purchaseId, vehicleMake, vehicleModel, vehiclePrice };
                    tableMap.add(row);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return tableMap;

    }

    // adding purchase data to the db when a user purchases a car
    public void addPurchase(PurchaseModel purchase) {

        String query = String.format(
                "insert into Purchase ( UserID, VehicleID, VehiclePrice) VALUES ( %s, %s, %s); update Vehicle SET VehicleAvailability = %s WHERE VehicleID = %s;",
                purchase.getUserId(), purchase.getVehicleId(), purchase.getVehiclePrice(), false,
                purchase.getVehicleId());

        ResultSet results = db.executeQuery(query);

        try {
            if (results.next()) {
                JOptionPane.showMessageDialog(null, "Purchase has been made");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // adding rental to the database can be later retrived by getCurrentRental()
    public void addRental(RentModel rental) {

        String query = String.format(
                "insert into Rent (RentStartDate, RentReturnDate, RentNoOfDays, VehicleID, UserID) VALUES ('%s', '%s', %s, %s, %s); update Vehicle SET VehicleAvailability = %s WHERE VehicleID = %s;",
                rental.getRentStartDate(), rental.getRentReturnDate(), rental.getRentNoOfDays(), rental.getVehicleId(),
                rental.getUserId(), false, rental.getVehicleId());

        int results = db.executeUpdateQuery(query);

        if (results > 0) {
            JOptionPane.showMessageDialog(null, "Car Rented successfully");
        } // TODO Auto-generated catch block

    }

    // for updating the user profile
    public void updateProfile(UserModel user) {

        String query = String.format(
                "update User SET Username = %s, FirstName = %s, LastName = %s WHERE UserID = %s",
                user.getUsername(), user.getFirstname(), user.getLastname(), user.getUserId());

        int results = db.executeUpdateQuery(query);

        if (results > 0) {
            JOptionPane.showMessageDialog(null, "Profile Updated successfully");
        } // TODO Auto-generated catch block

    }

    // update rental record ideally for when a user returns a car
    public void updateRental(RentModel rental) {
        String query = String.format(
                "update Rent SET RentReturnDate = '%s', RentNoOfDays = %s WHERE UserID = %s AND Vehicle = %s",
                rental.getRentReturnDate(), rental.getRentNoOfDays(), rental.getUserId(), rental.getVehicleId());

        int results = db.executeUpdateQuery(query);

        if (results > 0) {
            JOptionPane.showMessageDialog(null, "Car has been successfully Returned");
        } // TODO Auto-generated catch block

    }

}
