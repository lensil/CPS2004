#include "customer.h"

// Default constructor
Customer::Customer() {
    this->name = "";
    this->address = "";
    this->distanceFromWarehouse = 0;
    this->ID = 0;
    this->shipments = {};
}

// Parameterised constructor
Customer::Customer(string name, string address, double distanceFromWarehouse, int ID) {
    this->name = name;
    this->address = address;
    this->distanceFromWarehouse = distanceFromWarehouse;
    this->ID = ID;
    this->shipments = {};
}

// Getters and setters
string Customer::getName() {
    return this->name;
}

string Customer::getAddress() {
    return this->address;
}

double Customer::getDistanceFromWarehouse() {
    return this->distanceFromWarehouse;
}

vector<Shipment*> Customer::getShipments() {
    return this->shipments;
}

void Customer::setName(string name) {
    this->name = name;
}

void Customer::setAddress(string address) {
    this->address = address;
}

void Customer::setDistanceFromWarehouse(double distance) {
    this->distanceFromWarehouse = distance;
}

void Customer::setShipments(vector<Shipment*> shipments) {
    this->shipments = shipments;
}

// Remove a shipment
void Customer::removeShipment(int ID) {
    for (int i = 0; i < this->shipments.size(); i++) {
        if (this->shipments[i]->getShipmentID() == ID) {
            this->shipments.erase(this->shipments.begin() + i);
        }
    }
}

int Customer::getID() {
    return this->ID;
}

void Customer::setID(int ID) {
    this->ID = ID;
}

// View customer shipments
void Customer::viewCustomerShipments() {
    int i = 1;
    cout << "Customer shipments: " << endl;
    for (Shipment* shipment : this->shipments) {
        cout << "Shipment " << i << ": " << endl;
        shipment->generateDeliveryPlan();
        cout << endl;
        i++;
    }
}


// Save customer information to file
void Customer::save(ostream& out) const {
    out << this->name << "," << this->address << "," << this->distanceFromWarehouse << "," << this->ID << "\n";
    out << this->shipments.size() << "\n";
    for (Shipment* shipment : this->shipments) {
        shipment->save(out);
    }
}

// Load customer information from file
void Customer::load(istream& in) {
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    this->name = token;

    getline(ss, token, ',');
    this->address = token;

    getline(ss, token, ',');
    this->distanceFromWarehouse = stod(token);

    getline(ss, token, ',');
    this->ID = stoi(token);

    string size;
    getline(in, size);

    for (int i = 0; i < stoi(size); i++) {
        Shipment* shipment = new Shipment();
        shipment->load(in);
        this->shipments.push_back(shipment);
    }
}

// Destructor
Customer::~Customer() {
    for (Shipment* shipment : this->shipments) {
        delete shipment;
    }
}