package com.cps2004;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class ShipmentItem {
    private int id;
    private int quantity;
    private Product product;
    private Package package_;

    // Default constructor
    public ShipmentItem() {
        this.id = 0;
        this.quantity = 0;
        this.product = null;
        this.package_ = null;
    }

    // Parameterized constructor
    public ShipmentItem(int id, int quantity, Product product, Package package_) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.package_ = package_;
    }

    // Getters and setters
    public int getId() { return id; }
    public int getQuantity() { return quantity; }
    public Product getProduct() { return product; }
    public Package getPackage() { return package_; }
    public void setId(int id) { this.id = id; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setProduct(Product product) { this.product = product; }
    public void setPackage(Package package_) { this.package_ = package_; }

    // Display shipment item information
    public void display_shipment_item() {
        System.out.println("Shipment item ID: " + this.id);
        System.out.println("Shipment item quantity: " + this.quantity);
        System.out.println("Shipment item product: ");
        this.product.display_product_info();
        System.out.println("Shipment item package: ");
        this.package_.viewPackage();
    }

}
