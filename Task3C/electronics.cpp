#include "electronics.h"
#include "supplier.h" 

// Default constructor
Electronics::Electronics() {
    this->manufacturer = "";
    this->warranty = 0;
}

// Parameterised constructor
Electronics::Electronics(string name, int price, Supplier* supplier, int volume, int productID, string manufacturer, int warranty) : Product(name, price, supplier, volume, productID) {
    this->manufacturer = manufacturer;
    this->warranty = warranty;
}

// Getters and setters
string Electronics::getManufacturer() {
    return this->manufacturer;
}

int Electronics::getWarranty() {
    return this->warranty;
}

void Electronics::setManufacturer(string manufacturer) {
    this->manufacturer = manufacturer;
}

void Electronics::setWarranty(int warranty) {
    this->warranty = warranty;
}

// Display product information
void Electronics::display_product_info() {
    Product::display_product_info();
    cout << "Manufacturer: " << this->manufacturer << endl;
    cout << "Warranty: " << this->warranty << endl;
}   

// Save product information to file
void Electronics::save(ostream& out) const {
    Product::save(out);
    out << manufacturer << "," << warranty << "\n";
}

// Load product information from file
void Electronics::load(istream& in) {
    Product::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    manufacturer = token;

    getline(ss, token, ',');
    warranty = stoi(token);
}