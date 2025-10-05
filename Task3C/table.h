#ifndef TABLE_H
#define TABLE_H

#include "furniture.h"

class Table: public Furniture {
    private:
        bool extendable;
        string shape;
        int noOfLegs;
    public:
        Table();
        Table(string name, int price, Supplier* supplier, int volume, int productID, string material, string dimensions, bool extendable, string shape, int noOfLegs);
        bool getExtendable();
        string getShape();
        int getNoOfLegs();
        void setExtendable(bool extendable);
        void setShape(string shape);
        void setNoOfLegs(int noOfLegs);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif