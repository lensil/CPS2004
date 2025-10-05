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
    public List<StockItem> getStock() { return currentstock; }
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

    // Update the quantity of a product in the stock
    public void updateStockQuantity(int productID, int quantity) {
        for (int i = 0; i < this.currentstock.size(); i++) {
            if (this.currentstock.get(i).getProduct().getId() == productID) {
                this.currentstock.get(i).setQuantity(this.currentstock.get(i).getQuantity() + quantity);
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
    // Save stock information to file
    public void save(File file) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (StockItem item : currentstock) {
            ObjectNode newItem = mapper.createObjectNode();
            item.save(newItem);
            arrayNode.add(newItem);
        }
        try {
            mapper.writeValue(file, arrayNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load stock information from file
    public void load(File file) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (rootNode != null) {
            int i = 0;
            for (JsonNode node : rootNode) {
                JsonNode tempnode = rootNode.get(i);
                String type = tempnode.get("type").asText();
                StockItem item = new StockItem();
                Product product;

                switch (type) {
                    case "premadeLunch":
                        product = new PremadeLunch();
                        break;
                    case "fruit":
                        product = new Fruit();
                        break;
                    case "textbook":
                        product = new Textbook();
                        break;
                    case "fictionbook":
                        product = new FictionBook();
                        break;
                    case "pants":
                        product = new Pants();
                        break;
                    case "tshirt":
                        product = new TShirt();
                        break;
                    case "table":
                        product = new Table();
                        break;
                    case "chair":
                        product = new Chair();
                        break;
                    case "laptop":
                        product = new Laptop();
                        break;
                    case "camera":
                        product = new Camera();
                        break;
                    case "rpg":
                        product = new RPG();
                        break;
                    case "action":
                        product = new Action();
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown type: " + type);
                }
                item.setProduct(product);
                item.load(node);
                currentstock.add(item);
                i++;
            }
        }
    }
}
