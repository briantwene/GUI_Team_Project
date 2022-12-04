package models;

import java.time.LocalDateTime;
import java.util.Date;

public class RentModel {
    private int rentId;
    private Date rentStartDate;
    private Date rentReturnDate;
    private int rentNoOfDays;
    private int vehicleId;
    private int userId;

    public RentModel(int rentId, Date rentStartDate, Date rentReturnDate, int rentNoOfDays, int vehicleId, int userId) {
        this.rentId = rentId;
        this.rentStartDate = rentStartDate;
        this.rentReturnDate = rentReturnDate;
        this.rentNoOfDays = rentNoOfDays;
        this.vehicleId = vehicleId;
        this.userId = userId;
    }

   

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

