package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Package {
    private int packagingUnits;
    private double cost;
    private String type;
    private int packageID;

    // Default constructor
    public Package() {
        this.packagingUnits = 0;
        this.cost = 0.0;
        this.type = "";
        this.packageID = 0;
    }

    // Parameterized constructor
    public Package(int packagingUnits, double cost, String type, int packageID) {
        this.packagingUnits = packagingUnits;
        this.cost = cost;
        this.type = type;
        this.packageID = packageID;
    }

    // Getters and setters
    public int getPackagingUnits() { return packagingUnits; }
    public double getCost() { return cost; }
    public String getType() { return type; }
    public int getPackageID() { return packageID; }
    public void setPackagingUnits(int packagingUnits) { this.packagingUnits = packagingUnits; }
    public void setCost(double cost) { this.cost = cost; }
    public void setType(String type) { this.type = type; }
    public void setPackageID(int packageID) { this.packageID = packageID; }

    // Display package information
    public void viewPackage() {
        System.out.println("Package ID: " + this.packageID);
        System.out.println("Package type: " + this.type);
        System.out.println("Package cost: " + this.cost);
        System.out.println("Package packaging units: " + this.packagingUnits);
    }

    //  Save package information to file
    public void save(ObjectNode newItem) {
        newItem.put("packageType", this.type);
        newItem.put("cost", this.cost);
        newItem.put("packagingUnits", this.packagingUnits);
        newItem.put("packageID", this.packageID);
    }

    // Load package information from file
    public void load(JsonNode node) {
        this.type = node.get("packageType").asText();
        this.cost = node.get("cost").asDouble();
        this.packagingUnits = node.get("packagingUnits").asInt();
        this.packageID = node.get("packageID").asInt();
    }
}
