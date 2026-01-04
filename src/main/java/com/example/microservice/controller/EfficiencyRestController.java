package com.example.microservice.controller;

import com.example.microservice.model.*;
import com.example.microservice.service.FuelEfficiencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EfficiencyRestController {

    private final FuelEfficiencyService efficiencyService;

    @Autowired
    public EfficiencyRestController(FuelEfficiencyService efficiencyService) {
        this.efficiencyService = efficiencyService;
    }

    @GetMapping("/efficiency/trends") 
    public List<MonthlyEfficiencyData> getEfficiencyTrends() {
        return efficiencyService.calculateMonthlyEfficiencyTrends(); 
    }

    @GetMapping("/efficiency/breakdown")
    public List<VehicleTypeEfficiency> getEfficiencyBreakdown() {
        return efficiencyService.calculateEfficiencyBreakdownByVehicle();
    }
    
    @GetMapping("/costs/trends")
    public List<MonthlyCostData> getCostTrends() {
        return efficiencyService.calculateMonthlyCosts();
    }

    @GetMapping("/costs/breakdown")
    public List<VehicleCostAnalysis> getCostBreakdown() {
        return efficiencyService.calculateCostBreakdownByVehicle();
    }

    @GetMapping("/costs/total")
    public Map<String, Double> getTotalCost() {
        return Collections.singletonMap("totalCost", efficiencyService.getTotalFleetCost());
    }
    
    @GetMapping("/trips/summary")
    public Map<String, Object> getTripSummary() {
        return efficiencyService.getTripSummary();
    }

    @PostMapping("/trip/analyze")
    public EfficiencyReport analyzeTrip(@RequestBody TripData tripData) {
        return efficiencyService.analyzeTrip(tripData);
    }
    
    @GetMapping("/analytics/leaderboard")
    public List<EcoRanking> getLeaderboard() {
        return efficiencyService.getLeaderboardData();
    }
    
    // FIXED: Now calls efficiencyService instead of calling Repository directly
    @GetMapping("/analytics/carbon-trends")
    public List<Map<String, Object>> getCarbonTrends() {
        return efficiencyService.getCarbonTrendsData();
    }
}