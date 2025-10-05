package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Clothes extends Product{
    private String size;
    private String brand;
    private String material;

    // Default constructor
    public Clothes(){
        super();
        this.size = "";
        this.brand = "";
        this.material = "";
    }

    // Parameterized constructor
    public Clothes(String name, int id, Supplier supplier, int price, int volume, String size, String brand, String material){
        super(name, id, supplier, price, volume);
        this.size = size;
        this.brand = brand;
        this.material = material;
    }

    // Getters and setters
    public String getSize() { return size; }
    public String getBrand() { return brand; }
    public String getMaterial() { return material; }
    public void setSize(String size) { this.size = size; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product size: " + size);
        System.out.println("Product brand: " + brand);
        System.out.println("Product material: " + material);
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        super.save(newItem);
        newItem.put("size", this.size);
        newItem.put("brand", this.brand);
        newItem.put("material", this.material);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        size = node.get("size").asText();
        brand = node.get("brand").asText();
        material = node.get("material").asText();
    }
}
