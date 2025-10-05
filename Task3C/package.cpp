#include "package.h"
#include <iostream>
#include <fstream>
#include <sstream>

// Default constructor
Package::Package() {
    this->packagingUnits = 0;
    this->cost = 0;
    this->type = "";
    this->packageID = 0;
}

// Parameterised constructor
Package::Package(int packagingUnits, double cost, string type, int packageID) {
    this->packagingUnits = packagingUnits;
    this->cost = cost;
    this->type = type;
    this->packageID = packageID;
}

// Getters and setters
int Package::getPackagingUnits() {
    return this->packagingUnits;
}

double Package::getCost() {
    return this->cost;
}

string Package::getType() {
    return this->type;
}

int Package::getPackageID() {
    return this->packageID;
}

void Package::setPackagingUnits(int packagingUnits) {
    this->packagingUnits = packagingUnits;
}

void Package::setCost(double cost) {
    this->cost = cost;
}

void Package::setType(string type) {
    this->type = type;
}

void Package::setPackageID(int packageID) {
    this->packageID = packageID;
}

// View package information
void Package::viewPackage() {
    cout << "Package ID: " << this->packageID << endl
         << "Packaging units: " << this->packagingUnits << endl
         << "Cost: " << this->cost << endl
         << "Type: " << this->type << endl;
}

// Save package information to file
void Package::save(ostream& out) const {
    out << packagingUnits << "," << cost << "," << type << "," << packageID << "\n";
}

// Load package information from file
void Package::load(istream& in) {
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    packagingUnits = stoi(token);

    getline(ss, token, ',');
    cost = stod(token);

    getline(ss, token, ',');
    type = token;

    getline(ss, token, ',');
    packageID = stoi(token);
}

// Update package information
void Package::update() {
    char choice;
    cout << "Do you want to update the packaging units? (y/n): ";
    cin >> choice;
    if (choice == 'y') {
        cout << "Enter new packaging units: ";
        cin >> this->packagingUnits;
    }
    cout << "Do you want to update the cost? (y/n): ";
    cin >> choice;
    if (choice == 'y') {
        cout << "Enter new cost: ";
        cin >> this->cost;
    }
    cout << "Do you want to update the type? (y/n): ";
    cin >> choice;
    if (choice == 'y') {
        cout << "Enter new type: ";
        cin >> this->type;
    }
    cout << "Do you want to update the package ID? (y/n): ";
    cin >> choice;
    if (choice == 'y') {
        cout << "Enter new package ID: ";
        cin >> this->packageID;
    }
}

// Add package information
void Package::addPackage() {
    cout << "Enter packaging units: ";
    cin >> this->packagingUnits;
    cout << "Enter cost: ";
    cin >> this->cost;
    cout << "Enter type: ";
    cin >> this->type;
    cout << "Enter package ID: ";
    cin >> this->packageID;
}