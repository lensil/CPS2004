#ifndef PRODUCT_H
#define PRODUCT_H

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include "supplier.h"
using namespace std;

class Product
{
private:
    string name;
    int price;
    Supplier* supplier;
    int volume;
    int productID;
public:
    Product();
    Product(string name, int price, Supplier* supplier, int volume, int productID);
    virtual double calculate_discount(string month, int quantity) = 0;
    virtual void display_product_info();
    string getName();
    int getPrice();
    Supplier* getSupplier();
    int getVolume();
    int getProductID();
    void setName(string name);
    void setPrice(int price);
    void setSupplier(Supplier* supplier);
    void setVolume(int volume);
    void setProductID(int productID);
    virtual void save(ostream& out) const;
    virtual void load(istream& in);
    virtual ~Product();
};

#endif