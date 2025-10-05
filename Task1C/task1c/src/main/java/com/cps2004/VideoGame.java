package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class VideoGame extends Product{
    private String platform;
    private String developer;

    // Default constructor
    public VideoGame(){
        super();
        this.platform = "";
        this.developer = "";
    }

    // Parameterized constructor
    public VideoGame(String name, int id, Supplier supplier, int price, int volume, String platform, String developer){
        super(name, id, supplier, price, volume);
        this.platform = platform;
        this.developer = developer;
    }

    // Getters and setters
    public String getPlatform() { return platform; }
    public String getDeveloper() { return developer; }
    public void setPlatform(String platform) { this.platform = platform; }
    public void setDeveloper(String developer) { this.developer = developer; }

    @Override
    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product platform: " + platform);
        System.out.println("Product developer: " + developer);
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        super.save(newItem);
        newItem.put("platform", this.platform);
        newItem.put("developer", this.developer);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        platform = node.get("platform").asText();
        developer = node.get("developer").asText();
    }
}
