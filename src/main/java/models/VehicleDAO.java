/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author twene
 */
public class VehicleDAO {

    Database db;

    public VehicleDAO() {

        db = new Database();
    }

    public ArrayList<VehicleModel> getAll() {
        String query = ("SELECT * from Vehicle");
        ArrayList<VehicleModel> vehicleList = new ArrayList<>();

        try {

            // execute the query
            ResultSet results = db.executeQuery(query);

            // get the data out from each row
            while (results.next()) {

                System.out.println(results.getString("VehicleModel"));

                int vehicleId = results.getInt("VehicleID");
                String vehicleMake = results.getString("VehicleMake");
                String vehicleModel = results.getString("VehicleModel");
                int vehicleYear = results.getInt("VehicleYear");
                String vehicleColor = results.getString("VehicleColour");
                boolean vehicleAvailability = results.getBoolean("VehicleAvailability");

                int vehiclePrice = results.getInt("VehiclePrice");
//                boolean forSale = results.getBoolean("forSale");
                boolean forSale = true;
                String vehicleType = results.getString("VehicleType");
                Icon image = new ImageIcon(getClass().getResource("/images/car.png"));
                int vehiclePassengers = results.getInt("VehiclePassengers");
                String vehicleRarity = "ultra";

                // and add it to the list
                vehicleList.add(new VehicleModel(vehicleId, vehicleMake, vehicleModel, vehicleYear, vehicleColor,
                        vehicleAvailability, vehiclePrice, forSale, vehicleType, image, vehiclePassengers,
                        vehicleRarity));

            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(vehicleList);
        return vehicleList;
    }

}
