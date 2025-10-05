#ifndef SHIP_H
#define SHIP_H

#include "transport.h"

class Ship: public Transport {
    private:
        vector<string> harbours;
    public:
        Ship();
        Ship(int transportSpeed, int costPerKm, int id, vector<string> harbours);
        vector<string> getHarbours();
        void setRoute(vector<string> harbours);
        string deliveryPlan();
        void save(ostream& out) const;
        void load(istream& in);
        ~Ship();
};

#endif