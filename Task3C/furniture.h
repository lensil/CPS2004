#ifndef FURNITURE_H
#define FURNITURE_H

#include "product.h"

class Furniture: public Product {
    private:
        string material;
        string dimensions;
    public:
        Furniture();
        Furniture(string name, int price, Supplier* supplier, int volume, int productID, string material, string dimensions);
        string getMaterial();
        string getDimensions();
        void setMaterial(string material);
        void setDimensions(string dimensions);
        virtual void display_product_info();
        virtual double calculate_discount(string month, int quantity) = 0;
        virtual void save(ostream& out) const;
        virtual void load(istream& in);
};

#endif