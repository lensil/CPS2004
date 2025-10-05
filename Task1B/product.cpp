#include "product.h"
#include "supplier.h"

// Default constructor
Product::Product() {
    this->name = "";
    this->price = 0;
    this->supplier = NULL;
    this->volume = 0;
}

// Parameterised constructor
Product::Product(string name, int price, Supplier* supplier, int volume, int productID) {
    this->name = name;
    this->price = price;
    this->supplier = supplier;
    this->volume = volume;
    this->productID = productID;
}

// Display product information
void Product::display_product_info() {
    cout << "Name: " << this->name << endl;
    cout << "Price: " << this->price << endl;
    cout << "Supplier: " << endl;
    this->supplier->viewSupplierInfo();
    cout << "Volume: " << this->volume << endl;
    cout << "Product ID: " << this->productID << endl;
}

// Getters and setters
string Product::getName() {
    return this->name;
}

int Product::getPrice() {
    return this->price;
}

Supplier* Product::getSupplier() {
    return this->supplier;
}

int Product::getVolume() {
    return this->volume;
}

int Product::getProductID() {
    return this->productID;
}

void Product::setName(string name) {
    this->name = name;
}

void Product::setPrice(int price) {
    this->price = price;
}

void Product::setSupplier(Supplier* supplier) {
    this->supplier = supplier;
}

void Product::setVolume(int volume) {
    this->volume = volume;
}


void Product::setProductID(int productID) {
    this->productID = productID;
}

// Save product to file
void Product::save(ostream& out) const {
    out << name << "," << price << "," << volume << "," << productID << ",";
    supplier->save(out);
}

// Load product from file
void Product::load(istream& in) {
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    name = token;

    getline(ss, token, ',');
    price = stoi(token);

    getline(ss, token, ',');
    volume = stoi(token);

    getline(ss, token, ',');
    productID = stoi(token);

    getline(ss, token, ',');
    string supplierName = token;

    getline(ss, token, ',');
    int supplierID = stoi(token);
    supplier = new Supplier(supplierName, supplierID);
}

// Destructor
Product::~Product() {
    delete supplier;
}