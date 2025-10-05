#include "clothes.h"

// Default constructor
Clothes::Clothes() {
    this->size = "";
    this->brand = "";
    this->material = "";
}

// Parameterised constructor
Clothes::Clothes(string name, int price, Supplier* supplier, int volume, int productID, string size, string brand, string material) : Product(name, price, supplier, volume, productID) {
    this->size = size;
    this->brand = brand;
    this->material = material;
}

// Getters and setters
string Clothes::getSize() {
    return this->size;
}

string Clothes::getBrand() {
    return this->brand;
}

string Clothes::getMaterial() {
    return this->material;
}

void Clothes::setSize(string size) {
    this->size = size;
}

void Clothes::setBrand(string brand) {
    this->brand = brand;
}

void Clothes::setMaterial(string material) {
    this->material = material;
}

// Display product information
void Clothes::display_product_info() {
    Product::display_product_info();
    cout << "Size: " << this->size << endl;
    cout << "Brand: " << this->brand << endl;
    cout << "Material: " << this->material << endl;
}

// Save product information to file
void Clothes::save(ostream& out) const {
    Product::save(out);
    out << size << "," << brand << "," << material << "\n";
}

// Load product information from file
void Clothes::load(istream& in) {
    Product::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    size = token;

    getline(ss, token, ',');
    brand = token;
    
    getline(ss, token, ',');
    material = token;
}