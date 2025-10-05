package com.cps2004;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Facade {
    private String path;

    public Facade(String path) {
        this.path = path;
    }

    public void save(List<Transport> transports, List<Supplier> suppliers, List<Customer> customers, List<Package> packages, Stock stock) {
        for (Transport transport : transports) {
            DataStructures.Transport transportProto = serializeTransport(transport);
            try {
                FileOutputStream output = new FileOutputStream(path + "/transports/" + transport.getTransportID() + ".transport");
                transportProto.writeTo(output);
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private DataStructures.Transport serializeTransport(Transport transport) {
        DataStructures.Transport.Builder builder = DataStructures.Transport.newBuilder();

        if (transport instanceof Ship ship) {
            DataStructures.Ship shipProto = serializeShip(ship);
            builder.setShip(shipProto);
        } else if (transport instanceof Plane plane) {
            DataStructures.Plane planeProto = serializePlane(plane);
            builder.setPlane(planeProto);
        } else if (transport instanceof Truck truck) {
            DataStructures.Truck truckProto = serializeTruck(truck);
            builder.setTruck(truckProto);
        }

        builder.setTransportSpeed(transport.getTransportSpeed());
        builder.setCostPerKm(transport.getCostPerKm());
        builder.setTransportID(transport.getTransportID());

        return builder.build();
    }


    private DataStructures.Ship serializeShip(Ship ship) {
        DataStructures.Ship.Builder builder = DataStructures.Ship.newBuilder();
        DataStructures.Transport transportProto = DataStructures.Transport.newBuilder()
                .setTransportSpeed(ship.getTransportSpeed())
                .setCostPerKm(ship.getCostPerKm())
                .setTransportID(ship.getTransportID())
                .build();
        builder.setTransport(transportProto);
        for (String harbour : ship.getRoute()) {
            builder.addHarbours(harbour);
        }
        return builder.build();
    }

    private DataStructures.Plane serializePlane(Plane plane) {
        DataStructures.Plane.Builder builder = DataStructures.Plane.newBuilder();
        DataStructures.Transport transportProto = DataStructures.Transport.newBuilder()
                .setTransportSpeed(plane.getTransportSpeed())
                .setCostPerKm(plane.getCostPerKm())
                .setTransportID(plane.getTransportID())
                .build();
        builder.setTransport(transportProto);
        for (String airport : plane.getRoute()) {
            builder.addAirSpaces(airport);
        }
        return builder.build();
    }

    private DataStructures.Truck serializeTruck(Truck truck) {
        DataStructures.Truck.Builder builder = DataStructures.Truck.newBuilder();
        DataStructures.Transport transportProto = DataStructures.Transport.newBuilder()
                .setTransportSpeed(truck.getTransportSpeed())
                .setCostPerKm(truck.getCostPerKm())
                .setTransportID(truck.getTransportID())
                .build();
        builder.setTransport(transportProto);
        for (String motorway : truck.getRoute()) {
            builder.addRoads(motorway);
        }
        return builder.build();
    }

    private DataStructures.Package serializePackage(Package package_) {
        DataStructures.Package.Builder builder = DataStructures.Package.newBuilder();
        builder.setPackageID(package_.getPackageID());
        builder.setCost(package_.getCost());
        builder.setPackagingUnits(package_.getPackagingUnits());
        builder.setType(package_.getType());
        return builder.build();
    }

    private DataStructures.Supplier serializeSupplier(Supplier Supplier) {
        DataStructures.Supplier.Builder builder = DataStructures.Supplier.newBuilder();
        builder.setSupplierID(Supplier.getId());
        builder.setName(Supplier.getName());
        return builder.build();
    }

    private DataStructures.Product serializeProduct(Product product) {
        DataStructures.Product.Builder productBuilder = DataStructures.Product.newBuilder();
        if (product instanceof Book book) {
            DataStructures.Book.Builder bookBuilder = DataStructures.Book.newBuilder();
            if (book instanceof FictionBook fictionBook) {
                DataStructures.FictionBook fictionBookProto = serializeFictionBook(fictionBook);
                bookBuilder.setFictionBook(fictionBookProto);
                productBuilder.setBook(bookBuilder);
            }
            else if (book instanceof Textbook textbook) {
                DataStructures.Textbook textbookProto = serializeTextbook(textbook);
                bookBuilder.setTextbook(textbookProto);
                productBuilder.setBook(bookBuilder);
            }
        }
        else if (product instanceof VideoGame videoGame) {
            DataStructures.VideoGame.Builder videoGameBuilder = DataStructures.VideoGame.newBuilder();
            if (videoGame instanceof Action action) {
                DataStructures.Action actionProto = serializeAction(action);
                videoGameBuilder.setAction(actionProto);
                productBuilder.setVideoGame(videoGameBuilder);
            }
            else if (videoGame instanceof RPG rpg) {
                DataStructures.RPG rpgProto = serializeRPG(rpg);
                videoGameBuilder.setRpg(rpgProto);
                productBuilder.setVideoGame(videoGameBuilder);
            }
        }
        else if (product instanceof Electronics electronics) {
            DataStructures.Electronics.Builder electronicsBuilder = DataStructures.Electronics.newBuilder();
            if (electronics instanceof Camera camera) {
                DataStructures.Camera cameraProto = serializeCamera(camera);
                electronicsBuilder.setCamera(cameraProto);
                productBuilder.setElectronics(electronicsBuilder);
            }
            else if (electronics instanceof Laptop laptop) {
                DataStructures.Laptop laptopProto = serializeLaptop(laptop);
                electronicsBuilder.setLaptop(laptopProto);
                productBuilder.setElectronics(electronicsBuilder);
            }
        }
        else if (product instanceof Food food) {
            DataStructures.Food.Builder foodBuilder = DataStructures.Food.newBuilder();
            if (food instanceof Fruit fruit) {
                DataStructures.Fruit fruitProto = serializeFruit(fruit);
                foodBuilder.setFruit(fruitProto);
                productBuilder.setFood(foodBuilder);
            }
            else if (food instanceof PremadeLunch premadeLunch) {
                DataStructures.PremadeLunch premadeLunchProto = serializePremadeLunch(premadeLunch);
                foodBuilder.setPremadeLunch(premadeLunchProto);
                productBuilder.setFood(foodBuilder);
            }
        }
        else if (product instanceof Clothes clothes) {
            DataStructures.Clothes.Builder clothesBuilder = DataStructures.Clothes.newBuilder();
            if (clothes instanceof Pants pants) {
                DataStructures.Pants pantsProto = serializePants(pants);
                clothesBuilder.setPants(pantsProto);
                productBuilder.setClothes(clothesBuilder);
            }
            else if (clothes instanceof TShirt tShirt) {
                DataStructures.TShirt tShirtProto = serializeTShirt(tShirt);
                clothesBuilder.setTShirt(tShirtProto);
                productBuilder.setClothes(clothesBuilder);
            }
        }
        else if (product instanceof Furniture furniture) {
            DataStructures.Furniture.Builder furnitureBuilder = DataStructures.Furniture.newBuilder();
            if (furniture instanceof Chair chair) {
                DataStructures.Chair chairProto = serializeChair(chair);
                furnitureBuilder.setChair(chairProto);
                productBuilder.setFurniture(furnitureBuilder);
            }
            else if (furniture instanceof Table table) {
                DataStructures.Table tableProto = serializeTable(table);
                furnitureBuilder.setTable(tableProto);
                productBuilder.setFurniture(furnitureBuilder);
            }
        }
        return productBuilder.build();
    }

    private DataStructures.Book serializeBook(Book book) {
        DataStructures.Book.Builder builder = DataStructures.Book.newBuilder();
        builder.setAuthor(book.getAuthor());
        builder.setPages(book.getPages());
        builder.setPublisher(book.getPublisher());
        builder.setProduct(
                DataStructures.Product.newBuilder()
                        .setProductID(book.getId())
                        .setSupplier(serializeSupplier(book.getSupplier()))
                        .setVolume(book.getVolume())
                        .setName(book.getName())
                        .setPrice(book.getPrice())
                        .build()
        );
        return builder.build();
    }

    private DataStructures.FictionBook serializeFictionBook(FictionBook fictionBook) {
        DataStructures.FictionBook.Builder builder = DataStructures.FictionBook.newBuilder();
        builder.setGenre(fictionBook.getGenre());
        builder.setPublicationDate(fictionBook.getPublicationDate());
        builder.setBook(serializeBook(fictionBook));
        return builder.build();
    }

    private DataStructures.Textbook serializeTextbook(Textbook textbook) {
        DataStructures.Textbook.Builder builder = DataStructures.Textbook.newBuilder();
        builder.setSubject(textbook.getSubject());
        builder.setEdition(textbook.getEdition());
        builder.setBook(serializeBook(textbook));
        return builder.build();
    }

    private DataStructures.VideoGame serializeVideoGame(VideoGame videoGame) {
        DataStructures.VideoGame.Builder builder = DataStructures.VideoGame.newBuilder();
        builder.setPlatform(videoGame.getPlatform());
        builder.setDeveloper(videoGame.getDeveloper());
        builder.setProduct(
                DataStructures.Product.newBuilder()
                        .setProductID(videoGame.getId())
                        .setSupplier(serializeSupplier(videoGame.getSupplier()))
                        .setVolume(videoGame.getVolume())
                        .setName(videoGame.getName())
                        .setPrice(videoGame.getPrice())
                        .build()
        );
        return builder.build();
    }

    private DataStructures.Action serializeAction(Action action) {
        DataStructures.Action.Builder builder = DataStructures.Action.newBuilder();
        builder.setNoOfPlayers(action.getNoOfPlayers());
        builder.setRating(action.getRating());
        builder.setVideoGame(serializeVideoGame(action));
        return builder.build();
    }

    private DataStructures.RPG serializeRPG(RPG rpg) {
        DataStructures.RPG.Builder builder = DataStructures.RPG.newBuilder();
        builder.setStory(rpg.getStory());
        builder.setMultiplayer(rpg.getMultiplayer());
        builder.setVideoGame(serializeVideoGame(rpg));
        return builder.build();
    }

    private DataStructures.Electronics serializeElectronics(Electronics electronics) {
        DataStructures.Electronics.Builder builder = DataStructures.Electronics.newBuilder();
        builder.setManufacturer(electronics.getManufacturer());
        builder.setWarranty(electronics.getWarranty());
        builder.setProduct(
                DataStructures.Product.newBuilder()
                        .setProductID(electronics.getId())
                        .setSupplier(serializeSupplier(electronics.getSupplier()))
                        .setVolume(electronics.getVolume())
                        .setName(electronics.getName())
                        .setPrice(electronics.getPrice())
                        .build()
        );
        return builder.build();
    }

    private DataStructures.Camera serializeCamera(Camera camera) {
        DataStructures.Camera.Builder builder = DataStructures.Camera.newBuilder();
        builder.setMegaPixels(camera.getMegaPixels());
        builder.setZoom(camera.getZoom());
        builder.setWirelessConnectivity(camera.getWirelessConnectivity());
        builder.setElectronics(serializeElectronics(camera));
        return builder.build();
    }

    private DataStructures.Laptop serializeLaptop(Laptop laptop) {
        DataStructures.Laptop.Builder builder = DataStructures.Laptop.newBuilder();
        builder.setScreenSize(laptop.getScreenSize());
        builder.setOperatingSystem(laptop.getOperatingSystem());
        builder.setRam(laptop.getRam());
        builder.setElectronics(serializeElectronics(laptop));
        return builder.build();
    }

    private DataStructures.Food serializeFood(Food food) {
        DataStructures.Food.Builder builder = DataStructures.Food.newBuilder();
        builder.setWeight(food.getWeight());
        builder.setExpirationDate(food.getExpirationDate());
        builder.setProduct(
                DataStructures.Product.newBuilder()
                        .setProductID(food.getId())
                        .setSupplier(serializeSupplier(food.getSupplier()))
                        .setVolume(food.getVolume())
                        .setName(food.getName())
                        .setPrice(food.getPrice())
                        .build()
        );
        return builder.build();
    }

    private DataStructures.Fruit serializeFruit(Fruit fruit) {
        DataStructures.Fruit.Builder builder = DataStructures.Fruit.newBuilder();
        builder.setCountryOfOrigin(fruit.getCountryOfOrigin());
        builder.setType(fruit.getType());
        builder.setOrganic(fruit.getOrganic());
        builder.setFood(serializeFood(fruit));
        return builder.build();
    }

    private DataStructures.PremadeLunch serializePremadeLunch(PremadeLunch premadeLunch) {
        DataStructures.PremadeLunch.Builder builder = DataStructures.PremadeLunch.newBuilder();
        builder.setPerishable(premadeLunch.getPerishable());
        builder.setIngredients(premadeLunch.getIngredients());
        builder.setAllergens(premadeLunch.getAllergens());
        builder.setFood(serializeFood(premadeLunch));
        return builder.build();
    }

    private DataStructures.Clothes serializeClothes(Clothes clothes) {
        DataStructures.Clothes.Builder builder = DataStructures.Clothes.newBuilder();
        builder.setSize(clothes.getSize());
        builder.setBrand(clothes.getBrand());
        builder.setMaterial(clothes.getMaterial());
        builder.setProduct(
                DataStructures.Product.newBuilder()
                        .setProductID(clothes.getId())
                        .setSupplier(serializeSupplier(clothes.getSupplier()))
                        .setVolume(clothes.getVolume())
                        .setName(clothes.getName())
                        .setPrice(clothes.getPrice())
                        .build()
        );
        return builder.build();
    }

    private DataStructures.Pants serializePants(Pants pants) {
        DataStructures.Pants.Builder builder = DataStructures.Pants.newBuilder();
        builder.setInseam(pants.getInseam());
        builder.setWaist(pants.getWaist());
        builder.setClothes(serializeClothes(pants));
        return builder.build();
    }

    private DataStructures.TShirt serializeTShirt(TShirt tShirt) {
        DataStructures.TShirt.Builder builder = DataStructures.TShirt.newBuilder();
        builder.setCollar(tShirt.getCollar());
        builder.setGraphics(tShirt.getGraphics());
        builder.setClothes(serializeClothes(tShirt));
        return builder.build();
    }

    private DataStructures.Furniture serializeFurniture(Furniture furniture) {
        DataStructures.Furniture.Builder builder = DataStructures.Furniture.newBuilder();
        builder.setMaterial(furniture.getMaterial());
        builder.setDimensions(furniture.getDimensions());
        builder.setProduct(
                DataStructures.Product.newBuilder()
                        .setProductID(furniture.getId())
                        .setSupplier(serializeSupplier(furniture.getSupplier()))
                        .setVolume(furniture.getVolume())
                        .setName(furniture.getName())
                        .setPrice(furniture.getPrice())
                        .build()
        );
        return builder.build();
    }

    private DataStructures.Chair serializeChair(Chair chair) {
        DataStructures.Chair.Builder builder = DataStructures.Chair.newBuilder();
        builder.setSeatLength(chair.getSeatLength());
        builder.setArmRests(chair.getArmRests());
        builder.setFurniture(serializeFurniture(chair));
        return builder.build();
    }

    private DataStructures.Table serializeTable(Table table) {
        DataStructures.Table.Builder builder = DataStructures.Table.newBuilder();
        builder.setExtendable(table.getExtendable());
        builder.setShape(table.getShape());
        builder.setNoOfLegs(table.getNoOfLegs());
        builder.setFurniture(serializeFurniture(table));
        return builder.build();
    }

    private DataStructures.StockItem serializeStockItem(StockItem stockItem) {
        DataStructures.StockItem.Builder builder = DataStructures.StockItem.newBuilder();
        builder.setQuantity(stockItem.getQuantity());
        builder.setProduct(serializeProduct(stockItem.getProduct()));
        return builder.build();
    }

    private DataStructures.Stock serializeStock(Stock stock) {
        DataStructures.Stock.Builder builder = DataStructures.Stock.newBuilder();
        for (StockItem stockItem : stock.getStock()) {
            builder.addCurrentstock(serializeStockItem(stockItem));
        }
        return builder.build();
    }

    private DataStructures.ShipmentItem serializeShipmentItem(ShipmentItem shipmentItem) {
        DataStructures.ShipmentItem.Builder builder = DataStructures.ShipmentItem.newBuilder();
        builder.setId(shipmentItem.getId());
        builder.setQuantity(shipmentItem.getQuantity());
        builder.setProduct(serializeProduct(shipmentItem.getProduct()));
        builder.setPackage(serializePackage(shipmentItem.getPackage()));
        return builder.build();
    }

    private DataStructures.Shipment serializeShipment(Shipment shipment) {
        DataStructures.Shipment.Builder builder = DataStructures.Shipment.newBuilder();
        builder.setDispatchedDate(shipment.getDispatchDate());
        builder.setDistance(shipment.getDistance());
        builder.setShipmentID(shipment.getShipmentID());
        builder.setDispatched(shipment.isDispatched());
        builder.setTransport(serializeTransport(shipment.getTransport()));
        for (ShipmentItem shipmentItem : shipment.getPackagedItems()) {
            builder.addPackagedItems(serializeShipmentItem(shipmentItem));
        }
        return builder.build();
    }

    private DataStructures.Customer serializeCustomer(Customer customer) {
        DataStructures.Customer.Builder builder = DataStructures.Customer.newBuilder();
        builder.setName(customer.getName());
        builder.setAddress(customer.getAddress());
        builder.setID(customer.getID());
        builder.setDistanceFromWarehouse(customer.getDistanceFromWarehouse());
        for (Shipment shipment : customer.getShipments()) {
            builder.addShipments(serializeShipment(shipment));
        }
        return builder.build();
    }

    public void save(State state) {
        DataStructures.State.Builder builder = DataStructures.State.newBuilder();
        builder.setStock(serializeStock(state.getStock()));
        for (Transport transport : state.getTransports()) {
            builder.addTransports(serializeTransport(transport));
        }
        for (Package package_ : state.getPackages()) {
            builder.addPackages(serializePackage(package_));
        }
        for (Supplier supplier : state.getSuppliers()) {
            builder.addSuppliers(serializeSupplier(supplier));
        }
        for (Customer customer : state.getCustomers()) {
            builder.addCustomers(serializeCustomer(customer));
        }
        DataStructures.State proto = builder.build();
        try (FileOutputStream output = new FileOutputStream(path)){
            proto.writeTo(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Transport deserializeTransport(DataStructures.Transport proto) {
        Transport transport;
        switch (proto.getTransportTypeCase()) {
            case SHIP:
                transport = deserializeShip(proto.getShip());
                break;
            case PLANE:
                transport = deserializePlane(proto.getPlane());
                break;
            case TRUCK:
                transport = deserializeTruck(proto.getTruck());
                break;
            default:
                throw new IllegalArgumentException("Unknown transport type");
        }
        transport.setTransportSpeed(proto.getTransportSpeed());
        transport.setCostPerKm(proto.getCostPerKm());
        transport.setTransportID(proto.getTransportID());

        return transport;
    }

    private Ship deserializeShip(DataStructures.Ship proto) {
        Ship ship = new Ship();
        for (String harbour : proto.getHarboursList()) {
            ship.getRoute().add(harbour);
        }
        return ship;
    }

    private Plane deserializePlane(DataStructures.Plane proto) {
        Plane plane = new Plane();
        for (String airport : proto.getAirSpacesList()) {
            plane.getRoute().add(airport);
        }
        return plane;
    }

    private Truck deserializeTruck(DataStructures.Truck proto) {
        Truck truck = new Truck();
        for (String motorway : proto.getRoadsList()) {
            truck.getRoute().add(motorway);
        }
        return truck;
    }

    private Package deserializePackage(DataStructures.Package proto) {
        Package package_ = new Package();
        package_.setPackageID(proto.getPackageID());
        package_.setCost(proto.getCost());
        package_.setPackagingUnits(proto.getPackagingUnits());
        package_.setType(proto.getType());
        return package_;
    }

    private Supplier deserializeSupplier(DataStructures.Supplier proto) {
        Supplier supplier = new Supplier();
        supplier.setId(proto.getSupplierID());
        supplier.setName(proto.getName());
        return supplier;
    }

private Product deserializeProduct(DataStructures.Product proto) {
        Product product;
        switch (proto.getProductTypeCase()) {
            case BOOK:
                product = deserializeBook(proto.getBook());
                break;
            case VIDEOGAME:
                product = deserializeVideoGame(proto.getVideoGame());
                break;
            case ELECTRONICS:
                product = deserializeElectronics(proto.getElectronics());
                break;
            case FOOD:
                product = deserializeFood(proto.getFood());
                break;
            case CLOTHES:
                product = deserializeClothes(proto.getClothes());
                break;
            case FURNITURE:
                product = deserializeFurniture(proto.getFurniture());
                break;
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
        product.setId(proto.getProductID());
        product.setSupplier(deserializeSupplier(proto.getSupplier()));
        product.setVolume(proto.getVolume());
        product.setName(proto.getName());
        product.setPrice(proto.getPrice());
        return product;
    }

    private Book deserializeBook(DataStructures.Book proto) {
        Book book;
        switch (proto.getBookTypeCase()) {
            case FICTIONBOOK:
                book = deserializeFictionBook(proto.getFictionBook());
                break;
            case TEXTBOOK:
                book = deserializeTextbook(proto.getTextbook());
                break;
            default:
                throw new IllegalArgumentException("Unknown book type");
        }
        book.setAuthor(proto.getAuthor());
        book.setPages(proto.getPages());
        book.setPublisher(proto.getPublisher());
        return book;
    }

    private FictionBook deserializeFictionBook(DataStructures.FictionBook proto) {
        FictionBook fictionBook = new FictionBook();
        fictionBook.setGenre(proto.getGenre());
        fictionBook.setPublicationDate(proto.getPublicationDate());
        return fictionBook;
    }

    private Textbook deserializeTextbook(DataStructures.Textbook proto) {
        Textbook textbook = new Textbook();
        textbook.setSubject(proto.getSubject());
        textbook.setEdition(proto.getEdition());
        return textbook;
    }

    private VideoGame deserializeVideoGame(DataStructures.VideoGame proto) {
        VideoGame videoGame;
        switch (proto.getVideoGameTypeCase()) {
            case ACTION:
                videoGame = deserializeAction(proto.getAction());
                break;
            case RPG:
                videoGame = deserializeRPG(proto.getRpg());
                break;
            default:
                throw new IllegalArgumentException("Unknown video game type");
        }
        videoGame.setPlatform(proto.getPlatform());
        videoGame.setDeveloper(proto.getDeveloper());
        return videoGame;
    }

    private Action deserializeAction(DataStructures.Action proto) {
        Action action = new Action();
        action.setNoOfPlayers(proto.getNoOfPlayers());
        action.setRating(proto.getRating());
        return action;
    }

    private RPG deserializeRPG(DataStructures.RPG proto) {
        RPG rpg = new RPG();
        rpg.setStory(proto.getStory());
        rpg.setMultiplayer(proto.getMultiplayer());
        return rpg;
    }

    private Electronics deserializeElectronics(DataStructures.Electronics proto) {
        Electronics electronics;
        switch (proto.getElectronicsTypeCase()) {
            case CAMERA:
                electronics = deserializeCamera(proto.getCamera());
                break;
            case LAPTOP:
                electronics = deserializeLaptop(proto.getLaptop());
                break;
            default:
                throw new IllegalArgumentException("Unknown electronics type");
        }
        electronics.setManufacturer(proto.getManufacturer());
        electronics.setWarranty(proto.getWarranty());
        return electronics;
    }

    private Camera deserializeCamera(DataStructures.Camera proto) {
        Camera camera = new Camera();
        camera.setMegaPixels(proto.getMegaPixels());
        camera.setZoom(proto.getZoom());
        camera.setWirelessConnectivity(proto.getWirelessConnectivity());
        return camera;
    }

    private Laptop deserializeLaptop(DataStructures.Laptop proto) {
        Laptop laptop = new Laptop();
        laptop.setScreenSize(proto.getScreenSize());
        laptop.setOperatingSystem(proto.getOperatingSystem());
        laptop.setRam(proto.getRam());
        return laptop;
    }

    private Food deserializeFood(DataStructures.Food proto) {
        Food food;
        switch (proto.getFoodTypeCase()) {
            case FRUIT:
                food = deserializeFruit(proto.getFruit());
                break;
            case PREMADELUNCH:
                food = deserializePremadeLunch(proto.getPremadeLunch());
                break;
            default:
                throw new IllegalArgumentException("Unknown food type");
        }
        food.setWeight(proto.getWeight());
        food.setExpirationDate(proto.getExpirationDate());
        return food;
    }

    private Fruit deserializeFruit(DataStructures.Fruit proto) {
        Fruit fruit = new Fruit();
        fruit.setCountryOfOrigin(proto.getCountryOfOrigin());
        fruit.setType(proto.getType());
        fruit.setOrganic(proto.getOrganic());
        return fruit;
    }

    private PremadeLunch deserializePremadeLunch(DataStructures.PremadeLunch proto) {
        PremadeLunch premadeLunch = new PremadeLunch();
        premadeLunch.setPerishable(proto.getPerishable());
        premadeLunch.setIngredients(proto.getIngredients());
        premadeLunch.setAllergens(proto.getAllergens());
        return premadeLunch;
    }

    private Clothes deserializeClothes(DataStructures.Clothes proto) {
        Clothes clothes;
        switch (proto.getClothesTypeCase()) {
            case PANTS:
                clothes = deserializePants(proto.getPants());
                break;
            case TSHIRT:
                clothes = deserializeTShirt(proto.getTShirt());
                break;
            default:
                throw new IllegalArgumentException("Unknown clothes type");
        }
        clothes.setSize(proto.getSize());
        clothes.setBrand(proto.getBrand());
        clothes.setMaterial(proto.getMaterial());
        return clothes;
    }

    private Pants deserializePants(DataStructures.Pants proto) {
        Pants pants = new Pants();
        pants.setInseam(proto.getInseam());
        pants.setWaist(proto.getWaist());
        return pants;
    }

    private TShirt deserializeTShirt(DataStructures.TShirt proto) {
        TShirt tShirt = new TShirt();
        tShirt.setCollar(proto.getCollar());
        tShirt.setGraphics(proto.getGraphics());
        return tShirt;
    }

    private Furniture deserializeFurniture(DataStructures.Furniture proto) {
        Furniture furniture;
        switch (proto.getFurnitureTypeCase()) {
            case CHAIR:
                furniture = deserializeChair(proto.getChair());
                break;
            case TABLE:
                furniture = deserializeTable(proto.getTable());
                break;
            default:
                throw new IllegalArgumentException("Unknown furniture type");
        }
        furniture.setMaterial(proto.getMaterial());
        furniture.setDimensions(proto.getDimensions());
        return furniture;
    }

    private Chair deserializeChair(DataStructures.Chair proto) {
        Chair chair = new Chair();
        chair.setSeatLength(proto.getSeatLength());
        chair.setArmRests(proto.getArmRests());
        return chair;
    }

    private Table deserializeTable(DataStructures.Table proto) {
        Table table = new Table();
        table.setExtendable(proto.getExtendable());
        table.setShape(proto.getShape());
        table.setNoOfLegs(proto.getNoOfLegs());
        return table;
    }

    private StockItem deserializeStockItem(DataStructures.StockItem proto) {
        StockItem stockItem = new StockItem();
        stockItem.setQuantity(proto.getQuantity());
        stockItem.setProduct(deserializeProduct(proto.getProduct()));
        return stockItem;
    }

    private Stock deserializeStock(DataStructures.Stock proto) {
        Stock stock = new Stock();
        for (DataStructures.StockItem stockItem : proto.getCurrentstockList()) {
            stock.getStock().add(deserializeStockItem(stockItem));
        }
        return stock;
    }

    private ShipmentItem deserializeShipmentItem(DataStructures.ShipmentItem proto) {
        ShipmentItem shipmentItem = new ShipmentItem();
        shipmentItem.setId(proto.getId());
        shipmentItem.setQuantity(proto.getQuantity());
        shipmentItem.setProduct(deserializeProduct(proto.getProduct()));
        shipmentItem.setPackage(deserializePackage(proto.getPackage()));
        return shipmentItem;
    }

    private Shipment deserializeShipment(DataStructures.Shipment proto) {
        Shipment shipment = new Shipment();
        shipment.setDispatchDate(proto.getDispatchedDate());
        shipment.setDistance(proto.getDistance());
        shipment.setShipmentID(proto.getShipmentID());
        shipment.setDispatched(proto.getDispatched());
        shipment.setTransport(deserializeTransport(proto.getTransport()));
        for (DataStructures.ShipmentItem shipmentItem : proto.getPackagedItemsList()) {
            shipment.getPackagedItems().add(deserializeShipmentItem(shipmentItem));
        }
        return shipment;
    }

    private Customer deserializeCustomer(DataStructures.Customer proto) {
        Customer customer = new Customer();
        customer.setName(proto.getName());
        customer.setAddress(proto.getAddress());
        customer.setID(proto.getID());
        customer.setDistanceFromWarehouse(proto.getDistanceFromWarehouse());
        for (DataStructures.Shipment shipment : proto.getShipmentsList()) {
            customer.getShipments().add(deserializeShipment(shipment));
        }
        return customer;
    }

    public State load() {
DataStructures.State proto = null;
        try (FileInputStream input = new FileInputStream(path)){
            proto = DataStructures.State.parseFrom(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        State state = new State();
        state.setStock(deserializeStock(proto.getStock()));
        for (DataStructures.Transport transport : proto.getTransportsList()) {
            state.getTransports().add(deserializeTransport(transport));
        }
        for (DataStructures.Package package_ : proto.getPackagesList()) {
            state.getPackages().add(deserializePackage(package_));
        }
        for (DataStructures.Supplier supplier : proto.getSuppliersList()) {
            state.getSuppliers().add(deserializeSupplier(supplier));
        }
        for (DataStructures.Customer customer : proto.getCustomersList()) {
            state.getCustomers().add(deserializeCustomer(customer));
        }
        return state;
    }

}
