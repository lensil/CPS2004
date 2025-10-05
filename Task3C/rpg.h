#ifndef RPG_H
#define RPG_H

#include "videogame.h"

class RPG: public VideoGame {
    private:
        string story;
        bool multiplayer;
    public:
        RPG();
        RPG(string name, int price, Supplier* supplier, int volume, int productID, string platform, string developer, string story, bool multiplayer);
        string getStory();
        bool getMultiplayer();
        void setStory(string story);
        void setMultiplayer(bool multiplayer);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif