package com.example.microservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "efficiency_reports")
public class EfficiencyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleId;

    @Column(nullable = false)
    private Double distanceKm;

    @Column(nullable = false)
    private Double fuelConsumedLiters;

    @Column(nullable = false)
    private Double efficiencyKmPerL;

    @Column(nullable = true)
    private Double fuelPricePerLiter;

    @Column(nullable = true)
    private Double tripCost;

    private String message;

    @Column(name = "analyzed_at")
    private LocalDateTime analyzedAt;

    // Constructors
    public EfficiencyReport() {
    }

    public EfficiencyReport(String vehicleId, Double distanceKm, Double fuelConsumedLiters, 
                           Double efficiencyKmPerL, String message) {
        this.vehicleId = vehicleId;
        this.distanceKm = distanceKm;
        this.fuelConsumedLiters = fuelConsumedLiters;
        this.efficiencyKmPerL = efficiencyKmPerL;
        this.message = message;
        this.analyzedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getEfficiencyKmPerL() {
        return efficiencyKmPerL;
    }

    public void setEfficiencyKmPerL(Double efficiencyKmPerL) {
        this.efficiencyKmPerL = efficiencyKmPerL;
    }

    public Double getFuelPricePerLiter() {
        return fuelPricePerLiter;
    }

    public void setFuelPricePerLiter(Double fuelPricePerLiter) {
        this.fuelPricePerLiter = fuelPricePerLiter;
    }

    public Double getTripCost() {
        return tripCost;
    }

    public void setTripCost(Double tripCost) {
        this.tripCost = tripCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAnalyzedAt() {
        return analyzedAt;
    }

    public void setAnalyzedAt(LocalDateTime analyzedAt) {
        this.analyzedAt = analyzedAt;
    }

    @Override
    public String toString() {
        return "EfficiencyReport{" +
                "id=" + id +
                ", vehicleId='" + vehicleId + '\'' +
                ", distanceKm=" + distanceKm +
                ", fuelConsumedLiters=" + fuelConsumedLiters +
                ", efficiencyKmPerL=" + efficiencyKmPerL +
                ", fuelPricePerLiter=" + fuelPricePerLiter +
                ", tripCost=" + tripCost +
                ", message='" + message + '\'' +
                ", analyzedAt=" + analyzedAt +
                '}';
    }
}