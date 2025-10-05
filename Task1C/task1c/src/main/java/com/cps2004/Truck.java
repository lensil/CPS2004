package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Truck extends Transport {
    private List<String> motorways;

    // Default constructor
    public Truck(){
        super();
        motorways = new ArrayList<>();
    }

    // Parameterized constructor
    public Truck(int transportSpeed, int costPerKm, int transportID, List<String> motorways){
        super(transportSpeed, costPerKm, transportID);
        this.motorways = motorways;
    }

    // Getters and setters
    public List<String> getRoute() { return motorways; }
    public void setMotorways(List<String> motorways) { this.motorways = motorways; }

    // Calculate delivery plan
    public String deliveryPlan() {
        StringBuilder result = new StringBuilder("Truck will drive through: ");
        for (int i = 0; i < motorways.size(); i++) {
            if (i == motorways.size() - 1) {
                result.append(motorways.get(i));
            } else {
                result.append(motorways.get(i)).append(", ");
            }
        }
        return result.toString();
    }

    // Save transport information to file
    public void save(ObjectNode newItem) {
        newItem.put("transportType", "truck");
        super.save(newItem);
        StringBuilder motorwaysString = new StringBuilder();
        for (int i = 0; i < motorways.size(); i++) {
            if (i == motorways.size() - 1) {
                motorwaysString.append(motorways.get(i));
            } else {
                motorwaysString.append(motorways.get(i)).append(", ");
            }
        }
        newItem.put("motorways", motorwaysString.toString());
    }

    // Load transport information from file
    public void load(JsonNode node) {
        super.load(node);
        String motorwaysString = node.get("motorways").asText();
        Collections.addAll(motorways, motorwaysString.split(", "));
    }
}
