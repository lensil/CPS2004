#include "truck.h"

// Default constructor
Truck::Truck() {
    this->motorways = {};
}


// Parameterised constructor
Truck::Truck(int transportSpeed, int costPerKm, vector<string> motorways, int id): Transport(transportSpeed, costPerKm, id) {
    this->motorways = motorways;
}

// Getters and setters
vector<string> Truck::getMotorways() {
    return this->motorways;
}

void Truck::setRoute(vector<string> motorways) {
    this->motorways = motorways;
}

// Display delivery plan
string Truck::deliveryPlan() {
    string result = "Truck will drive through: ";
    for (string motorway : this->getMotorways()) {
        result += motorway + ", ";
    }
    result = result.substr(0, result.length() - 2);
    return result;
}

// Save truck information
void Truck::save(ostream& out) const {
    out << "truck" << "\n";
    Transport::save(out);
    for (string motorway : this->motorways) {
        out << motorway << ",";
    }
    out << "\n";
}

// Load truck information
void Truck::load(istream& in) {
    Transport::load(in);
    string motorwaysStr;
    getline(in, motorwaysStr, '\n');
    stringstream ss(motorwaysStr);
    string motorway;
    motorways.clear();
    while (getline(ss, motorway, ',')) {
        motorways.push_back(motorway);
    }
}

// Destructor
Truck::~Truck() {
    this->motorways.clear();
}