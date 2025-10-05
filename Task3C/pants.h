#ifndef PANTS_H
#define PANTS_H

#include "clothes.h"

class Pants: public Clothes {
    private:
        double inseam;
        double waist;
    public:
        Pants();
        Pants(string name, int price, Supplier* supplier, int volume, int productID, string size, string brand, string material, double inseam, double waist);
        double getInseam();
        double getWaist();
        void setInseam(double inseam);
        void setWaist(double waist);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif