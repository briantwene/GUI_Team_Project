/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author twene
 */

// model for getting the current rental on the AccountCurrentView
// data from the dealershipDAO is put in to the object for this
public class CurrentRentalModel {
    private Date rentStartDate;
    private Date rentReturnDate;
    private int rentNoOfDays;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String vehicleRarity;
    private int vehiclePassengers;
    private boolean vehicleAvailability;
    private String image;
    private Icon vehicleImage;
    private int rentID;

    public CurrentRentalModel(Date rentStartDate, Date rentReturnDate, int rentNoOfDays, String vehicleMake,
            String vehicleModel, String vehicleType, String vehicleRarity, int vehiclePassengers,
            boolean vehicleAvailability, String image, int rentId) {
        this.rentStartDate = rentStartDate;
        this.rentReturnDate = rentReturnDate;
        this.rentNoOfDays = rentNoOfDays;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleRarity = vehicleRarity;
        this.vehiclePassengers = vehiclePassengers;
        this.vehicleAvailability = vehicleAvailability;
        this.image = image;
        this.vehicleImage = this.createImage();
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public Icon createImage() {

        try {
            URL url = new URL(this.getImage());
            BufferedImage image;
            image = ImageIO.read(url);

            return new ImageIcon(image);
        } catch (MalformedURLException ex) {
            Logger.getLogger(VehicleModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ImageIcon(getClass().getResource("/image/car.png"));

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Icon getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(Icon vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public boolean isVehicleAvailability() {
        return vehicleAvailability;
    }

    public void setVehicleAvailability(boolean vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    public Date getRentReturnDate() {
        return rentReturnDate;
    }

    public void setRentReturnDate(Date rentReturnDate) {
        this.rentReturnDate = rentReturnDate;
    }

    public int getRentNoOfDays() {
        return rentNoOfDays;
    }

    public void setRentNoOfDays(int rentNoOfDays) {
        this.rentNoOfDays = rentNoOfDays;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleRarity() {
        return vehicleRarity;
    }

    public void setVehicleRarity(String vehicleRarity) {
        this.vehicleRarity = vehicleRarity;
    }

    public int getVehiclePassengers() {
        return vehiclePassengers;
    }

    public void setVehiclePassengers(int vehiclePassengers) {
        this.vehiclePassengers = vehiclePassengers;
    }

}
