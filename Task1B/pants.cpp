#include "pants.h"

// Default constructor
Pants::Pants() {
    this->inseam = 0;
    this->waist = 0;
}

// Parameterised constructor
Pants::Pants(string name, int price, Supplier* supplier, int volume, int productID, string size, string brand, string material, double inseam, double waist) : Clothes(name, price, supplier, volume, productID, size, brand, material) {
    this->inseam = inseam;
    this->waist = waist;
}

// Getters and setters
double Pants::getInseam() {
    return this->inseam;
}

double Pants::getWaist() {
    return this->waist;
}

void Pants::setInseam(double inseam) {
    this->inseam = inseam;
}

void Pants::setWaist(double waist) {
    this->waist = waist;
}

// Display product information
void Pants::display_product_info() {
    Clothes::display_product_info();
    cout << "Inseam: " << this->inseam << endl;
    cout << "Waist: " << this->waist << endl;
}

// Calculate discount
double Pants::calculate_discount(string month, int quantity) {
    if (month == "January" || quantity > 7) {
        return this->getPrice() * 0.1;
    } else {
        return this->getPrice() * 0.05;
    }
}

// Save product information
void Pants::save(ostream& out) const {
    out << "pants" << "\n";
    Clothes::save(out);
    out << inseam << "," << waist << "\n";
}

// Load product information
void Pants::load(istream& in) {
    Clothes::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    inseam = stod(token);

    getline(ss, token, ',');
    waist = stod(token);
}