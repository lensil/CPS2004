#include "CLI.h"

// Default constructor
CLI::CLI() {
    this->customers = {};
    this->transport = {};
    this->stock = Stock();
    this->suppliers = {};
    this->packages = {};
}

// Getters
vector<Customer*> CLI::getCustomers() {
    return this->customers;
}

vector<Transport*> CLI::getTransport() {
    return this->transport;
}

Stock CLI::getStock() {
    return this->stock;
}

vector<Supplier*> CLI::getSuppliers() {
    return this->suppliers;
}

vector<Package*> CLI::getPackages() {
    return this->packages;
}

// Stock CRUD operations
void CLI::addItemToStock(Product* product, int quantity) {
    vector<StockItem*> temp = this->stock.getStock();
    temp.push_back(new StockItem(product, quantity));
    this->stock.setStock(temp);
}

void CLI::addItemToStock(Product* product, int quantity, Supplier* supplier) {
    vector<StockItem*> temp = this->stock.getStock();
    temp.push_back(new StockItem(product, quantity));
    this->suppliers.push_back(supplier);
    this->stock.setStock(temp);
}

void CLI::viewStock() {
    this->stock.viewStock();
}

void CLI::updateStockItem(Product* product, int id, int quantity) {
    for (int i = 0; i < this->stock.getStock().size(); i++) {
        if (this->stock.getStock()[i]->getProduct()->getProductID() == id) {
            this->stock.getStock()[i]->setProduct(product);
            this->stock.getStock()[i]->setQuantity(quantity);
        }
    }
}

void CLI::updateStockItem(Product* product, int id, int quantity, Supplier* supplier) {
    for (int i = 0; i < this->stock.getStock().size(); i++) {
        if (this->stock.getStock()[i]->getProduct()->getProductID() == id) {
            this->stock.getStock()[i]->setProduct(product);
            this->stock.getStock()[i]->setQuantity(quantity);
            this->suppliers.push_back(supplier);
        }
    }
}

void CLI::removeFromStock(int id) {
    for (int i = 0; i < this->stock.getStock().size(); i++) {
        if (this->stock.getStock()[i]->getProduct()->getProductID() == id) {
            this->stock.removeStock(id);
        }
    }
}

void CLI::orderStock(int id) {
    for (int i = 0; i < this->stock.getStock().size(); i++) {
        if (this->stock.getStock()[i]->getProduct()->getProductID() == id) {
            this->stock.getStock()[i]->setQuantity(this->stock.getStock()[i]->getQuantity() + 50);
        }
    }
}

// Transport CRUD operations
void CLI::addTransport(Transport* transport) {
    this->transport.push_back(transport);
}

void CLI::viewTransports() {
    for (int i = 0; i < this->transport.size(); i++) {
        cout << "Transport 1" << endl;
        cout << this->transport[i]->deliveryPlan() << endl;
    }
}

void CLI::updateTransport(int id, Transport* transport) {
    for (int i = 0; i < this->transport.size(); i++) {
        if (this->transport[i]->getTransportID() == id) {
            this->transport[i] = transport;
        }
    }
}

void CLI::removeTransport(int id) {
    for (int i = 0; i < this->transport.size(); i++) {
        if (this->transport[i]->getTransportID() == id) {
            this->transport.erase(this->transport.begin() + i);
        }
    }
}

// Package CRUD operations
void CLI::addPackage(Package* package) {
    this->packages.push_back(package);
}

void CLI::viewPackages() {
    for (int i = 0; i < this->packages.size(); i++) {
        cout << "Package 1" << endl;
         this->packages[i]->viewPackage();
    }
}

void CLI::updatePackage(int id, Package* package) {
    for (int i = 0; i < this->packages.size(); i++) {
        if (this->packages[i]->getPackageID() == id) {
            this->packages[i] = package;
        }
    }
}

void CLI::removePackage(int id) {
    for (int i = 0; i < this->packages.size(); i++) {
        if (this->packages[i]->getPackageID() == id) {
            this->packages.erase(this->packages.begin() + i);
        }
    }
}

// Customer CRUD operations
void CLI::addShipment(Shipment* shipment, int customerID) {
    for (int i = 0; i < this->customers.size(); i++) {
        if (this->customers[i]->getID() == customerID) {
            this->customers[i]->getShipments().push_back(shipment);
        }
    }
}

void CLI::addShipment(Shipment* shipment, Customer* customer) {
    customer->getShipments().push_back(shipment);
    this->customers.push_back(customer);
}

void CLI::viewShipments(int customerID) {
    for (int i = 0; i < this->customers.size(); i++) {
        if (this->customers[i]->getID() == customerID) {
            this->customers[i]->viewCustomerShipments();
        }
    }
}

void CLI::updateShipment(int customerID, int shipmentID, Shipment* shipment) {
    for (int i = 0; i < this->customers.size(); i++) {
        if (this->customers[i]->getID() == customerID) {
            for (int j = 0; j < this->customers[i]->getShipments().size(); j++) {
                if (this->customers[i]->getShipments()[j]->getShipmentID() == shipmentID) {
                    this->customers[i]->getShipments()[j] = shipment;
                }
            }
        }
    }
}

void CLI::cancelShipment(int customerID, int shipmentID) {
    for (int i = 0; i < this->customers.size(); i++) {
        if (this->customers[i]->getID() == customerID) {
            this->customers[i]->removeShipment(shipmentID);
        }
    }
}


// Load customers from file
void CLI::load_customers(vector<Customer*>& customers) {
    ifstream inFile("customers_test.txt");
    if (!inFile) { // If file does not exist, return
        return;
    }

    // Load previous state of the customer vector
    string line;

    getline(inFile, line);
    stringstream ss(line);
    int size;
    ss >> size;
    for (int i = 0; i < size; i++) {
        Customer* customer = new Customer();
        customer->load(inFile);
        customers.push_back(customer);
    }
}

// Load transports from file
void CLI::load_transports(vector<Transport*>& transport) {
    ifstream inFile("transport.txt");
    if (!inFile) { // If file does not exist, return
        return;
    }
    string line;

    // Load previous state of the transport vector
    while (getline(inFile, line)) {
        stringstream ss(line);
        string type;
        getline(ss, type, '\n');
        if (type == "truck") {
            Transport* truck1 = new Truck();
            truck1->load(inFile);
            transport.push_back(truck1);
        } else if (type == "ship") {
            Transport* truck1 = new Ship();
            truck1->load(inFile);
            transport.push_back(truck1);
        } else if (type == "plane") {
            Transport* truck1 = new Plane();
            truck1->load(inFile);
            transport.push_back(truck1);
        }
 
    }
    inFile.close();
}

// Load stock from file
void CLI::load_stock(Stock stock) {
    ifstream inFile("stock.txt");
    if (!inFile) { // If file does not exist, return
        return;
    }

    // Load previous state of the stock
    stock.load(inFile);
    inFile.close();
}

// Load suppliers from file
void CLI::load_suppliers(vector<Supplier*>& suppliers) {
    ifstream inFile("suppliers.txt");
    if (!inFile) { // If file does not exist, return
        return;
    }

    // Load previous state of the supplier vector
    string line;

    getline(inFile, line);
    stringstream ss(line);
    int size;
    ss >> size;
    for (int i = 0; i < size; i++) {
        Supplier* supplier = new Supplier();
        supplier->load(inFile);
        suppliers.push_back(supplier);
    }
}

// Load packages from file
void CLI::load_packages(vector<Package*>& packages) {
    ifstream inFile("packages.txt");
    if (!inFile) { // If file does not exist, return
        return;
    }

    // Load previous state of the package vector
    string line;

    getline(inFile, line);
    stringstream ss(line);
    int size;
    ss >> size;
    for (int i = 0; i < size; i++) {
        Package* package = new Package();
        package->load(inFile);
        packages.push_back(package);
    }
}

// Load the saved state of the application
void CLI::restore() {
    load_customers(this->customers);
    load_transports(this->transport);
    load_stock(this->stock);
    load_suppliers(this->suppliers);
    load_packages(this->packages);
}

// Save customers to file
void CLI::save_customers(vector<Customer*> customers) {
    ofstream outFile("customers.txt");
    // Save current state of the customer vector
    outFile << customers.size() << "\n";
    for (Customer* customer : customers) {
        customer->save(outFile);
    }
    outFile.close();
}

// Save transports to file
void CLI::save_transports(vector<Transport*> transport) {
    ofstream outFile("transport.txt");
    // Save current state of the transport vector
    for (Transport* transport : transport) {
        transport->save(outFile);
    }
    outFile.close();
}

// Save stock to file
void CLI::save_stock(Stock stock) {
    ofstream outFile("stock.txt");
    // Save current state of the stock
    this->stock.save(outFile);
    outFile.close();
}

// Save suppliers to file
void CLI::save_suppliers(vector<Supplier*> suppliers) {
    ofstream outFile("suppliers.txt");
    // Save current state of the supplier vector
    outFile << suppliers.size() << "\n";
    for (Supplier* supplier : suppliers) {
        supplier->save(outFile);
    }
    outFile.close();
}

// Save packages to file
void CLI::save_packages(vector<Package*> packages) {
    ofstream outFile("packages.txt");
    // Save current state of the package vector
    outFile << packages.size() << "\n";
    for (Package* package : packages) {
        package->save(outFile);
    }
    outFile.close();
}

// Save the current state of the application
void CLI::save(){
    save_customers(this->customers);
    save_transports(this->transport);
    save_stock(this->stock);
    save_suppliers(this->suppliers);
    save_packages(this->packages);
}

// Destructor
CLI::~CLI() {
    for (int i = 0; i < this->customers.size(); i++) {
        delete this->customers[i];
    }
    for (int i = 0; i < this->transport.size(); i++) {
        delete this->transport[i];
    }
    for (int i = 0; i < this->suppliers.size(); i++) {
        delete this->suppliers[i];
    }
    for (int i = 0; i < this->packages.size(); i++) {
        delete this->packages[i];
    }
}