#include "plane.h"

// Default constructor
Plane::Plane() {
    this->airSpaces = {};
}

// Parameterised constructor
Plane::Plane(int transportSpeed, int costPerKm, vector<string> airSpaces, int id) : Transport(transportSpeed, costPerKm, id) {
    this->airSpaces = airSpaces;
}

// Getters and setters
vector<string> Plane::getAirSpaces() {
    return this->airSpaces;
}

void Plane::setRoute(vector<string> airSpaces) {
    this->airSpaces = airSpaces;
}

// Delivery plan
string Plane::deliveryPlan() {
    string result = "Plane will fly through: ";
    for (string airSpace : this->getAirSpaces()) {
        result += airSpace + ", ";
    }
    result = result.substr(0, result.length() - 2);
    return result;
}

// Save plane information
void Plane::save(ostream& out) const {
    out << "plane" << "\n";
    Transport::save(out);
    for (string airSpace : this->airSpaces) {
        out << airSpace << ",";
    }
    out << "\n";
}

// Load plane information   
void Plane::load(istream& in) {
    Transport::load(in);
    string airSpacesStr;
    getline(in, airSpacesStr, '\n');
    stringstream ss(airSpacesStr);
    string airSpace;
    airSpaces.clear();
    while (getline(ss, airSpace, ',')) {
        airSpaces.push_back(airSpace);
    }
}

// Destructor
Plane::~Plane() {
    this->airSpaces.clear();
}