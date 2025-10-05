package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Chair extends Furniture{
    private double seatLength;
    private boolean armRests;

    // Default constructor
    public Chair(){
        super();
        this.seatLength = 0;
        this.armRests = false;
    }

    // Parameterized constructor
    public Chair(double seatLength, boolean armRests, String name, int id, Supplier supplier, int price, int volume, String material, String dimensions){
        super(name, id, supplier, price, volume, material, dimensions);
        this.seatLength = seatLength;
        this.armRests = armRests;
    }

    // Setters and getters
    public double getSeatLength(){ return this.seatLength;}
    public boolean getArmRests(){ return this.armRests;}
    public void setSeatLength(double seatLength){ this.seatLength = seatLength;}
    public void setArmRests(boolean armRests){ this.armRests = armRests;}

    // Display product information
    public void display_product_info(){
        super.display_product_info();
        System.out.println("Product seat length: " + seatLength);
        System.out.println("Product has arm rests: " + armRests);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if (month.equals("January") && quantity >= 10) {
            return this.getPrice() * 0.5;
        }
        return this.getPrice() * 0.1;
    }

    // Save product information to file
    public void save(ObjectNode newItem){
        newItem.put("type", "chair");
        super.save(newItem);
        newItem.put("seatLength", this.seatLength);
        newItem.put("armRests", this.armRests);
    }

    // Load product information from file
    public void load(JsonNode node){
        super.load(node);
        seatLength = node.get("seatLength").asDouble();
        armRests = node.get("armRests").asBoolean();
    }
}
