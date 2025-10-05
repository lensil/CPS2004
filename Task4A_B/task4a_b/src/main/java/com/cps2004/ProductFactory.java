package com.cps2004;

public class ProductFactory {
    public Product createProduct(String productType) {
        if (productType.equalsIgnoreCase("fictionBook")) {
            return new FictionBook();
        } else if (productType.equalsIgnoreCase("textbook")) {
            return new Textbook();
        } else if (productType.equalsIgnoreCase("pants")) {
            return new Pants();
        } else if (productType.equalsIgnoreCase("tshirt")) {
            return new TShirt();
        } else if (productType.equalsIgnoreCase("fruit")) {
            return new Fruit();
        } else if (productType.equalsIgnoreCase("premadeLunch")) {
            return new PremadeLunch();
        } else if (productType.equalsIgnoreCase("camera")) {
            return new Camera();
        } else if (productType.equalsIgnoreCase("laptop")) {
            return new Laptop();
        } else if (productType.equalsIgnoreCase("chair")) {
            return new Chair();
        } else if (productType.equalsIgnoreCase("table")) {
            return new Table();
        } else if (productType.equalsIgnoreCase("rpg")) {
            return new RPG();
        } else if (productType.equalsIgnoreCase("action")) {
            return new Action();
        }
        throw new IllegalArgumentException("Invalid product type: " + productType);
    }

    public Product createProduct(String productType, ProductParameters parameters) {
        if (productType.equalsIgnoreCase("textbook")) {
            return new Textbook(parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.publisher, parameters.pages, parameters.author, parameters.subject, parameters.edition);
        } else if (productType.equalsIgnoreCase("fictionBook")) {
            return new FictionBook(parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.publisher, parameters.pages, parameters.author, parameters.genre, parameters.publicationDate);
        } else if (productType.equalsIgnoreCase("fruit")) {
            return new Fruit(parameters.countryOfOrigin, parameters.type, parameters.organic, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.weight, parameters.expirationDate);
        } else if (productType.equalsIgnoreCase("premadelunch")) {
            return new PremadeLunch(parameters.perishable, parameters.ingredients, parameters.allergens, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.weight, parameters.expirationDate);
        } else if (productType.equalsIgnoreCase("camera")) {
            return new Camera(parameters.megaPixels, parameters.zoom, parameters.wirelessConnectivity, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.manufacturer, parameters.warranty);           
        } else if (productType.equalsIgnoreCase("laptop")) {
            return new Laptop(parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.manufacturer, parameters.warranty, parameters.screenSize, parameters.operatingSystem, parameters.ram);
        } else if (productType.equalsIgnoreCase("tshirt")) {
            return new TShirt(parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.size, parameters.brand, parameters.clothes_material, parameters.collar, parameters.graphics);
        } else if (productType.equalsIgnoreCase("pants")) {
            return new Pants(parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.size, parameters.brand, parameters.clothes_material, parameters.inseam, parameters.waist);
        } else if (productType.equalsIgnoreCase("chair")) {
            return new Chair(parameters.seatLength, parameters.armRests, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.furniture_material, parameters.dimensions);
        } else if (productType.equalsIgnoreCase("table")) {
            return new Table(parameters.extendable, parameters.shape, parameters.noOfLegs, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.furniture_material, parameters.dimensions);
        } else if (productType.equalsIgnoreCase("rpg")) {
            return new RPG(parameters.story, parameters.multiplayer, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.platform, parameters.genre);
        } else if (productType.equalsIgnoreCase("action")) {
            return new Action(parameters.noOfPlayers, parameters.rating, parameters.name, parameters.id, parameters.supplier, parameters.price, parameters.volume, parameters.platform, parameters.genre);
        }
        throw new IllegalArgumentException("Invalid product type: " + productType);
    }

}


