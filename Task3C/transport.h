#ifndef TRANSPORT_H
#define TRANSPORT_H
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <iostream>
using namespace std;

class Transport {
    private:
        int transportSpeed;
        int costPerKm;
        int transportID;
    public:
        Transport();
        Transport(int transportSpeed, int costPerKm, int id);
        double deliveryTime(double distance);
        double deliveryCost(double distance);
        int getTransportSpeed();
        int getCostPerKm();
        int getTransportID();
        void setTransportSpeed(int transportSpeed);
        void setCostPerKm(int costPerKm);
        void setTransportID(int transportID);
        virtual string deliveryPlan() = 0;
        virtual void save(ostream& out) const;
        virtual void load(istream& in);
};

#endif