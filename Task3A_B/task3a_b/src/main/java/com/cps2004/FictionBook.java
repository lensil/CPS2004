package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FictionBook extends Book{

    private String genre;
    private String publicationDate;
    
    // Default constructor
    public FictionBook(){
        super();
        this.genre = "";
        this.publicationDate = "";
    }

    // Parameterized constructor
    public FictionBook(String name, int id, Supplier supplier, int price, int volume, String publisher, int pages, String author, String genre, String publicationDate){
        super(name, id, supplier, price, volume, publisher, pages, author);
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    // Getters and setters
    public String getGenre() { return genre; }
    public String getPublicationDate() { return publicationDate; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product genre: " + genre);
        System.out.println("Product publication date: " + publicationDate);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity) {
        double discountedPrice = getPrice();
        if(month.equals("January") || month.equals("February") || month.equals("March") || month.equals("April") || month.equals("May") || month.equals("June") || month.equals("July") || month.equals("August") || month.equals("September") || month.equals("October") || month.equals("November") || month.equals("December")){
            if(quantity >= 5 && quantity <= 10){
                discountedPrice = getPrice() * 0.9;
            }
            else if(quantity > 10){
                discountedPrice = getPrice() * 0.8;
            }
        }
        return discountedPrice;
    }

}
