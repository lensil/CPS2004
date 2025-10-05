#include "table.h"

// Default constructor
Table::Table() {
    this->shape = "";
    this->noOfLegs = 0;
}

// Parameterised constructor
Table::Table(string name, int price, Supplier* supplier, int volume, int productID, string material, string dimensions, bool extendable, string shape, int legs) : Furniture(name, price, supplier, volume, productID, material, dimensions) {
    this->extendable = extendable;
    this->shape = shape;
    this->noOfLegs = legs;
}

// Getters and setters
bool Table::getExtendable() {
    return this->extendable;
}

string Table::getShape() {
    return this->shape;
}

int Table::getNoOfLegs() {
    return this->noOfLegs;
}

void Table::setExtendable(bool extendable) {
    this->extendable = extendable;
}

void Table::setShape(string shape) {
    this->shape = shape;
}

void Table::setNoOfLegs(int noOfLegs) {
    this->noOfLegs = noOfLegs;
}

// Display product information
void Table::display_product_info() {
    Furniture::display_product_info();
    cout << "Extendable: " << this->extendable << endl;
    cout << "Shape: " << this->shape << endl;
    cout << "No. of legs: " << this->noOfLegs << endl;
}

// Calculate discount
double Table::calculate_discount( string month, int quantity) {
    if (month == "January" || quantity > 7) {
        return this->getPrice() * 0.1;
    }
    return this->getPrice() * 0.05;
}

// Save product information
void Table::save(ostream& out) const {
    out << "table" << "\n";
    Furniture::save(out);
    out << extendable << "," << shape << "," << noOfLegs << "\n";
}

// Load product information
void Table::load(istream& in) {
    Furniture::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    extendable = stoi(token);

    getline(ss, token, ',');
    shape = token;

    getline(ss, token, ',');
    noOfLegs = stoi(token);
}