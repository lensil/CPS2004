#include "tshirt.h"

// Default constructor
TShirt::TShirt() {
    this->collar = "";
    this->graphics = false;
}

// Parameterised constructor
TShirt::TShirt(string name, int price, Supplier* supplier, int volume, int productID, string size, string brand, string material, string collar, bool graphics) : Clothes(name, price, supplier, volume, productID, size, brand, material) {
    this->collar = collar;
    this->graphics = graphics;
}

// Getters and setters
string TShirt::getCollar() {
    return this->collar;
}

bool TShirt::getGraphics() {
    return this->graphics;
}

void TShirt::setCollar(string collar) {
    this->collar = collar;
}

void TShirt::setGraphics(bool graphics) {
    this->graphics = graphics;
}

// Display product information
void TShirt::display_product_info() {
    Clothes::display_product_info();
    cout << "Collar: " << this->collar << endl;
    cout << "Graphics: " << this->graphics << endl;
}

// Calculate discount
double TShirt::calculate_discount(string month, int quantity) {
    if (month == "January" && quantity >= 5) {
        return this->getPrice() * 0.1;
    } else {
        return this->getPrice() * 0.05;
    }
}

// Save product information
void TShirt::save(ostream& out) const {
    out << "tshirt" << "\n";
    Clothes::save(out);
    out << collar << "," << graphics << "\n";
}

// Load product information
void TShirt::load(istream& in) {
    Clothes::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    collar = token;

    getline(ss, token, ',');
    graphics = stoi(token);
}