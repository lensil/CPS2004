package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Electronics extends Product{
    private String manufacturer;
    private int warranty;

    // Default constructor
    public Electronics(){
        super();
        this.manufacturer = "";
        this.warranty = 0;
    }

    // Parameterized constructor
    public Electronics(String name, int id, Supplier supplier, int price, int volume, String manufacturer, int warranty){
        super(name, id, supplier, price, volume);
        this.manufacturer = manufacturer;
        this.warranty = warranty;
    }

    // Getters and setters
    public String getManufacturer() { return manufacturer; }
    public int getWarranty() { return warranty; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setWarranty(int warranty) { this.warranty = warranty; }

    @Override
    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product manufacturer: " + manufacturer);
        System.out.println("Product warranty: " + warranty);
    }

    public void save(ObjectNode newItem) {
        super.save(newItem);
        newItem.put("manufacturer", this.manufacturer);
        newItem.put("warranty", this.warranty);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        manufacturer = node.get("manufacturer").asText();
        warranty = node.get("warranty").asInt();
    }
}
