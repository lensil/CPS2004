package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Food extends Product {
    private double weight;
    private String expirationDate;

    // Default constructor
    public Food() {
        super();
        this.weight = 0;
        this.expirationDate = "";
    }

    // Parameterized constructor
    public Food(String name, int id, Supplier supplier, int price, int volume, double weight, String expirationDate) {
        super(name, id, supplier, price, volume);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    // Getters and setters
    public double getWeight() {
        return weight;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product weight: " + weight);
        System.out.println("Product expiration date: " + expirationDate);
    }
    // Save product information to file
    public void save(ObjectNode newItem) {
        super.save(newItem);
        newItem.put("weight", this.weight);
        newItem.put("expirationDate", this.expirationDate);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        weight = node.get("weight").asDouble();
        expirationDate = node.get("expirationDate").asText();
    }
}