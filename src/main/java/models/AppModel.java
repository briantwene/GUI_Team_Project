/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author twene
 */

// model for holding application state
public class AppModel {

    public UserModel currentUser; // holding current user logged in
    VehicleModel selectedVehicle; // selected car at checkout
    public LocalDate pickupDate; // rent pick update
    public LocalDate returnDate; // rent return date

    //
    public AppModel() {
        // initalise variables
        this.currentUser = null;
        this.selectedVehicle = null;
        this.pickupDate = LocalDate.now();
        this.returnDate = LocalDate.now().plusDays(3);

    }

    // getter and setter methods
    public VehicleModel getSelectedVehicle() {
        return selectedVehicle;
    }

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }

    public void setSelectedVehicle(VehicleModel selectedVehicle) {
        this.selectedVehicle = selectedVehicle;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
