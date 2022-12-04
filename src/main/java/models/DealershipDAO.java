package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class DealershipDAO {

    Database db;

    public DealershipDAO() {

        db = new Database();

    }

    public ArrayList<Object[]> getRentals() {
        String query = "Select Rent.RentStartDate, Rent.RentReturnDate, Rent.RentNoOfDays, Vehicle.VehicleMake, Vehicle.VehicleModel, Vehicle.VehicleType from Vehicle LEFT JOIN Rent on Rent.VehicleID = Vehicle.VehicleID where Rent.RentReturnDate > NOW() and UserID = 1";
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

                System.out.println(rentStartDate);
                System.out.println(rentReturnDate);
                System.out.println(rentNoOfDays);

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

    public CurrentRentalModel getCurrentRental() {
        String query = "Select Rent.RentStartDate, Rent.RentReturnDate, Rent.RentNoOfDays, Vehicle.VehicleMake, Vehicle.VehicleModel, Vehicle.VehicleType, Vehicle.VehicleRarity, Vehicle.VehiclePassengers from Rent LEFT JOIN Vehicle on Rent.VehicleID = Vehicle.VehicleID where RentReturnDate > NOW() and UserID = 1";

        CurrentRentalModel currentRent = null;
        ResultSet results = db.executeQuery(query);

        try {
            results.first();

            Date rentStarDate = results.getDate("RentStartDate");
            Date rentReturnDate = results.getDate("RentReturnDate");
            int rentNoOfDays = results.getInt("RentNoOfDays");
            String vehicleMake = results.getString("VehicleMake");
            String vehicleModel = results.getString("vehicleModel");
            String vehicleType = results.getString("VehicleType");
            int VehiclePassengers = results.getInt("VehiclePassengers");

            currentRent = new CurrentRentalModel(rentStarDate, rentReturnDate, rentNoOfDays, vehicleMake, vehicleModel,
                    vehicleType, vehicleType, VehiclePassengers);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return currentRent;
    }

    public ArrayList<Object[]> getPurchases() {

        String query = "SELECT Purchase.PurchaseID, Vehicle.VehicleMake, Vehicle.VehicleModel FROM Purchase LEFT JOIN Vehicle ON Purchase.VehicleID = Vehicle.VehicleID WHERE Purchase.UserID = 5;";
        ArrayList<Object[]> tableMap = new ArrayList<>();
        ResultSet results = db.executeQuery(query);

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

        return tableMap;

    }

    public void addPurchase(PurchaseModel purchase) {

        String query = String.format(
                "insert into Purchase ( UserID, VehicleID, VehiclePrice) VALUES ( %s, %s, %s)",
                purchase.getUserId(), purchase.getVehicleId(), purchase.getVehiclePrice());

        ResultSet results = db.executeQuery(query);

        try {
            if (results.next()) {
                JOptionPane.showMessageDialog(null, "Purchase has been Created");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void addRental(RentModel rental) {

        String query = String.format(
                "insert into Rent (RentStartDate, RentReturnDate, RentNoOfDays, VehicleID, UserID) VALUES ('%s', '%s', %s, %s, %s)",
                rental.getRentStartDate(), rental.getRentReturnDate(), rental.getRentNoOfDays(), rental.getUserId());

        ResultSet results = db.executeQuery(query);

        try {
            if (results.next()) {
                JOptionPane.showMessageDialog(null, "Purchase has been Created");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // public void updatePurchase(PurchaseModel purchase) {

    // String query = String.format(
    // "insert into Rent (RentStartDate, RentReturnDate, RentNoOfDays, VehicleID,
    // UserID) VALUES ('%s', '%s', %s, %s, %s)",
    // rental.getRentStartDate(), rental.getRentReturnDate(),
    // rental.getRentNoOfDays(), rental.getUserId());

    // ResultSet results = db.executeQuery(query);

    // try {
    // if (results.next()) {
    // JOptionPane.showMessageDialog(null, "Purchase has been Created");

    // }
    // } catch (SQLException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // }

    public void updateRental(RentModel rental) {
        String query = String.format(
                "update Rent SET RentReturnDate = '%s' WHERE UserID = %s AND Vehicle = %s",
                rental.getRentReturnDate(), rental.getUserId(), rental.getVehicleId());

        ResultSet results = db.executeQuery(query);

        try {
            if (results.next()) {
                JOptionPane.showMessageDialog(null, "Purchase has been Created");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
