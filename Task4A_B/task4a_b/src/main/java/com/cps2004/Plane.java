package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plane extends Transport{
    private List<String> airSpaces;

    // Default constructor
    public Plane(){
        super();
        airSpaces = new ArrayList<>();
    }

    // Parameterized constructor
    public Plane(int transportSpeed, int costPerKm, int transportID, List<String> airSpaces){
        super(transportSpeed, costPerKm, transportID);
        this.airSpaces = airSpaces;
    }

    // Getters and setters
    public List<String> getRoute() { return airSpaces; }
    public void setAirSpaces(List<String> airSpaces) { this.airSpaces = airSpaces; }

    // Calculate delivery plan
    public String deliveryPlan() {
        StringBuilder result = new StringBuilder("Plane will fly through: ");
        for (int i = 0; i < airSpaces.size(); i++) {
            if (i == airSpaces.size() - 1) {
                result.append(airSpaces.get(i));
            } else {
                result.append(airSpaces.get(i)).append(", ");
            }
        }
        return result.toString();
    }

}
