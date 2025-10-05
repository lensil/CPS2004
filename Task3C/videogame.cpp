#include "videogame.h"

// Default constructor
VideoGame::VideoGame() {
    this->platform = "";
    this->developer = "";
}

// Parameterised constructor
VideoGame::VideoGame(string name, int price, Supplier* supplier, int volume, int productID, string platform, string developer) : Product(name, price, supplier, volume, productID) {
    this->platform = platform;
    this->developer = developer;
}

// Getters and setters
string VideoGame::getPlatform() {
    return this->platform;
}

string VideoGame::getDeveloper() {
    return this->developer;
}

void VideoGame::setPlatform(string platform) {
    this->platform = platform;
}

void VideoGame::setDeveloper(string developer) {
    this->developer = developer;
}

// Display product information
void VideoGame::display_product_info() {
    Product::display_product_info();
    cout << "Platform: " << this->platform << endl;
    cout << "Developer: " << this->developer << endl;
}

// Save product information to file
void VideoGame::save(ostream& out) const {
    Product::save(out);
    out << platform << "," << developer << "\n";
}

// Load product information from file
void VideoGame::load(istream& in) {
    Product::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    platform = token;
    getline(ss, token, ',');
    developer = token;
}