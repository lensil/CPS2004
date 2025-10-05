#include "food.h"

// Default constructor
Food::Food() {
    this->weight = 0;
    this->expirationDate = "";
}

// Parameterised constructor
Food::Food(string name, int price, Supplier* supplier, int volume, int productID, double weight, string expirationDate) : Product(name, price, supplier, volume, productID) {
    this->weight = weight;
    this->expirationDate = expirationDate;
}

// Getters and setters
double Food::getWeight() {
    return this->weight;
}

string Food::getExpirationDate() {
    return this->expirationDate;
}

void Food::setWeight(double weight) {
    this->weight = weight;
}

void Food::setExpirationDate(string expirationDate) {
    this->expirationDate = expirationDate;
}

// Display product information
void Food::display_product_info() {
    Product::display_product_info();
    cout << "Weight: " << this->weight << endl;
    cout << "Expiration Date: " << this->expirationDate << endl;
}

// Save product information to file
void Food::save(ostream& out) const {
    Product::save(out);
    out << weight << "," << expirationDate << "\n";
}

// Load product information from file
void Food::load(istream& in) {
    Product::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    weight = stod(token);
    
    getline(ss, token, ',');
    expirationDate = token;
}