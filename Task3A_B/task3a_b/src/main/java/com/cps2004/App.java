package com.cps2004;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        CLI cli = new CLI();

        cli.restore();

        Supplier supplier1 = new Supplier("Supplier 1", 1);
        Product product1 = new Action(1, "Rating1", "Name1", 1, supplier1, 1, 1, "Platform 1", "Developer 1");
        cli.addItemToStock(product1, 10, supplier1);
        Supplier supplier2 = new Supplier("Supplier 2", 2);
        Product product2 = new Action(2, "Rating2", "Name2", 2, supplier2, 2, 2, "Platform 2", "Developer 2");
        cli.getSuppliers().add(supplier2); 
        cli.addItemToStock(product2, 20);
        cli.viewStock();
        Transport truck = new Truck(1, 1, 1, List.of("Motorway1", "Motorway2", "Motorway3"));
        Transport plane = new Plane(2, 2, 2, List.of("Airport1", "Airport2", "Airport3"));
        cli.addTransport(truck);
        cli.addTransport(plane);
        cli.viewTransport();
        Package package1 = new Package(1, 1.1, "Box", 1);
        Package package2 = new Package(2, 2.2, "Envelope", 2);
        cli.addPackage(package1);
        cli.addPackage(package2);
        cli.viewPackages();
        Customer customer1 = new Customer("John Doe", "123 Main St", 1, 10.5, new ArrayList<>());
        cli.getCustomers().add(customer1);
        ShipmentItem item1 = new ShipmentItem(1, 1, product1, package1);
        Shipment shipment1 = new Shipment(truck, new ArrayList<>(), false, 1.1, "september", 1);
        shipment1.getPackagedItems().add(item1);
        cli.addShipment(shipment1, customer1.getID());
        Customer customer2 = new Customer("Jane Doe", "456 Main St", 2, 15.5, new ArrayList<>());
        ShipmentItem item2 = new ShipmentItem(2, 2, product2, package2);
        Shipment shipment2 = new Shipment(truck, new ArrayList<>(), false, 2.2, "october", 2);
        shipment2.getPackagedItems().add(item2);
        cli.addShipment(shipment2, customer2);
        cli.viewShipments(customer2.getID());

        cli.save();

    }
}
