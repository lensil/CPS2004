#ifndef SHIPMENT_H
#define SHIPMENT_H

#include <string>
#include <vector>
#include "shipmentitem.h"
#include "transport.h"
#include "truck.h"
#include "ship.h"
#include "plane.h"

using namespace std;

class Shipment {
    private:
        Transport* transport;
        vector<ShipmentItem*> packagedItems;
        bool dispatched;
        double distance;
        string dispatchDate;
        int shipmentID;
    public:
        Shipment();
        Shipment(Transport* transport, double distance, string dispatchDate, int shipmentID);
        double shipmentCost();
        void generateDeliveryPlan();
        Transport* getTransport();
        vector<ShipmentItem*> getPackagedItems(); 
        double getDistance();
        string getDispatchDate();
        int getShipmentID();
        bool isDispatched();
        void setTransport(Transport* transport);
        void addPackagedItems(ShipmentItem* item); 
        void setDispatched(bool dispatched);
        void setDistance(double distance);
        void setDispatchDate(string dispatchDate);
        void setShipmentID(int shipmentID);
        void save(ostream& out) const;
        void load(istream& in);
        ~Shipment();
};

#endif