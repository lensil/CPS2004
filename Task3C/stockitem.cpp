#include "stockitem.h"

// Default constructor
StockItem::StockItem() {
    this->product = NULL;
    this->quantity = 0;
}

// Parameterised constructor
StockItem::StockItem(Product* product, int quantity) {
    this->product = product;
    this->quantity = quantity;
}

// Getters and setters
Product* StockItem::getProduct() {
    return this->product;
}

int StockItem::getQuantity() {
    return this->quantity;
}

void StockItem::setProduct(Product* product) {
    this->product = product;
}

void StockItem::setQuantity(int quantity) {
    this->quantity = quantity;
}

// Save stock item information
void StockItem::save(ostream& out) const {
    this->product->save(out);
    out << quantity << "\n";
}

// Load stock item information
void StockItem::load(istream& in) {
    product->load(in);
    
    string line;
    getline(in, line);
    stringstream ss(line);

    string token;
    getline(ss, token);
    quantity = stoi(token);
    
}

// Destructor
StockItem::~StockItem() {
    delete this->product;
}