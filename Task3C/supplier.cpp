#include "supplier.h"
#include "stock.h"
#include <sstream>

// Default constructor
Supplier::Supplier() {
    this-> name = "";
    this->ID = 0;
}

// Parameterised constructor
Supplier::Supplier(string name, int ID) {
    this->name = name;
    this->ID = ID;
}

// Getters and setters
string Supplier::getName() {
    return this->name;
}


void Supplier::setName(string name) {
    this->name = name;
}


int Supplier::getID() {
    return this->ID;
}

void Supplier::setID(int ID) {
    this->ID = ID;
}

// View supplier information
void Supplier::viewSupplierInfo() {
    cout << "Name: " << this->name << endl;
    cout << "ID: " << this->ID << endl;
}

// Save supplier information to file
void Supplier::save(ostream& out) const {
    out << name << "," << ID << "\n";
}

// Load supplier information from file
void Supplier::load(istream& in) {
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    name = token;

    getline(ss, token, ',');
    ID = stoi(token);
}