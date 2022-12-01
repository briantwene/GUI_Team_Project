package models;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author twene
 */
public class FilterModel {

    public int price;
    public ArrayList<String> types;
    public ArrayList<String> carSize;
    public ArrayList<String> activeFilters;

    public FilterModel() {
        this.price = 300;
        this.types = new ArrayList<String>(4);
        this.carSize = new ArrayList<String>(3);
        this.activeFilters = new ArrayList<String>(2);

    }
    
    
    public void reset(){
        this.price = 300;
        this.types.clear();
        this.carSize.clear();
        this.activeFilters.clear();
    
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(String type) {
        if (this.types.contains(type)) {
            // find that index
            int index = this.types.indexOf(type);
            this.types.remove(index);

        } else {
            this.types.add(type);
        }

        this.setActiveFilters();

    }

    public ArrayList<String> getCarSize() {

        return carSize;
    }

    public void setActiveFilters() {

        //check what filters are active
        if (types.size() != 0) {

            if (!activeFilters.contains("type")) {
                activeFilters.add("type");
            }

        } else {

            if (activeFilters.contains("type")) {
                activeFilters.remove(activeFilters.indexOf("type"));
            }
        }

        if (carSize.size() != 0) {
            if (activeFilters.contains("size")) {
                activeFilters.add("size");
            }
            activeFilters.add("size");
        } else {
            if (activeFilters.contains("size")) {
                activeFilters.remove(activeFilters.indexOf("size"));
            }

        }
    }

    public void setCarSize(String carSizeType) {
        if (this.carSize.contains(carSizeType)) {
            // find that index
            int index = this.carSize.indexOf(carSizeType);
            this.carSize.remove(index);

        } else {
            this.carSize.add(carSizeType);
        }

        this.setActiveFilters();
    }

    @Override
    public String toString() {
        return String.format("FilterStatus\n\n Filters active: %s \n\n Types: %s \n\n Capacity: %s\n\n price: %s", this.activeFilters, this.types, this.carSize, this.price);
    }

}
