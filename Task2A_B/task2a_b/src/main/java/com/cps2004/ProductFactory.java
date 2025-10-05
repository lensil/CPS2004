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

class ProductParameters {
    String name;
    int id;
    Supplier supplier;
    int price;
    int volume;
    String publisher;
    int pages;
    String author;
    String genre;
    String publicationDate;
    String subject;
    int edition;
    String platform;
    String developer;
    int noOfPlayers;
    String rating;
    String story;
    boolean multiplayer;
    double weight;
    String expirationDate;
    String countryOfOrigin;
    String type;
    boolean organic;
    boolean perishable;
    String ingredients;
    String allergens;
    String furniture_material;
    String dimensions;
    double seatLength;
    boolean armRests;
    boolean extendable;
    String shape;
    int noOfLegs;
    String manufacturer;
    int warranty;
    double megaPixels;
    int zoom;
    boolean wirelessConnectivity;
    double screenSize;
    String operatingSystem;
    int ram;
    String size;
    String brand;
    String clothes_material;
    double inseam;
    double waist;
    String collar;
    boolean graphics;

    public ProductParameters(String name, int id, Supplier supplier, int price, int volume, String publisher, int pages, String author, String genre, String publicationDate, String subject, int edition, String platform, String developer, int noOfPlayers, String rating, String story, boolean multiplayer, double weight, String expirationDate, String countryOfOrigin, String type, boolean organic, boolean perishable, String ingredients, String allergens, String furniture_material, String dimensions, double seatLength, boolean armRests, boolean extendable, String shape, int noOfLegs, String manufacturer, int warranty, double megaPixels, int zoom, boolean wirelessConnectivity, double screenSize, String operatingSystem, int ram, String size, String brand, String clothes_material, double inseam, double waist, String collar, boolean graphics) {
        this.name = name;
        this.id = id;
        this.supplier = supplier;
        this.price = price;
        this.volume = volume;
        this.publisher = publisher;
        this.pages = pages;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.subject = subject;
        this.edition = edition;
        this.platform = platform;
        this.developer = developer;
        this.noOfPlayers = noOfPlayers;
        this.rating = rating;
        this.story = story;
        this.multiplayer = multiplayer;
        this.weight = weight;
        this.expirationDate = expirationDate;
        this.countryOfOrigin = countryOfOrigin;
        this.type = type;
        this.organic = organic;
        this.perishable = perishable;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.furniture_material = furniture_material;
        this.dimensions = dimensions;
        this.seatLength = seatLength;
        this.armRests = armRests;
        this.extendable = extendable;
        this.shape = shape;
        this.noOfLegs = noOfLegs;
        this.manufacturer = manufacturer;
        this.warranty = warranty;
        this.megaPixels = megaPixels;
        this.zoom = zoom;
        this.wirelessConnectivity = wirelessConnectivity;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.size = size;
        this.brand = brand;
        this.clothes_material = clothes_material;
        this.inseam = inseam;
        this.waist = waist;
        this.collar = collar;
        this.graphics = graphics;
    }
}
