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
    LocalDateTime reservedStartDate;
    LocalDateTime reservedEndDate;
    
    
   public AppModel(){
       
      this.selectedVehicle = new VehicleModel("", "", 1,  new ImageIcon(getClass().getResource("/images/car.png")), 1, "");
      this.reservedStartDate = LocalDateTime.now();
      this.reservedEndDate = LocalDateTime.now().plusDays(3);
      
   }

    public VehicleModel getSelectedVehicle() {
        return selectedVehicle;
    }

    public void setSelectedVehicle(VehicleModel selectedVehicle) {
        this.selectedVehicle = selectedVehicle;
    }

    public LocalDateTime getReservedStartDate() {
        return reservedStartDate;
    }

    public void setReservedStartDate(LocalDateTime reservedStartDate) {
        this.reservedStartDate = reservedStartDate;
    }

    public LocalDateTime getReservedEndDate() {
        return reservedEndDate;
    }

    public void setReservedEndDate(LocalDateTime reservedEndDate) {
        this.reservedEndDate = reservedEndDate;
    }
   
   
            
    
    
}
