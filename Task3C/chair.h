#ifndef CHAIR_H
#define CHAIR_H

#include "furniture.h"

class Chair: public Furniture {
    private:
        double seatLength;
        bool armRests;
    public:
        Chair();
        Chair(string name, int price, Supplier* supplier, int volume, int productID, string material, string dimensions, double seatLength, bool armRests);
        double getSeatLength();
        bool getArmRests();
        void setSeatLength(double seatLength);
        void setArmRests(bool armRests);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif