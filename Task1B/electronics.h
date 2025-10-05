#ifndef ELECTRONICS_H
#define ELECTRONICS_H

#include "product.h"

class Electronics: public Product {
    private:
        string manufacturer;
        int warranty;
    public:
        Electronics();
        Electronics(string name, int price, Supplier* supplier, int volume, int productID, string manufacturer, int warranty);
        string getManufacturer();
        int getWarranty();
        void setManufacturer(string manufacturer);
        void setWarranty(int warranty);
        virtual void display_product_info();
        virtual double calculate_discount(string month, int quantity) = 0;
        virtual void save(ostream& out) const;
        virtual void load(istream& in);
};

#endif