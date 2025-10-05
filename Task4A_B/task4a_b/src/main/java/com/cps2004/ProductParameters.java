package com.cps2004;

public class ProductParameters {
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

    // Setters and getters
    public String getName() { return name; }
    public int getId() { return id; }
    public Supplier getSupplier() { return supplier; }
    public int getPrice() { return price; }
    public int getVolume() { return volume; }
    public String getPublisher() { return publisher; }
    public int getPages() { return pages; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getPublicationDate() { return publicationDate; }
    public String getSubject() { return subject; }
    public int getEdition() { return edition; }
    public String getPlatform() { return platform; }
    public String getDeveloper() { return developer; }
    public int getNoOfPlayers() { return noOfPlayers; }
    public String getRating() { return rating; }
    public String getStory() { return story; }
    public boolean getMultiplayer() { return multiplayer; }
    public double getWeight() { return weight; }
    public String getExpirationDate() { return expirationDate; }
    public String getCountryOfOrigin() { return countryOfOrigin; }
    public String getType() { return type; }
    public boolean getOrganic() { return organic; }
    public boolean getPerishable() { return perishable; }
    public String getIngredients() { return ingredients; }
    public String getAllergens() { return allergens; }
    public String getFurniture_material() { return furniture_material; }
    public String getDimensions() { return dimensions; }
    public double getSeatLength() { return seatLength; }
    public boolean getArmRests() { return armRests; }
    public boolean getExtendable() { return extendable; }
    public String getShape() { return shape; }
    public int getNoOfLegs() { return noOfLegs; }
    public String getManufacturer() { return manufacturer; }
    public int getWarranty() { return warranty; }
    public double getMegaPixels() { return megaPixels; }
    public int getZoom() { return zoom; }
    public boolean getWirelessConnectivity() { return wirelessConnectivity; }
    public double getScreenSize() { return screenSize; }
    public String getOperatingSystem() { return operatingSystem; }
    public int getRam() { return ram; }
    public String getSize() { return size; }
    public String getBrand() { return brand; }
    public String getClothes_material() { return clothes_material; }
    public double getInseam() { return inseam; }
    public double getWaist() { return waist; }
    public String getCollar() { return collar; }
    public boolean getGraphics() { return graphics; }
    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public void setPrice(int price) { this.price = price; }
    public void setVolume(int volume) { this.volume = volume; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPages(int pages) { this.pages = pages; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setEdition(int edition) { this.edition = edition; }
    public void setPlatform(String platform) { this.platform = platform; }
    public void setDeveloper(String developer) { this.developer = developer; }
    public void setNoOfPlayers(int noOfPlayers) { this.noOfPlayers = noOfPlayers; }
    public void setRating(String rating) { this.rating = rating; }
    public void setStory(String story) { this.story = story; }
    public void setMultiplayer(boolean multiplayer) { this.multiplayer = multiplayer; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }
    public void setType(String type) { this.type = type; }
    public void setOrganic(boolean organic) { this.organic = organic; }
    public void setPerishable(boolean perishable) { this.perishable = perishable; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setAllergens(String allergens) { this.allergens = allergens; }
    public void setFurniture_material(String furniture_material) { this.furniture_material = furniture_material; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    public void setSeatLength(double seatLength) { this.seatLength = seatLength; }
    public void setArmRests(boolean armRests) { this.armRests = armRests; }
    public void setExtendable(boolean extendable) { this.extendable = extendable; }
    public void setShape(String shape) { this.shape = shape; }
    public void setNoOfLegs(int noOfLegs) { this.noOfLegs = noOfLegs; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setWarranty(int warranty) { this.warranty = warranty; }
    public void setMegaPixels(double megaPixels) { this.megaPixels = megaPixels; }
    public void setZoom(int zoom) { this.zoom = zoom; }
    public void setWirelessConnectivity(boolean wirelessConnectivity) { this.wirelessConnectivity = wirelessConnectivity; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }
    public void setRam(int ram) { this.ram = ram; }
    public void setSize(String size) { this.size = size; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setClothes_material(String clothes_material) { this.clothes_material = clothes_material; }
    public void setInseam(double inseam) { this.inseam = inseam; }
    public void setWaist(double waist) { this.waist = waist; }
    public void setCollar(String collar) { this.collar = collar; }
    public void setGraphics(boolean graphics) { this.graphics = graphics; }
}
