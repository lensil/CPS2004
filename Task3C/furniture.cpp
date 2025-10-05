#include "furniture.h"

// Default constructor
Furniture::Furniture() {
    this->material = "";
    this->dimensions = "";
}

// Parameterised constructor
Furniture::Furniture(string name, int price, Supplier* supplier, int volume, int productID, string material, string dimensions): Product(name, price, supplier, volume, productID) {
    this->material = material;
    this->dimensions = dimensions;
}

// Getters and setters
string Furniture::getMaterial() {
    return this->material;
}

string Furniture::getDimensions() {
    return this->dimensions;
}

void Furniture::setMaterial(string material) {
    this->material = material;
}

void Furniture::setDimensions(string dimensions) {
    this->dimensions = dimensions;
}

// Display product information
void Furniture::display_product_info() {
    Product::display_product_info();
    cout << "Material: " << this->material << endl;
    cout << "Dimensions: " << this->dimensions << endl;
}

// Save product information to file
void Furniture::save(ostream& out) const {
    Product::save(out);
    out << material << "," << dimensions << "\n";
}

// Load product information from file
void Furniture::load(istream& in) {
    Product::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    material = token;

    getline(ss, token, ',');
    dimensions = token;
}