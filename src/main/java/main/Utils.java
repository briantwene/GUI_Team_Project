/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import models.FilterModel;
import models.VehicleModel;

/**
 *
 * @author twene
 */
public class Utils {
    
    
    public static ArrayList<VehicleModel> filterVehicleData(FilterModel currentFilter, ArrayList<VehicleModel> vehicleList) {

        //create new array to populate
        ArrayList<VehicleModel> newList = new ArrayList<VehicleModel>();
        System.out.println(currentFilter);

        ArrayList<String> type = currentFilter.getTypes();
        ArrayList<String> sizes = currentFilter.getCarSize();

        //then check the criteria based off this
        // filter based on criteria
        for (int i = 0; i < vehicleList.size(); i++) {

            VehicleModel vehicle = vehicleList.get(i);

            int maxPrice = currentFilter.getPrice();

            //check what parts of the filters are active
            if (currentFilter.activeFilters.contains("type") && currentFilter.activeFilters.contains("size")) {

                if (type.contains(vehicle.getVehicleRarity()) && sizes.contains(vehicle.getVehicleType()) && vehicle.getVehiclePrice() <= maxPrice) {

                    newList.add(vehicle);
                }

            } else if (currentFilter.activeFilters.contains("type")) {

                if (type.contains(vehicle.getVehicleRarity()) && vehicle.getVehiclePrice() <= maxPrice) {

                    newList.add(vehicle);
                }

            } else if (currentFilter.activeFilters.contains("size")) {

                if (sizes.contains(vehicle.getVehicleRarity()) && vehicle.getVehiclePrice() <= maxPrice) {

                    newList.add(vehicle);
                }

            } else {
                if (vehicle.getVehiclePrice() <= maxPrice) {

                    newList.add(vehicle);
                }
            }

        }

        return newList;
    }
    
}
