#ifndef PLANE_H
#define PLANE_H

#include "transport.h"

class Plane : public Transport {
    private:
        vector<string> airSpaces;
    public:
        Plane();
        Plane(int transportSpeed, int costPerKm, vector<string> airSpaces, int id);
        vector<string> getAirSpaces();
        void setRoute(vector<string> airSpaces);
        string deliveryPlan();
        void save(ostream& out) const;
        void load(istream& in);;
        ~Plane();
};

#endif