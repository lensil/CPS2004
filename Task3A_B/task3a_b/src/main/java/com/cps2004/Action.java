package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Action extends VideoGame {
    private int noOfPlayers;
    private String rating;

    // Default constructor
    public Action(){
        super();
        this.noOfPlayers = 0;
        this.rating = "";
    }

    // Parameterized constructor
    public Action(int noOfPlayers, String rating, String name, int id, Supplier supplier, int price, int volume, String platform, String developer){
        super(name, id, supplier, price, volume, platform, developer);
        this.noOfPlayers = noOfPlayers;
        this.rating = rating;
    }

    // Getters and setters
    public int getNoOfPlayers() { return noOfPlayers; }
    public String getRating() { return rating; }
    public void setNoOfPlayers(int noOfPlayers) { this.noOfPlayers = noOfPlayers; }
    public void setRating(String rating) { this.rating = rating; }

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product number of players: " + noOfPlayers);
        System.out.println("Product rating: " + rating);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if (month.equals("January") || month.equals("February") || month.equals("March") || quantity >= 5) {
            return getPrice() * 0.2;
        } else {
            return getPrice() * 0.3;
        }
    }
}
