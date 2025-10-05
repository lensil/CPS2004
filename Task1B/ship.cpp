#include "ship.h"

// Default constructor
Ship::Ship() {
    this->harbours = {};
}

// Parameterised constructor
Ship::Ship(int transportSpeed, int costPerKm, int id, vector<string> harbours) : Transport(transportSpeed, costPerKm, id) {
    this->harbours = harbours;
}


vector<string> Ship::getHarbours() {
    return this->harbours;
}

void Ship::setRoute(vector<string> harbours) {
    this->harbours = harbours;
}

// Display delivery plan
string Ship::deliveryPlan() {
    string result = "Ship will sail through: ";
    for (string harbour : this->getHarbours()) {
        result += harbour + ", ";
    }
    result = result.substr(0, result.length() - 2);
    return result;
}

// Save ship information
void Ship::save(ostream& out) const {
    out << "ship" << "\n";
    Transport::save(out);
    for (string motorway : this->harbours) {
        out << motorway << ",";
    }
    out << "\n";
}

// Load ship information
void Ship::load(istream& in) {
    Transport::load(in);
    string harboursStr;
    getline(in, harboursStr, '\n');
    stringstream ss(harboursStr);
    string harbour;
    harbours.clear();
    while (getline(ss, harbour, ',')) {
        harbours.push_back(harbour);
    }
}

// Destructor
Ship::~Ship() {
    this->harbours.clear();
}