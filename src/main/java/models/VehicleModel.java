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
    
    private int price;
    private String name;
    private String category;
    private Icon image;
    private int passengers;
    private String size;
    
    public VehicleModel(String carName, String carClass, int carPrice, Icon carImage, int passengers, String size){
    this.name = carName;
    this.category = carClass;
    this.price = carPrice;
    this.image = carImage;
    this.passengers = passengers;
    this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
    
    @Override
    public String toString(){
        return "";
    }
    
    
    
}
