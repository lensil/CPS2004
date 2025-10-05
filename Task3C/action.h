#ifndef ACTION_H
#define ACTION_H

#include "videogame.h"

class Action: public VideoGame {
    private:
        int noOfPlayers;
        string rating;
    public:
        Action();
        Action(string name, int price, Supplier* supplier, int volume, int productID,string platform, string developer, int noOfPlayers, string rating);
        int getNoOfPlayers();
        string getRating();
        void setNoOfPlayers(int noOfPlayers);
        void setRating(string rating);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif