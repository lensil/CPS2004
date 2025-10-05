#include <iostream>
#include "CLI.h" 

using namespace std;

int main(int argc, char const *argv[])
{
    CLI cli;
    cli.restore(); // restoring the state
    

    // Adding a product associated with a new supplier
    Supplier* supplier1 = new Supplier("Supplier 1", 1);
    Product* product1 = new Action("Name1", 1, supplier1, 1, 1, "Platfrom 1", "Developer 1", 1, "Rating 1");  
    cli.addItemToStock(product1, 10, supplier1); 
    
    // Adding a product associated with an existing supplier
    Supplier* supplier2 = new Supplier("Supplier 2", 2);
    Product* product2 = new Action("Name2", 2, supplier2, 2, 2, "Platfrom 2", "Developer 2", 2, "Rating 2");
    cli.getSuppliers().push_back(supplier2);
    cli.addItemToStock(product2, 20);
    

    // Update Stock associated with an existing supplier
    product1->setName("New Name");
    cli.updateStockItem(product1, product1->getProductID(), 25);

    // Update Stock associated with a new supplie
    Supplier* supplier3 = new Supplier("Supplier 3", 3);
    product2->setSupplier(supplier3);
    cli.updateStockItem(product2, product2->getProductID(), 60, supplier3);

    // Remove from stock
    cli.removeFromStock(product1->getProductID()); 

    // View stock
    cli.viewStock(); 

    cout << endl;

    Transport* truck = new Truck(1, 1, {"Motorway1, Motorway2, Motorway3"}, 1);
    Transport* plane = new Plane(2, 2, {"Airport1, Airport2, Airport3"}, 2);

    // Add transport
    cli.addTransport(truck);
    cli.addTransport(plane);

    // Update transport
    truck->setCostPerKm(3);
    cli.updateTransport(truck->getTransportID(), truck);

    // Remove transport
    cli.removeTransport(plane->getTransportID());

    // View transport
    cli.viewTransports();

    cout << endl;

    // Add package
    Package* package1 = new Package(1, 1.1, "Box", 1);
    Package* package2 = new Package(2, 2.2, "Envelope", 2);
    cli.addPackage(package1);
    cli.addPackage(package2);

    // Update package
    package1->setCost(3.3);
    cli.updatePackage(package1->getPackageID(), package1);

    // Remove package
    cli.removePackage(package2->getPackageID());
    
    // View package
    cli.viewPackages();

    cout << endl;

    // Add shipment associated with an existing customer
    Customer* customer1 = new Customer("John Doe", "123 Main St", 10.5, 1);
    cli.addCustomer(customer1);
    ShipmentItem* item1 = new ShipmentItem(1, 1, product1, package1);
    Shipment* shipment1 = new Shipment(truck, 1.1, "september", 1);
    shipment1->addPackagedItems(item1);
    cli.addShipment(shipment1, customer1->getID());

    // Add shipment associated with a new customer
    Customer* customer2 = new Customer("Jane Doe", "456 Main St", 15.5, 2);
    ShipmentItem* item2 = new ShipmentItem(2, 2, product2, package2);
    Shipment* shipment2 = new Shipment(truck, 2.2, "october", 2);
    shipment2->addPackagedItems(item2);
    cli.addShipment(shipment2, customer2);

    // Update shipment
    shipment2->setDistance(3.3);
    cli.updateShipment(customer2->getID(), shipment2->getShipmentID(), shipment2);

    // Remove shipment
    cli.cancelShipment(customer1->getID(), shipment1->getShipmentID());

    // View shipment
    cli.viewShipments(customer2->getID());

    cli.save(); // saving the state

    return 0;
}
