package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Textbook extends Book{
    private String subject;
    private int edition;

    // Default constructor
    public Textbook() {
        this.subject = "Math";
        this.edition = 1;
    }

    // Parameterized constructor
    public Textbook(String name, int id, Supplier supplier, int price, int volume, String publisher, int pages, String author, String subject, int edition) {
        super(name, id, supplier, price, volume, publisher, pages, author);
        this.subject = subject;
        this.edition = edition;
    }

    // Getters and setters
    public String getSubject() { return this.subject;}
    public int getEdition() { return this.edition;}
    public void setSubject(String subject) { this.subject = subject;}
    public void setEdition(int edition) { this.edition = edition;}

    // Display textbook information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product subject: " + subject);
        System.out.println("Product edition: " + edition);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity) {
        double discount = 0;
        if (month.equals("January") || month.equals("February") || month.equals("March") && quantity >= 5) {
            discount = 0.2;
        }
        else if ((month.equals("April") || (month.equals("May") || (month.equals("June") && quantity >= 5)))) {
            discount = 0.1;
        }
        else if (month.equals("July") || month.equals("August") || month.equals("September") && quantity >= 10) {
            discount = 0.05;
        }   
        else if ((month.equals("October") || month.equals("November") || month.equals("December")) || quantity >= 10) {
        discount = 0.0;
        }
        return getPrice() * discount;
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        newItem.put("type", "textbook");
        super.save(newItem);
        newItem.put("subject", this.subject);
        newItem.put("edition", this.edition);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        subject = node.get("subject").asText();
        edition = node.get("edition").asInt();
    }

}
