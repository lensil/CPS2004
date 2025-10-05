package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Pants extends Clothes{
    private double inseam;
    private double waist;

    // Default constructor
    public Pants(){
        super();
        this.inseam = 0;
        this.waist = 0;
    }

    // Parameterized constructor
    public Pants(String name, int id, Supplier supplier, int price, int volume, String size, String brand, String material, double inseam, double waist){
        super(name, id, supplier, price, volume, size, brand, material);
        this.inseam = inseam;
        this.waist = waist;
    }

    // Getters and setters
    public double getInseam() { return inseam; }
    public double getWaist() { return waist; }
    public void setInseam(double inseam) { this.inseam = inseam; }
    public void setWaist(double waist) { this.waist = waist; }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if (month.equals("January") || quantity > 7) {
            return this.getPrice() * 0.1;
        } else {
            return this.getPrice() * 0.05;
        }
    }

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product inseam: " + inseam);
        System.out.println("Product waist: " + waist);
    }

}
