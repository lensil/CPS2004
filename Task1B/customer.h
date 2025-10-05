#include <string>
#include <vector>
#include "shipment.h"

using namespace std;

class Customer {
    private:
        string name;
        string address;
        int ID;
        double distanceFromWarehouse;
        vector<Shipment*> shipments;

    public:
        Customer();
        Customer(string name, string address, double distanceFromWarehouse, int ID);
        string getName();
        string getAddress();
        double getDistanceFromWarehouse();
        vector<Shipment*> getShipments();
        int getID();
        void setName(string name);
        void setAddress(string address);
        void setDistanceFromWarehouse(double distanceFromWarehouse);
        void setID(int ID);
        void setShipments(vector<Shipment*> shipments);
        void removeShipment(int ID);
        void viewCustomerShipments();
        void save(ostream& out) const;
        void load(istream& in);
        ~Customer();
        
};