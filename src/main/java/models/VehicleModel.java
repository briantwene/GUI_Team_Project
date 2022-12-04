/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
    private String image;
    private int vehiclePassengers;
    private String vehicleRarity;
    private String rarityColor;

    private Icon vehicleImage;

    public VehicleModel(int vehicleId, String vehicleMake, String vehicleModel, int vehicleYear, String vehicleColor,
            boolean vehicleAvailability, int vehiclePrice, boolean forSale, String vehicleType, String image,
            int vehiclePassengers, String vehicleRarity) {
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
        this.setRarityColor(this.getVehicleRarity());
        this.vehicleImage = this.createImage();
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

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public Icon getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(Icon vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public void setRarityColor(String rarity) {
        switch (rarity) {
            case "Luxury":
                this.rarityColor = "#ff8000";
                break;
            case "Budget":
                this.rarityColor = "#1eff00";
                break;
            case "Premium":
                this.rarityColor = "#ff0000";
                break;

            case "Standard":
                this.rarityColor = "#0070dd";
                break;

        }
    }

    public String getRarityColor() {
        return this.rarityColor;
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

    public boolean isForRent() {
        return forSale;
    }

    public void setForRent(boolean forRent) {
        this.forSale = forSale;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
