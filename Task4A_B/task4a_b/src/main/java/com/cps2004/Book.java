package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Book extends Product{
    private String publisher;
    private int pages;
    private String author;

    // Default constructor
    public Book(){
        super();
        publisher = "";
        pages = 0;
        author = "";
    }

    // Parameterized constructor
    public Book(String name, int id, Supplier supplier, int price, int volume, String publisher, int pages, String author){
        super(name, id, supplier, price, volume);
        this.publisher = publisher;
        this.pages = pages;
        this.author = author;
    }

    // Getters and setters
    public String getPublisher() { return publisher; }
    public int getPages() { return pages; }
    public String getAuthor() { return author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPages(int pages) { this.pages = pages; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    // Calculate discounted price
    public abstract double calculate_discount(String month, int quantity);

    // Display product information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product publisher: " + publisher);
        System.out.println("Product pages: " + pages);
        System.out.println("Product author: " + author);
    }
}
