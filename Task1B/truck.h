#ifndef TRUCK_H
#define TRUCK_H

#include "transport.h"

class Truck: public Transport {
    private:
        vector<string> motorways;

    public:
        Truck();
        Truck(int transportSpeed, int costPerKm, vector<string> motorways, int id);
        vector<string> getMotorways();
        void setRoute(vector<string> motorways);
        string deliveryPlan();
        void save(ostream& out) const;
        void load(istream& in);
        ~Truck();
};

#endif