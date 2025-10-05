package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PremadeLunch extends Food {
    private boolean perishable;
    private String ingredients;
    private String allergens;

    // Default constructor
    public PremadeLunch() {
        super();
        this.perishable = false;
        this.ingredients = "";
        this.allergens = "";
    }

    // Parameterized constructor
    public PremadeLunch(boolean perishable, String ingredients, String allergens, String name, int id, Supplier supplier, int price, int volume, double weight, String expirationDate) {
        super(name, id, supplier, price, volume, weight, expirationDate);
        this.perishable = perishable;
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    // Getters and setters
    public boolean getPerishable() { return perishable;}
    public String getIngredients() { return ingredients;}
    public String getAllergens() { return allergens;}
    public void setPerishable(boolean perishable) { this.perishable = perishable;}
    public void setIngredients(String ingredients) { this.ingredients = ingredients;}
    public void setAllergens(String allergens) { this.allergens = allergens;}

    // Display premade lunch information
    public void display_product_info() {
        super.display_product_info();
        System.out.println("Product perishable: " + perishable);
        System.out.println("Product ingredients: " + ingredients);
        System.out.println("Product allergens: " + allergens);
    }

    @Override
    // Calculate discounted price
    public double calculate_discount(String month, int quantity) {
        if (month.equals("January") || month.equals("February") || month.equals("March") || quantity > 10) {
            return getPrice() * 0.5;
        }
        else {
            return getPrice() * 0.1;
        }
    }

    // Save product information to file
    public void save(ObjectNode newItem) {
        newItem.put("type", "premadeLunch");
        super.save(newItem);
        newItem.put("perishable", perishable);
        newItem.put("ingredients", ingredients);
        newItem.put("allergens", allergens);
    }

    // Load product information from file
    public void load(JsonNode node) {
        super.load(node);
        this.perishable = node.get("perishable").asBoolean();
        this.ingredients = node.get("ingredients").asText();
        this.allergens = node.get("allergens").asText();
    }
}
