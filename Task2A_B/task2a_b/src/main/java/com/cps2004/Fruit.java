package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Fruit extends Food{
    private String countryOfOrigin;
    private String type;
    private boolean organic;

    // Default constructor
    public Fruit(){
        super();
        this.countryOfOrigin = "";
        this.type = "";
        this.organic = false;
    }

    // Parameterized constructor
    public Fruit(String countryOfOrigin, String type, boolean organic, String name, int id, Supplier supplier, int price, int volume, double weight, String expirationDate){
        super(name, id, supplier, price, volume, weight, expirationDate);
        this.countryOfOrigin = countryOfOrigin;
        this.type = type;
        this.organic = organic;
    }

    // Getters and setters
    public String getCountryOfOrigin(){return countryOfOrigin;}
    public String getType(){return type;}
    public boolean getOrganic(){return organic;}
    public void setCountryOfOrigin(String countryOfOrigin){this.countryOfOrigin = countryOfOrigin;}
    public void setType(String type){this.type = type;}
    public void setOrganic(boolean organic){this.organic = organic;}

    // Display fruit information
    public void display_product_info(){
        super.display_product_info();
        System.out.println("Product country of origin: " + countryOfOrigin);
        System.out.println("Product type: " + type);
        System.out.println("Product organic: " + organic);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if (month.equals("January") || month.equals("February") || month.equals("March") || quantity > 15) {
            return getPrice() * 0.1;
        }
        else {
            return getPrice();
        }
    }

    // Save product information to file
    public void save(ObjectNode newItem){
        newItem.put("type", "fruit");
        super.save(newItem);
        newItem.put("countryOfOrigin", countryOfOrigin);
        newItem.put("type", type);
        newItem.put("organic", organic);
    }

    // Load product information from file
    public void load(JsonNode node){
        super.load(node);
        this.countryOfOrigin = node.get("countryOfOrigin").asText();
        this.type = node.get("type").asText();
        this.organic = node.get("organic").asBoolean();
    }
}
