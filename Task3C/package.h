#ifndef PACKAGE_H
#define PACKAGE_H

#include <string>
using namespace std;

class Package {
    private:
        int packagingUnits;
        double cost;
        string type;
        int packageID;
    
    public:
        Package();
        Package(int packagingUnits, double cost, string type, int packageID);
        int getPackagingUnits();
        double getCost();
        string getType();
        int getPackageID();
        void setPackagingUnits(int packagingUnits);
        void setCost(double cost);
        void setType(string type);
        void setPackageID(int packageID);
        void viewPackage();
        bool operator==(const Package& other) const;
        void save(ostream& out) const;
        void load(istream& in);
        void update();
        void addPackage();
};

#endif