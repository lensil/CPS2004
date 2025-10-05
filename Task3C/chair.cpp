#include "chair.h"

// Default constructor
Chair::Chair() {
    this->seatLength = 0;
    this->armRests = false;
}

// Parameterised constructor
Chair::Chair(string name, int price, Supplier* supplier, int volume, int productID, string material, string dimensions, double seatLength, bool armRests) : Furniture(name, price, supplier, volume, productID, material, dimensions) {
    this->seatLength = seatLength;
    this->armRests = armRests;
}

// Getters and setters
double Chair::getSeatLength() {
    return this->seatLength;
}

bool Chair::getArmRests() {
    return this->armRests;
}

void Chair::setSeatLength(double seatLength) {
    this->seatLength = seatLength;
}

void Chair::setArmRests(bool armRests) {
    this->armRests = armRests;
}

// Display product information
void Chair::display_product_info() {
    Furniture::display_product_info();
    cout << "Seat Length: " << this->seatLength << endl;
    cout << "Arm Rests: " << this->armRests << endl;
}

// Calculate discount
double Chair::calculate_discount(string month, int quantity) {
    if (month  == "January" && quantity >= 10) {
        return this->getPrice() * 0.5;
    }
    return this->getPrice() * 0.1;
}

// Save product information
void Chair::save(ostream& out) const {
    out << "chair" << "\n";
    Furniture::save(out);
    out << seatLength << "," << armRests << "\n";
}

// Load product information
void Chair::load(istream& in) {
    Furniture::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    seatLength = stod(token);

    getline(ss, token, ',');
    armRests = stoi(token);
}