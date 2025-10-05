package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Transport {
    private int transportSpeed;
    private int costPerKm;
    private int transportID;

    // Default constructor
    public Transport(){
        this.transportSpeed = 0;
        this.costPerKm = 0;
        this.transportID = 0;
    }

    // Parameterized constructor
    public Transport(int transportSpeed, int costPerKm, int transportID){
        this.transportSpeed = transportSpeed;
        this.costPerKm = costPerKm;
        this.transportID = transportID;
    }

    // Getters and setters
    public int getTransportSpeed() { return transportSpeed; }
    public int getCostPerKm() { return costPerKm; }
    public int getTransportID() { return transportID; }
    public void setTransportSpeed(int transportSpeed) { this.transportSpeed = transportSpeed; }
    public void setCostPerKm(int costPerKm) { this.costPerKm = costPerKm; }
    public void setTransportID(int transportID) { this.transportID = transportID; }

    // Calculate delivery time
    public double deliveryTime(double distance) {
        return distance / transportSpeed;
    }

    // Calculate delivery cost
    public double deliveryCost(double distance) {
        return distance * costPerKm;
    }

    // Calculate delivery plan
    public abstract String deliveryPlan();

    // Save transport information to file
    public void save(ObjectNode newItem) {
        newItem.put("transportSpeed", this.transportSpeed);
        newItem.put("costPerKm", this.costPerKm);
        newItem.put("transportID", this.transportID);
    }

    // Load transport information from file
    public void load(JsonNode node) {
        this.transportSpeed = node.get("transportSpeed").asInt();
        this.costPerKm = node.get("costPerKm").asInt();
        this.transportID = node.get("transportID").asInt();
    }
}
