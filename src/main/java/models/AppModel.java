/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import javax.swing.ImageIcon;

/**
 *
 * @author twene
 */
public class AppModel {

    VehicleModel selectedVehicle;
    LocalDateTime pickupDate;
    LocalDateTime returnDate;

    public AppModel() {

        this.selectedVehicle = new VehicleModel("", "", 1, new ImageIcon(getClass().getResource("/images/car.png")), 1, "");
        this.pickupDate = LocalDateTime.now();
        this.returnDate = LocalDateTime.now().plusDays(3);

    }

    public VehicleModel getSelectedVehicle() {
        return selectedVehicle;
    }

    public void setSelectedVehicle(VehicleModel selectedVehicle) {
        this.selectedVehicle = selectedVehicle;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

}
