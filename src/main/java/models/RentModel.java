package models;

import java.util.Date;

// model for making rent objects
public class RentModel {
    private int rentId; // id of rental generated by the db
    private Date rentStartDate; // return and pickup dates
    private Date rentReturnDate;
    private int rentNoOfDays; // number of days can be used to track overdue accounts and let the user know
                              // the amount of days left easily
    private int vehicleId; // id of the vehicle being rented
    private int userId; // id of the user renting the vehicle

    public RentModel(int rentId, Date rentStartDate, Date rentReturnDate, int rentNoOfDays, int vehicleId, int userId) {
        this.rentId = rentId;
        this.rentStartDate = rentStartDate;
        this.rentReturnDate = rentReturnDate;
        this.rentNoOfDays = rentNoOfDays;
        this.vehicleId = vehicleId;
        this.userId = userId;
    }

    // getter and setter methods
    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public Date getRentReturnDate() {
        return rentReturnDate;
    }

    public void setRentReturnDate(Date rentReturnDate) {
        this.rentReturnDate = rentReturnDate;
    }

    public int getRentNoOfDays() {
        return rentNoOfDays;
    }

    public void setRentNoOfDays(int rentNoOfDays) {
        this.rentNoOfDays = rentNoOfDays;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
