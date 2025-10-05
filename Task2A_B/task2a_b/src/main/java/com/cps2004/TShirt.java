package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TShirt extends Clothes {
    private String collar;
    private boolean graphics;

    // Default constructor
    public TShirt() {
        super();
        this.collar = "";
        this.graphics = false;
    }

    // Parameterized constructor
    public TShirt(String name, int id, Supplier supplier, int price, int volume, String size, String brand, String material, String collar, boolean graphics) {
        super(name, id, supplier, price, volume, size, brand, material);
        this.collar = collar;
        this.graphics = graphics;
    }

    // Getters and setters
    public String getCollar() {
        return collar;
    }

    public boolean getGraphics() {
        return graphics;
    }

    public void setCollar(String collar) {
        this.collar = collar;
    }

    public void setGraphics(boolean graphics) {
        this.graphics = graphics;
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity) {
        if (month.equals("January") && quantity >= 5) {
            return 0.1 * getPrice();
        } else {
            return 0.05 * getPrice();
        }
    }

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product collar: " + collar);
        System.out.println("Product graphics: " + graphics);
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        super.save(newItem);
        newItem.put("collar", this.collar);
        newItem.put("graphics", this.graphics);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        collar = node.get("collar").asText();
        graphics = node.get("graphics").asBoolean();
    }
}
