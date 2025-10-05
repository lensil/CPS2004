#include "transport.h"

// Default constructor
Transport::Transport() {
    this->transportSpeed = 0;
    this->costPerKm = 0;
}

// Parameterised constructor
Transport::Transport(int transportSpeed, int costPerKm, int id) {
    this->transportSpeed = transportSpeed;
    this->costPerKm = costPerKm;
    this->transportID = id;
}

// Calculate delivery time
double Transport::deliveryTime(double distance) {
    return distance / this->getTransportSpeed();
}

// Calculate delivery cost
double Transport::deliveryCost(double distance) {
    return distance * this->getCostPerKm();
}

// Getters and setters
int Transport::getTransportSpeed() {
    return this->transportSpeed;
}

int Transport::getCostPerKm() {
    return this->costPerKm;
}

void Transport::setTransportID(int transportID) {
    this->transportID = transportID;
}

void Transport::setTransportSpeed(int transportSpeed) {
    this->transportSpeed = transportSpeed;
}

void Transport::setCostPerKm(int costPerKm) {
    this->costPerKm = costPerKm;
}

int Transport::getTransportID() {
    return this->transportID;
}

// Save transport information
void Transport::save(ostream& out) const {
    out << transportID << "," << transportSpeed << "," << costPerKm << "\n";
}

// Load transport information
void Transport::load(istream& in) {
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    transportID = stoi(token);

    getline(ss, token, ',');
    transportSpeed = stoi(token);
    
    getline(ss, token, ',');
    costPerKm = stoi(token);
}