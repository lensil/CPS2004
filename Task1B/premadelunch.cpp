#include "premadelunch.h"

// Default constructor
PremadeLunch::PremadeLunch() {
    this->perishable = false;
    this->ingredients = "";
    this->allergens = "";
}

// Parameterised constructor
PremadeLunch::PremadeLunch(string name, int price, Supplier* supplier, int volume, int productID, double weight, string expirationDate, bool perishable, string ingredients, string allergens) : Food(name, price, supplier, volume, productID, weight, expirationDate) {
    this->perishable = perishable;
    this->ingredients = ingredients;
    this->allergens = allergens;
}

// Getters and setters
bool PremadeLunch::getPerishable() {
    return this->perishable;
}

string PremadeLunch::getIngredients() {
    return this->ingredients;
}

string PremadeLunch::getAllergens() {
    return this->allergens;
}

void PremadeLunch::setPerishable(bool perishable) {
    this->perishable = perishable;
}

void PremadeLunch::setIngredients(string ingredients) {
    this->ingredients = ingredients;
}

void PremadeLunch::setAllergens(string allergens) {
    this->allergens = allergens;
}

// Display product information
void PremadeLunch::display_product_info() {
    Food::display_product_info();
    cout << "Perishable: " << this->perishable << endl;
    cout << "Ingredients: " << this->ingredients << endl;
    cout << "Allergens: " << this->allergens << endl;
}

// Calculate discount
double PremadeLunch::calculate_discount(string month, int quantity) {
    if (month == "January" || month == "February" || month == "March" || quantity > 10) {
        return getPrice() * 0.5;
    }
    else {
        return getPrice() * 0.1;
    }
}

// Save product information
void PremadeLunch::save(ostream& out) const {
    out << "premadeLunch" << "\n";
    Food::save(out);
    out << perishable << "," << ingredients << "," << allergens << "\n";
}

// Load product information
void PremadeLunch::load(istream& in) {
    Food::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    perishable = stoi(token);

    getline(ss, token, ',');
    ingredients = token;

    getline(ss, token, ',');
    allergens = token;
}