package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<StockItem> currentstock;

    // Default constructor
    public Stock() {
        this.currentstock = new ArrayList<>();
    }

    // Getters and setters
    public List<StockItem> getStock() { return this.currentstock; }
    public void setStock(List<StockItem> stock) { this.currentstock = stock; }

    // Remove a product from the stock
    public void removeProduct(int id) {
        for (int i = 0; i < currentstock.size(); i++) {
            if (currentstock.get(i).getProduct().getId() == id) {
                currentstock.remove(i);
                break;
            }
        }
    }

    // Display stock information
    public void viewStock() {
        for (int i = 0; i < currentstock.size(); i++) {
            System.out.println("Stock item " + (i + 1) + ":");
            currentstock.get(i).getProduct().display_product_info();
            System.out.println("Quantity: " + currentstock.get(i).getQuantity());
        }
    }
}
