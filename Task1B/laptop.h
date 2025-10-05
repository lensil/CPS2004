#ifndef LAPTOP_H
#define LAPTOP_H

#include "electronics.h"

class Laptop: public Electronics {
    private:
        double screenSize;
        string operatingSystem;
        int ram;
    public:
        Laptop();
        Laptop(string name, int price, Supplier* supplier, int volume, int productID, string manufacturer, int warranty, double screenSize, string operatingSystem, int ram);
        double getScreenSize();
        string getOperatingSystem();
        int getRam();
        void setScreenSize(double screenSize);
        void setOperatingSystem(string operatingSystem);
        void setRam(int ram);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif