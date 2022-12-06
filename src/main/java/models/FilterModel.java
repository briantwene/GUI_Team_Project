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

// the model behind the FitlerBar custom swing component
public class FilterModel {

    // instance variables init
    public int price;
    public int maxPrice;
    public int minPrice;
    public int step;
    public ArrayList<String> rarity;
    public ArrayList<String> carTypes;
    public ArrayList<String> activeFilters;

    // constructor
    // passing max min and step values for the price slider

    // as there are two instances of FilterBar for the rental and purchase page
    public FilterModel(int maxVal, int minVal, int step) {
        this.price = maxVal;
        this.maxPrice = maxVal;
        this.minPrice = minVal;
        this.step = step;
        this.rarity = new ArrayList<String>();
        this.carTypes = new ArrayList<String>();
        this.activeFilters = new ArrayList<String>(2);

    }

    // getter and setter functions
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public ArrayList<String> getActiveFilters() {
        return activeFilters;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    // reset all the fields when user hits the reset button
    public void reset() {
        this.price = maxPrice;
        this.carTypes.clear();
        this.rarity.clear();
        this.activeFilters.clear();

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getTypes() {
        return carTypes;
    }

    public ArrayList<String> getCarRarity() {

        return rarity;
    }

    // set the current filter setting for car rarity
    public void setRarity(String type) {
        // if this type is there already means that the user is turning it off
        if (this.rarity.contains(type)) {
            // find the index of that type and remove it

            int index = this.rarity.indexOf(type);
            this.rarity.remove(index);

        } else {
            // otherwise add it to the list of chosen rarities
            this.rarity.add(type);
        }

        // the run the setter function for the active filters
        // to ensure that it is updated
        this.setActiveFilters();

    }

    // setter function for cartypes
    // when a clicks on one of the carType checkboxes on the FilterBar
    public void setCarType(String carType) {

        // if that type is already in the array
        // means that the user is unchecking so..
        if (this.carTypes.contains(carType)) {
            // find the index of that type and remove it
            int index = this.carTypes.indexOf(carType);
            this.carTypes.remove(index);

            // otherwise if the type is not there already
        } else {
            // it means that they user is checking the checkbox so
            // add that type in
            this.carTypes.add(carType);
        }

        // then run setActiveFilters to keep track of what filters are active
        this.setActiveFilters();
    }

    // setter function for showing what parts of the fitler is active from user
    // input
    public void setActiveFilters() {

        // if they user hasnt selected a type
        if (carTypes.size() != 0) {

            // and if the active fitler is not showing the types array as activated
            if (!activeFilters.contains("type")) {
                // then show that it is activated as the user has selected a car type
                activeFilters.add("type");
            }

            // otherwise if the user hasnt select the type
        } else {

            // and the array says that the "type" part is active
            if (activeFilters.contains("type")) {
                // then remove it as the user hasnt selected anything from the types section of
                // the filter
                activeFilters.remove(activeFilters.indexOf("type"));
            }
        }

        // do the same for the rarity section of the filter
        // check if that setting is active
        if (rarity.size() != 0) {
            if (!activeFilters.contains("rarity")) {
                activeFilters.add("rarity");
            }

        } else {
            if (activeFilters.contains("rarity")) {
                activeFilters.remove(activeFilters.indexOf("rarity"));
            }

        }
    }

    // string representation of the filter
    // this will be displayed everytime the filter is interacted with to give you a
    // visual of the filter in action :)
    @Override
    public String toString() {
        return String.format("FilterStatus\n\n Filters active: %s \n\n Types: %s \n\n Rarity: %s\n\n price: %s",
                this.activeFilters, this.carTypes, this.rarity, this.price);
    }

}
