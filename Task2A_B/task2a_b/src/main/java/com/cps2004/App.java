package com.cps2004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Testing the transport factory
        TransportFactory transportFactory = new TransportFactory();
        Transport truck = transportFactory.createTransport("Truck", 100, 10, 1, Arrays.asList("Motorway 1", "Motorway 2"));
        Transport ship = transportFactory.createTransport("Ship", 100, 10, 1, Arrays.asList("Harbour 1", "Harbour 2"));
        System.out.println(truck.deliveryPlan());
        System.out.println();
        System.out.println(ship.deliveryPlan());
        System.out.println();

        // Testing the product factory
        ProductFactory productFactory = new ProductFactory();
        Product textbook = productFactory.createProduct("textbook", new ProductParameters("Textbook", 1, new Supplier("Name 1", 1), 1, 1, "Publisher 1", 1, "Author 1", null, "Date 1", "Subject", 1, null, null, 0, null, null, false, 0, null, null, null, false, false, null, null, null, null, 0, false, false, null, 0, null, 0, 0, 0, false, 0, null, 0, null, null, null, 0, 0, null, false));
        Product fictionBook = productFactory.createProduct("fictionBook", new ProductParameters("Fiction Book", 2, new Supplier("Name 2", 2), 2, 2, "Publisher 2", 2, "Author 2", "Genre", "Date 2", null, 0, null, null, 0, null, null, false, 0, null, null, null, false, false, null, null, null, null, 0, false, false, null, 0, null, 0, 0, 0, false, 0, null, 0, null, null, null, 0, 0, null, false));
        textbook.display_product_info();
        System.out.println();
        fictionBook.display_product_info();
        
        
        Shipment shipment = new Shipment(truck, new ArrayList<>(), false, 100.0, "September", 1);
        Product product = new Chair(10.0, true, "Chair", 1, new Supplier("Supplier", 1), 100, 10, "Material", "Dimensions");
        Package package_ = new Package(1, 1, "Box", 1);
        ShipmentItem shipmentItem = new ShipmentItem(1, 1, product, package_);
        shipment.getPackagedItems().add(shipmentItem);

        shipment.generateDeliveryPlan();
        System.out.println();

        // Decorator 1
        Shipment discountedShipment = new GlobalDiscountDecorator(shipment, 0.5);
        discountedShipment.generateDeliveryPlan();
        System.out.println();

        // Decorator 2
        List<String> newRoute = Arrays.asList("Motorway 3", "Motorway 4");
        Shipment updatedRouteShipment = new DeliveryPlanDecorator(discountedShipment, newRoute);
        updatedRouteShipment.generateDeliveryPlan();
    }
    
}
