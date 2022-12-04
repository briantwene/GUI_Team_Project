package models;

public class PurchaseModel {
    private int purchaseId;
    private int userId;
    private int vehicleId;
    private int vehiclePrice;

    public PurchaseModel(int purchaseId, int userId, int vehicleId, int vehiclePrice) {
        this.purchaseId = purchaseId;
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.vehiclePrice = vehiclePrice;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

}
