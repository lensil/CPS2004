package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Supplier {
    private String name;
    private int id;

    // Default constructor
    public Supplier() {
        name = "";
        id = 0;
    }

    // Parameterized constructor
    public Supplier(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }

    // Display supplier information
    public void viewSupplierInfo() {
        System.out.println("Supplier name: " + name);
        System.out.println("Supplier ID: " + id);
    }

    // Save supplier information to file
    public void save(ObjectNode newItem) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            newItem.put("SupplierName", this.name);
            newItem.put("SupplierID", this.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load supplier information from file
    public void load(JsonNode node) {
        name = node.get("SupplierName").asText();
        id = node.get("SupplierID").asInt();
    }

}
