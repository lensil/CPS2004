package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Camera extends Electronics {
    private double megaPixels;
    private int zoom;
    private boolean wirelessConnectivity;

    // Default constructor
    public Camera(){
        super();
        this.megaPixels = 0;
        this.zoom = 0;
        this.wirelessConnectivity = false;
    }

    // Parameterized constructor
    public Camera(double megaPixels, int zoom, boolean wirelessConnectivity, String name, int id, Supplier supplier, int price, int volume, String manufacturer, int warranty){
        super(name, id, supplier, price, volume, manufacturer, warranty);
        this.megaPixels = megaPixels;
        this.zoom = zoom;
        this.wirelessConnectivity = wirelessConnectivity;
    }

    // Getters and setters
    public double getMegaPixels() { return megaPixels; }
    public int getZoom() { return zoom; }
    public boolean getWirelessConnectivity() { return wirelessConnectivity; }
    public void setMegaPixels(double megaPixels) { this.megaPixels = megaPixels; }
    public void setZoom(int zoom) { this.zoom = zoom; }
    public void setWirelessConnectivity(boolean wirelessConnectivity) { this.wirelessConnectivity = wirelessConnectivity; }

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product mega pixels: " + megaPixels);
        System.out.println("Product zoom: " + zoom);
        System.out.println("Product wireless connectivity: " + wirelessConnectivity);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if (month.equals("January") || month.equals("February") || month.equals("March") || quantity >= 10) {
            return getPrice() * 0.1;
        }
        else {
            return getPrice();
        }
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        newItem.put("type", "camera");
        super.save(newItem);
        newItem.put("megaPixels", this.megaPixels);
        newItem.put("zoom", this.zoom);
        newItem.put("wirelessConnectivity", this.wirelessConnectivity);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        megaPixels = node.get("megaPixels").asDouble();
        zoom = node.get("zoom").asInt();
        wirelessConnectivity = node.get("wirelessConnectivity").asBoolean();
    }
}
