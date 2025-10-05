#include "fruit.h"

// Default constructor
Fruit::Fruit() {
    this->countryOfOrigin = "";
    this->type = "";
    this->organic = false;
}

// Parameterised constructor
Fruit::Fruit(string name, int price, Supplier* supplier, int volume, int productID, double weight, string expirationDate, string countryOfOrigin, string type, bool organic) : Food(name, price, supplier, volume, productID, weight, expirationDate) {
    this->countryOfOrigin = countryOfOrigin;
    this->type = type;
    this->organic = organic;
}

// Getters and setters
string Fruit::getCountryOfOrigin() {
    return this->countryOfOrigin;
}

string Fruit::getType() {
    return this->type;
}

bool Fruit::getOrganic() {
    return this->organic;
}

void Fruit::setCountryOfOrigin(string countryOfOrigin) {
    this->countryOfOrigin = countryOfOrigin;
}

void Fruit::setType(string type) {
    this->type = type;
}

void Fruit::setOrganic(bool organic) {
    this->organic = organic;
}

// Display product information
void Fruit::display_product_info() {
    Food::display_product_info();
    cout << "Country of Origin: " << this->countryOfOrigin << endl;
    cout << "Type: " << this->type << endl;
    cout << "Organic: " << this->organic << endl;
}

// Calculate discount
double Fruit::calculate_discount(string month, int quantity) {
    if (month == "January" || month == "February" || month == "March" || quantity > 15) {
        return getPrice() * 0.1;
    }
    else {
        return getPrice();
    }
}

// Save product information
void Fruit::save(ostream& out) const {
    out << "fruit" << "\n";
    Food::save(out);
    out << countryOfOrigin << "," << type << "," << organic << "\n";
}

// Load product information
void Fruit::load(istream& in) {
    Food::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    countryOfOrigin = token;

    getline(ss, token, ',');
    type = token;

    getline(ss, token, ',');
    organic = stoi(token);
}