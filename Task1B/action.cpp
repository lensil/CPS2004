#include "action.h"

// Default constructor
Action::Action() {
    this->noOfPlayers = 0;
    this->rating = "";
}

// Parameterised constructor
Action::Action(string name, int price, Supplier* supplier, int volume, int productID, string platform, string developer, int noOfPlayers, string rating) : VideoGame(name, price, supplier, volume, productID, platform, developer) {
    this->noOfPlayers = noOfPlayers;
    this->rating = rating;
}

// Getters and setters
int Action::getNoOfPlayers() {
    return this->noOfPlayers;
}

string Action::getRating() {
    return this->rating;
}

void Action::setNoOfPlayers(int noOfPlayers) {
    this->noOfPlayers = noOfPlayers;
}

void Action::setRating(string rating) {
    this->rating = rating;
}

// Display product information
void Action::display_product_info() {
    VideoGame::display_product_info();
    cout << "No of players: " << this->noOfPlayers << endl;
    cout << "Rating: " << this->rating << endl;
}

// Calculate discount
double Action::calculate_discount(string month, int quantity) {
    if (month == "January" || month == "February" || month == "March" || quantity >= 5) {
        return getPrice() * 0.2;
    } else {
        return getPrice() * 0.3;
    }
}

// Save product information
void Action::save(ostream& out) const {
    out << "action" << "\n";
    VideoGame::save(out);
    out << noOfPlayers << "," << rating << "\n";
}

// Load product information
void Action::load(istream& in) {
    VideoGame::load(in);
    
    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    noOfPlayers = stoi(token);

    getline(ss, token, ',');
    rating = token;
}