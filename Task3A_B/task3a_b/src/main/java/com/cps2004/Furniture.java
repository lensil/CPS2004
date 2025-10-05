package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Furniture extends Product{
    private String material;
    private String dimensions;

    // Default constructor
    public Furniture() {
        super();
        material = "";
        dimensions = "";
    }

    // Parameterized constructor
    public Furniture(String name, int id, Supplier supplier, int price, int volume, String material, String dimensions) {
        super(name, id, supplier, price, volume);
        this.material = material;
        this.dimensions = dimensions;
    }

    // Getters and setters
    public String getMaterial() { return material; }
    public String getDimensions() { return dimensions; }
    public void setMaterial(String material) { this.material = material; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }

    @Override
    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product material: " + material);
        System.out.println("Product dimensions: " + dimensions);
    }

}
