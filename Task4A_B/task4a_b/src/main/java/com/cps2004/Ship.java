package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ship extends Transport{
    private List<String> harbours;

    // Default constructor
    public Ship(){
        super();
        harbours = new ArrayList<>();
    }

    // Parameterized constructor
    public Ship(int transportSpeed, int costPerKm, int transportID, List<String> harbours){
        super(transportSpeed, costPerKm, transportID);
        this.harbours = harbours;
    }

    // Getters and setters
    public List<String> getRoute() { return harbours; }
    public void setHarbours(List<String> harbours) { this.harbours = harbours; }

    @Override
    // Calculate delivery plan
    public String deliveryPlan() {
        StringBuilder result = new StringBuilder("Ship will sail through: ");
        for (int i = 0; i < harbours.size(); i++) {
            if (i == harbours.size() - 1) {
                result.append(harbours.get(i));
            } else {
                result.append(harbours.get(i)).append(", ");
            }
        }
        return result.toString();
    }

}