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

}
