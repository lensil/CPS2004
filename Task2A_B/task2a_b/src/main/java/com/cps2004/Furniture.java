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

    // Save product information to file
    public void save(ObjectNode newItem) {
        super.save(newItem);
        newItem.put("material", this.material);
        newItem.put("dimensions", this.dimensions);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        material = node.get("material").asText();
        dimensions = node.get("dimensions").asText();
    }
}
