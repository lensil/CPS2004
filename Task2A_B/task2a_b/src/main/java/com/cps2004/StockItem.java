package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StockItem {
    private Product product;
    private int quantity;

    // Default constructor
    public StockItem(){
        this.product = null;
        this.quantity = 0;
    }

    // Parameterized constructor
    public StockItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setProduct(Product product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Save product information to file
    public void save(ObjectNode newItem) {
        product.save(newItem);
        newItem.put("quantity", this.quantity);
    }

    // Load product information from file
    public void load(JsonNode node) {
        product.load(node);
        quantity = node.get("quantity").asInt();
    }
}
