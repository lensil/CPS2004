package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Laptop extends Electronics {
    private double screenSize;
    private String operatingSystem;
    private int ram;

    // Default constructor
    public Laptop(){
        super();
        this.screenSize = 0;
        this.operatingSystem = "";
        this.ram = 0;
    }

    // Parameterized constructor
    public Laptop(String name, int id, Supplier supplier, int price, int volume, String manufacturer, int warranty, double screenSize, String operatingSystem, int ram){
        super(name, id, supplier, price, volume, manufacturer, warranty);
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
    }

    // Getters and setters
    public double getScreenSize() { return screenSize; }
    public String getOperatingSystem() { return operatingSystem; }
    public int getRam() { return ram; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }
    public void setRam(int ram) { this.ram = ram; }

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product screen size: " + screenSize);
        System.out.println("Product operating system: " + operatingSystem);
        System.out.println("Product ram: " + ram);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if ((month.equals("January") || month.equals("February") || month.equals("March")) && quantity >= 10) {
            return this.getPrice() * 0.1;
        } else {
            return this.getPrice();
        }
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        newItem.put("type", "laptop");
        super.save(newItem);
        newItem.put("screenSize", this.screenSize);
        newItem.put("operatingSystem", this.operatingSystem);
        newItem.put("ram", this.ram);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        screenSize = node.get("screenSize").asDouble();
        operatingSystem = node.get("operatingSystem").asText();
        ram = node.get("ram").asInt();
    }
}
