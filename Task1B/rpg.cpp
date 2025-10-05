#include "rpg.h"

// Default constructor
RPG::RPG() {
    this->story = "";
    this->multiplayer = false;
}

// Parameterised constructor
RPG::RPG(string name, int price, Supplier* supplier, int volume, int productID, string platform, string developer, string story, bool multiplayer) : VideoGame(name, price, supplier, volume, productID, platform, developer) {
    this->story = story;
    this->multiplayer = multiplayer;
}

// Getters and setters
string RPG::getStory() {
    return this->story;
}

bool RPG::getMultiplayer() {
    return this->multiplayer;
}

void RPG::setStory(string story) {
    this->story = story;
}

void RPG::setMultiplayer(bool multiplayer) {
    this->multiplayer = multiplayer;
}

// Display product information
void RPG::display_product_info() {
    VideoGame::display_product_info();
    cout << "Story: " << this->story << endl;
    cout << "Multiplayer: " << this->multiplayer << endl;
}

// Calculate discount
double RPG::calculate_discount(string month, int quantity) {
    if ((month == "January" || month == "February" || month == "March") && quantity >= 20) {
        return getPrice() * 0.2;
    } else {
        return getPrice() * 0.1;
    }
}

// Save product information
void RPG::save(ostream& out) const {
    out << "rpg" << "\n";
    VideoGame::save(out);
    out << story << "," << multiplayer << "\n";
}

// Load product information
void RPG::load(istream& in) {
    VideoGame::load(in);
    
    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    story = token;

    getline(ss, token, ',');
    multiplayer = stoi(token);
}