#ifndef FOOD_H
#define FOOD_H

#include "product.h"

class Food: public Product {
    private:
        double weight;
        string expirationDate;
    public:
        Food();
        Food(string name, int price, Supplier* supplier, int volume, int productID, double weight, string expirationDate);
        double getWeight();
        string getExpirationDate();
        void setWeight(double weight);
        void setExpirationDate(string expirationDate);
        virtual void display_product_info();
        virtual double calculate_discount(string month, int quantity) = 0;
        virtual void save(ostream& out) const;
        virtual void load(istream& in);
};

#endif