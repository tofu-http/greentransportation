package com.example.microservice.model;

public class TripData {
    
    private String vehicleId;
    private Double distanceKm;
    private Double fuelConsumedLiters;
    public Double fuelPricePerLiter; // NEW FIELD ADDED - temporarily public for testing
    
    // Default constructor
    public TripData() {
    }
    
    // Constructor with all fields
    public TripData(String vehicleId, Double distanceKm, Double fuelConsumedLiters, Double fuelPricePerLiter) {
        this.vehicleId = vehicleId;
        this.distanceKm = distanceKm;
        this.fuelConsumedLiters = fuelConsumedLiters;
        this.fuelPricePerLiter = fuelPricePerLiter;
    }
    
    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }
    
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public Double getDistanceKm() {
        return distanceKm;
    }
    
    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }
    
    public Double getFuelConsumedLiters() {
        return fuelConsumedLiters;
    }
    
    public void setFuelConsumedLiters(Double fuelConsumedLiters) {
        this.fuelConsumedLiters = fuelConsumedLiters;
    }
    
    // NEW GETTER AND SETTER FOR FUEL PRICE
    public Double getFuelPricePerLiter() {
        return fuelPricePerLiter;
    }
    
    public void setFuelPricePerLiter(Double fuelPricePerLiter) {
        this.fuelPricePerLiter = fuelPricePerLiter;
    }
    
    @Override
    public String toString() {
        return "TripData{" +
                "vehicleId='" + vehicleId + '\'' +
                ", distanceKm=" + distanceKm +
                ", fuelConsumedLiters=" + fuelConsumedLiters +
                ", fuelPricePerLiter=" + fuelPricePerLiter +
                '}';
    }
}