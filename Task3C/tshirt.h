#ifndef TSHIRT_H
#define TSHIRT_H

#include "clothes.h"

class TShirt: public Clothes {
    private:
        string collar;
        bool graphics;
    public:
        TShirt();
        TShirt(string name, int price, Supplier* supplier, int volume, int productID, string size, string brand, string material, string collar, bool graphics);
        string getCollar();
        bool getGraphics();
        void setCollar(string collar);
        void setGraphics(bool graphics);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif