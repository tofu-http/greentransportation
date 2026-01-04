package com.example.microservice.controller;

import com.example.microservice.model.TripData;
import com.example.microservice.service.FuelEfficiencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EfficiencyViewController {

    private final FuelEfficiencyService efficiencyService;

    @Autowired
    public EfficiencyViewController(FuelEfficiencyService efficiencyService) {
        this.efficiencyService = efficiencyService;
    }

    /**
     * 1. GET Mapping: Serves the input form HTML page and loads history.
     * Maps to: http://localhost:8080/
     */
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("tripData", new TripData()); 
        model.addAttribute("reports", efficiencyService.findAllReports());
        return "efficiency-form";
    }

    /**
     * 2. POST Mapping: Processes the form data, saves the calculation.
     * Maps to: /calculate
     */
    @PostMapping("/calculate")
    public String calculateEfficiency(@ModelAttribute TripData data) { 
        efficiencyService.analyzeTrip(data);
        return "redirect:/";
    }
    
    /**
     * 3. GET Mapping: Serves the analytics dashboard HTML page.
     * Maps to: http://localhost:8080/analytics/dashboard
     */
    @GetMapping("/analytics/dashboard")
    public String showDashboard(Model model) {
        return "efficiency-dashboard";
    }
    
    @GetMapping("/eco-leaderboard")
    public String showLeaderboard() {
        return "eco-leaderboard"; // This matches the name of your .html file
    }
}