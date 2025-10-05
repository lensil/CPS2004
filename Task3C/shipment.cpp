#include "shipment.h"

// Default constructor
Shipment::Shipment() {
    this->distance = 0;
    this->transport = NULL;
    this->dispatched = false;
    this->packagedItems = {};

}

// Parameterised constructor
Shipment::Shipment(Transport* transport, double distance, string dispatchDate, int shipmentID) {
    this->distance = distance;
    this->transport = transport;
    this->packagedItems = {};
    this->dispatchDate = dispatchDate;
    this->shipmentID = shipmentID;
}

// Calculate shipment cost
double Shipment::shipmentCost() {
    double totalCost = 0;
    for (ShipmentItem* item : this->packagedItems) {
        totalCost += (item->getProduct()->calculate_discount(this->dispatchDate, item->getQuantity()) * item->getQuantity()) * item->getPackage()->getCost();
    }
    return totalCost + this->transport->deliveryCost(this->distance);
}

// Generate delivery plan
void Shipment::generateDeliveryPlan() {
    cout << "Dispatch date: " << this->dispatchDate << endl
         << "Route Stages: " << this->transport->deliveryPlan() << endl
         << "Delivery time: " << this->transport->deliveryTime(this->distance) << endl
         << "Shipment cost: " << this->shipmentCost() << endl;
        if (this->dispatched) {
            cout << "Dispatched: Yes" << endl;
        } else {
            cout << "Dispatched: No" << endl;
        }
        for (ShipmentItem* item : this->packagedItems) {
            item->display_shipment_item();
        }
}

// Getters and setters
Transport* Shipment::getTransport() {
    return this->transport;
}

vector<ShipmentItem*> Shipment::getPackagedItems() {
    return this->packagedItems;
}

bool Shipment::isDispatched() {
    return this->dispatched;
}

double Shipment::getDistance() {
    return this->distance;
}

string Shipment::getDispatchDate() {
    return this->dispatchDate;
}

int Shipment::getShipmentID() {
    return this->shipmentID;
}

void Shipment::setTransport(Transport* transport) {
    if(!this->dispatched) {
        this->transport = transport;
    } else {
        cout << "Shipment already dispatched and cannot be modified" << endl;
    }
}

void Shipment::addPackagedItems(ShipmentItem* item) {
    if(!this->dispatched) {
        this->packagedItems.push_back(item);
    } else {
        cout << "Shipment already dispatched and cannot be modified" << endl;
    }
}

void Shipment::setDispatched(bool dispatched) {
    this->dispatched = dispatched;
}

void Shipment::setDistance(double distance) {
    if(!this->dispatched) {
        this->distance = distance;
    } else {
        cout << "Shipment already dispatched and cannot be modified" << endl;
    }
}

void Shipment::setShipmentID(int shipmentID) {
    this->shipmentID = shipmentID;
}

void Shipment::setDispatchDate(string dispatchDate) {
    if(!this->dispatched) {
        this->dispatchDate = dispatchDate;
    } else {
        cout << "Shipment already dispatched and cannot be modified" << endl;
    }
}

// Save shipment information to file
void Shipment::save(ostream& out) const {
    out << this->dispatched << "," << this->distance << "," << this->dispatchDate << "," << this->shipmentID << "\n";
    this->transport->save(out);
    out << this->packagedItems.size() << "\n";
    for (ShipmentItem* item : this->packagedItems) {
        item->save(out);
    }
}

// Load shipment information from file
void Shipment::load(istream& in) {
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    dispatched = stoi(token);

    getline(ss, token, ',');
    distance = stoi(token);

    getline(ss, token, ',');
    dispatchDate = token;

    getline(ss, token, ',');
    shipmentID = stoi(token);

    string type;
    getline(in, type, '\n');
    if (type == "truck") {
        transport = new Truck();
    } else if (type == "ship") {
        transport = new Ship();
    } else if (type == "plane") {
        transport = new Plane();
    }

    transport->load(in);

    string size;
    getline(in, size);

    for (int i = 0; i < stoi(size); i++) {
        string product_type;
        getline(in, product_type);
        //getline(ss, product_type, '\n');
        ShipmentItem* item = new ShipmentItem();
        if (product_type == "pants") {
            item->setProduct(new Pants());
        } else if (product_type == "tshirt") {
            item->setProduct(new TShirt());
        } else if (product_type == "fruit") {
            item->setProduct(new Fruit());
        } else if (product_type == "premadelunch") {
            item->setProduct(new PremadeLunch());
        } else if (product_type == "textbook") {
            item->setProduct(new Textbook());
        } else if (product_type == "fictionbook") {
            item->setProduct(new FictionBook());
        } else if (product_type == "table") {
            item->setProduct(new Table());
        } else if (product_type == "chair") {
            item->setProduct(new Chair());
        } else if (product_type == "action") {
            item->setProduct(new Action());
        } else if (product_type == "rpg") {
            item->setProduct(new RPG());
        } else if (product_type == "camera") {
            item->setProduct(new Camera());
        } else if (product_type == "laptop") {
            item->setProduct(new Laptop());
        }
        item->setPackage(new Package());
        item->load(in);
        this->packagedItems.push_back(item);
    }
}

// Destructor
Shipment::~Shipment() {
    delete this->transport;
    for (ShipmentItem* item : this->packagedItems) {
        delete item;
    }
}