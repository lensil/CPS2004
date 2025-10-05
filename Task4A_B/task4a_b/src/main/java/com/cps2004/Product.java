package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Product {
    private String name;
    private int id;
    private Supplier supplier;
    private int price;
    private int volume; 

    // Default constructor
    public Product() {
        name = "";
        id = 0;
        supplier = new Supplier();
        price = 0;
        volume = 0;
    }

    // Parameterized constructor
    public Product(String name, int id, Supplier supplier, int price, int volume) {
        this.name = name;
        this.id = id;
        this.supplier = supplier;
        this.price = price;
        this.volume = volume;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getId() { return id; }
    public Supplier getSupplier() { return supplier; }
    public int getPrice() { return price; }
    public int getVolume() { return volume; }
    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public void setPrice(int price) { this.price = price; }
    public void setVolume(int volume) { this.volume = volume; }

    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        System.out.println("Product name: " + name);
        System.out.println("Product ID: " + id);
        System.out.println("Supplier name: " + supplier.getName());
        System.out.println("Supplier ID: " + supplier.getId());
        System.out.println("Product price: " + price);
        System.out.println("Product volume: " + volume);
    }
}
