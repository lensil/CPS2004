#include "shipmentitem.h"

// Default constructor
ShipmentItem::ShipmentItem() {
    this->id = 0;
    this->quantity = 0;
    this->product = NULL;
    this->package = NULL;
}

// Parameterised constructor
ShipmentItem::ShipmentItem(int id, int quantity, Product* product, Package* package) {
    this->id = id;
    this->quantity = quantity;
    this->product = product;
    this->package = package;
}

// Getters and setters
int ShipmentItem::getId() {
    return this->id;
}

int ShipmentItem::getQuantity() {
    return this->quantity;
}

Product* ShipmentItem::getProduct() {
    return this->product;
}

Package* ShipmentItem::getPackage() {
    return this->package;
}

void ShipmentItem::setId(int id) {
    this->id = id;
}

void ShipmentItem::setQuantity(int quantity) {
    this->quantity = quantity;
}

void ShipmentItem::setProduct(Product* product) {
    this->product = product;
}

void ShipmentItem::setPackage(Package* package) {
    this->package = package;
}

// Display shipment item information
void ShipmentItem::display_shipment_item() {
    cout << "Shipment Item ID: " << this->id << endl;
    cout << "Quantity: " << this->quantity << endl;
    cout << "Product: " << endl;
    this->product->display_product_info();
    cout << "Package: " << endl;
    this->package->viewPackage();
}

// Save shipment item information to file
void ShipmentItem::save(ostream& out) const {
    this->product->save(out);
    this->package->save(out);
    out << this->id << "," << this->quantity << "\n";
}

// Load shipment item information from file
void ShipmentItem::load(istream& in) {
    this->product->load(in);
    this->package->load(in);

    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    this->id = stoi(token);

    getline(ss, token, ',');
    this->quantity = stoi(token);
}

// Destructor
ShipmentItem::~ShipmentItem() {
    delete this->product;
    delete this->package;
}