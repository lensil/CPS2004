package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RPG extends VideoGame{
    private String story;
    private boolean multiplayer;

    // Default constructor
    public RPG(){
        super();
        this.story = "";
        this.multiplayer = false;
    }

    // Parameterized constructor
    public RPG(String story, boolean multiplayer, String name, int id, Supplier supplier, int price, int volume, String platform, String genre){
        super(name, id, supplier, price, volume, platform, genre);
        this.story = story;
        this.multiplayer = multiplayer;
    }

    // Setters and getters
    public String getStory(){ return this.story;}
    public boolean getMultiplayer(){ return this.multiplayer;}
    public void setStory(String story){ this.story = story;}
    public void setMultiplayer(boolean multiplayer){ this.multiplayer = multiplayer;}

    // Display product information
    public void display_product_info(){
        super.display_product_info();
        System.out.println("Product story: " + story);
        System.out.println("Product multiplayer: " + multiplayer);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if ((month.equals("January") || month.equals("February") || month.equals("March")) && quantity >= 20) {
            return getPrice() * 0.2;
        } else {
            return getPrice() * 0.1;
        }
    }

}
