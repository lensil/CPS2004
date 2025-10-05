#ifndef VIDEOGAME_H
#define VIDEOGAME_H

#include "product.h"

class VideoGame: public Product {
    private:
        string platform;
        string developer;
    public:
        VideoGame();
        VideoGame(string name, int price, Supplier* supplier, int volume, int productID, string platform, string developer);
        string getPlatform();
        string getDeveloper();
        void setPlatform(string platform);
        void setDeveloper(string developer);
        virtual void display_product_info();
        virtual double calculate_discount(string month, int quantity) = 0;
        virtual void save(ostream& out) const;
        virtual void load(istream& in);
};

#endif