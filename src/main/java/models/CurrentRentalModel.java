/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author twene
 */
public class CurrentRentalModel {
    private Date rentStartDate;
    private Date rentReturnDate;
    private int rentNoOfDays;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String vehicleRarity;
    private int vehiclePassengers;

    public CurrentRentalModel(Date rentStartDate, Date rentReturnDate, int rentNoOfDays, String vehicleMake, String vehicleModel, String vehicleType, String vehicleRarity, int vehiclePassengers) {
        this.rentStartDate = rentStartDate;
        this.rentReturnDate = rentReturnDate;
        this.rentNoOfDays = rentNoOfDays;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleRarity = vehicleRarity;
        this.vehiclePassengers = vehiclePassengers;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
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
