#ifndef CLOTHES_H
#define CLOTHES_H

#include "product.h"

class Clothes: public Product {
    private:
        string size;
        string brand;
        string material;
    public:
        Clothes();
        Clothes(string name, int price, Supplier* supplier, int volume, int productID, string size, string brand, string material);
        string getSize();
        string getBrand();
        string getMaterial();
        void setSize(string size);
        void setBrand(string brand);
        void setMaterial(string material);
        virtual void display_product_info();
        virtual double calculate_discount(string month, int quantity) = 0;
        void virtual save(ostream& out) const;
        void virtual load(istream& in);
};

#endif