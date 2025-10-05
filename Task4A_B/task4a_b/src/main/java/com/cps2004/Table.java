package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Table extends Furniture {
    private boolean extendable;
    private String shape;
    private int noOfLegs;

    // Default constructor
    public Table(){
        super();
        this.extendable = false;
        this.shape = "";
        this.noOfLegs = 0;
    }

    // Parameterized constructor
    public Table(boolean extendable, String shape, int noOfLegs,String name, int id, Supplier supplier, int price, int volume, String material, String dimensions){
        super(name, id, supplier, price, volume, material, dimensions);
        this.extendable = extendable;
        this.shape = shape;
        this.noOfLegs = noOfLegs;
    }

    // Setters and getters
    public boolean getExtendable(){ return this.extendable;}
    public String getShape(){ return this.shape;}
    public int getNoOfLegs(){ return this.noOfLegs;}
    public void setExtendable(boolean extendable){ this.extendable = extendable;}
    public void setShape(String shape){ this.shape = shape;}
    public void setNoOfLegs(int noOfLegs){ this.noOfLegs = noOfLegs;}

    // Display product information
    public void display_product_info(){
        super.display_product_info();
        System.out.println("Product extendable: " + extendable);
        System.out.println("Product shape: " + shape);
        System.out.println("Product number of legs: " + noOfLegs);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity){
        if (month.equals("January") || quantity > 7) {
            return this.getPrice() * 0.1;
        }
        return this.getPrice() * 0.05;
    }

}
