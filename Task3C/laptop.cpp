#include "laptop.h"

// Default constructor
Laptop::Laptop() {
    this->screenSize = 0;
    this->operatingSystem = "";
    this->ram = 0;
}

// Parameterised constructor
Laptop::Laptop(string name, int price, Supplier* supplier, int volume, int productID, string manufacturer, int warranty, double screenSize, string operatingSystem, int ram) : Electronics(name, price, supplier, volume, productID, manufacturer, warranty) {
    this->screenSize = screenSize;
    this->operatingSystem = operatingSystem;
    this->ram = ram;
}

// Getters and setters
double Laptop::getScreenSize() {
    return this->screenSize;
}

string Laptop::getOperatingSystem() {
    return this->operatingSystem;
}

int Laptop::getRam() {
    return this->ram;
}

void Laptop::setScreenSize(double screenSize) {
    this->screenSize = screenSize;
}

void Laptop::setOperatingSystem(string operatingSystem) {
    this->operatingSystem = operatingSystem;
}

void Laptop::setRam(int ram) {
    this->ram = ram;
}

// Display product information
void Laptop::display_product_info() {
    Electronics::display_product_info();
    cout << "Screen Size: " << this->screenSize << endl;
    cout << "Operating System: " << this->operatingSystem << endl;
    cout << "RAM: " << this->ram << endl;
}

// Calculate discount
double Laptop::calculate_discount(string month, int quantity) {
    if ((month == "January" || month == "February" || month == "March") && quantity >= 10) {
        return this->getPrice() * 0.1;
    } else {
        return this->getPrice();
    }
}

// Save product information
void Laptop::save(ostream& out) const {
    out << "laptop" << "\n";
    Electronics::save(out);
    out << screenSize << "," << operatingSystem << "," << ram << "\n";
}

// Load product information
void Laptop::load(istream& in) {
    Electronics::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    screenSize = stod(token);

    getline(ss, token, ',');
    operatingSystem = token;

    getline(ss, token, ',');
    ram = stoi(token);
}
