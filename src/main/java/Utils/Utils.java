/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import models.FilterModel;
import models.VehicleModel;

/**
 *
 * @author twene
 */

// class for holding functions that were to big or functions that are used in
// multiple areas
// aslo for small tedious tasks like manipulating time
public class Utils {

    public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public static long countDaysBetween(LocalDate start, LocalDate end) {

        Date pickupDateConverted = convertToDateViaSqlDate(start);
        Date returnDateConverted = convertToDateViaSqlDate(end);

        long pickupDateNum = pickupDateConverted.getTime();
        long returnDateNum = returnDateConverted.getTime();
        long daysBetween = TimeUnit.DAYS.convert(Math.abs(pickupDateNum - returnDateNum),
                TimeUnit.MILLISECONDS);

        return daysBetween;
    }

    public static HashMap<String, ArrayList<String>> mapFilterOptions(ArrayList<VehicleModel> vehicleList) {

        // loop over the array
        HashMap<String, ArrayList<String>> filterMap = new HashMap<>();

        filterMap.put("color", new ArrayList<>());
        filterMap.put("make", new ArrayList<>());
        filterMap.put("year", new ArrayList<>());

        // check if each value for each item is available in the array already if not
        // then add it
        for (int i = 0; i < vehicleList.size(); i++) {

            VehicleModel vehicle = vehicleList.get(i);

            String year = Integer.toString(vehicle.getVehicleYear());
            String make = vehicle.getVehicleMake();
            String color = vehicle.getVehicleColor();

            if (!filterMap.get("color").contains(color)) {
                filterMap.get("color").add(color);
            }

            if (!filterMap.get("make").contains(make)) {
                filterMap.get("make").add(make);
            }

            if (!filterMap.get("year").contains(year)) {
                filterMap.get("year").add(year);
            }

        }

        return filterMap;

    }

    public static ArrayList<VehicleModel> filterVehicleData(FilterModel currentFilter,
            ArrayList<VehicleModel> vehicleList, String mode) {

        // create new array to populate
        ArrayList<VehicleModel> newList = new ArrayList<VehicleModel>();
        System.out.println(currentFilter);

        ArrayList<String> type = currentFilter.getTypes();
        ArrayList<String> sizes = currentFilter.getCarRarity();

        // then check the criteria based off this

        // filter based on criteria
        for (int i = 0; i < vehicleList.size(); i++) {

            VehicleModel vehicle = vehicleList.get(i);

            int maxPrice = currentFilter.getPrice();

            // price will always be filtered regardless of the other two filter types being
            // inactive or not
            // check what parts of the filters are active if type and rarity are active
            if (currentFilter.activeFilters.contains("type") && currentFilter.activeFilters.contains("rarity")) {

                // then check if the any cars match what is inside
                if (type.contains(vehicle.getVehicleRarity()) && sizes.contains(vehicle.getVehicleType())
                        && vehicle.getVehiclePrice() <= maxPrice) {

                    newList.add(vehicle);
                }
                // do the same for if one of the filters are active
            } else if (currentFilter.activeFilters.contains("type")) {

                if (type.contains(vehicle.getVehicleRarity()) && vehicle.getVehiclePrice() <= maxPrice) {

                    newList.add(vehicle);
                }

            } else if (currentFilter.activeFilters.contains("rarity")) {

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
