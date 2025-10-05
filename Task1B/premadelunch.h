#ifndef PREMADELUNCH_H
#define PREMADELUNCH_H

#include "food.h"

class PremadeLunch : public Food {
    private:
        bool perishable;
        string ingredients;
        string allergens;
    public:
        PremadeLunch();
        PremadeLunch(string name, int price, Supplier* supplier, int volume, int productID, double weight, string expirationDate, bool perishable, string ingredients, string allergens);
        bool getPerishable();
        string getIngredients();
        string getAllergens();
        void setPerishable(bool perishable);
        void setIngredients(string ingredients);
        void setAllergens(string allergens);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif