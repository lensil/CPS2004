#ifndef FRUIT_H
#define FRUIT_H

#include "food.h"

class Fruit : public Food {
    private:
        string countryOfOrigin;
        string type;
        bool organic;
    public:
        Fruit();
        Fruit(string name, int price, Supplier* supplier, int volume, int productID, double weight, string expirationDate, string countryOfOrigin, string type, bool organic);
        string getCountryOfOrigin();
        string getType();
        bool getOrganic();
        void setCountryOfOrigin(string countryOfOrigin);
        void setType(string type);
        void setOrganic(bool organic);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif