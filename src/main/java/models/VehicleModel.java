/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.Icon;

/**
 *
 * @author twene
 */
// model for applicaton
public class VehicleModel {

    private int vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private int vehicleYear;
    private String vehicleColor;
    private boolean vehicleAvailability;

    private int vehiclePrice;
    private boolean forSale;

    private String vehicleType;
    private Icon image;
    private int vehiclePassengers;
    private String vehicleRarity;

    public VehicleModel(int vehicleId, String vehicleMake, String vehicleModel, int vehicleYear, String vehicleColor, boolean vehicleAvailability, int vehiclePrice, boolean forSale, String vehicleType, Icon image, int vehiclePassengers, String vehicleRarity) {
        this.vehicleId = vehicleId;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleColor = vehicleColor;
        this.vehicleAvailability = vehicleAvailability;
        this.vehiclePrice = vehiclePrice;
        this.forSale = forSale;
        this.vehicleType = vehicleType;
        this.image = image;
        this.vehiclePassengers = vehiclePassengers;
        this.vehicleRarity = vehicleRarity;
    }


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public boolean isVehicleAvailability() {
        return vehicleAvailability;
    }

    public void setVehicleAvailability(boolean vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    public int getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public int getVehiclePassengers() {
        return vehiclePassengers;
    }

    public void setVehiclePassengers(int vehiclePassengers) {
        this.vehiclePassengers = vehiclePassengers;
    }

    public String getVehicleRarity() {
        return vehicleRarity;
    }

    public void setVehicleRarity(String vehicleRarity) {
        this.vehicleRarity = vehicleRarity;
    }
    
    

    @Override
    public String toString() {
        return "";
    }

}
