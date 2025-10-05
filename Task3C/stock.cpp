#include "stock.h"
#include "pants.h"
#include "tshirt.h"
#include "fruit.h"
#include "premadelunch.h"
#include "textbook.h"
#include "fictionbook.h"
#include "table.h"
#include "chair.h"
#include "action.h"
#include "rpg.h"
#include "camera.h"
#include "laptop.h"

// Default constructor
Stock::Stock() {
    this->currentstock = {};
}

// Get stock
vector<StockItem*> Stock::getStock() {
    return this->currentstock;
}

// Remove item from stock
void Stock::removeStock(int productID) {
    for (int i = 0; i < this->currentstock.size(); i++) {
        if (this->currentstock[i]->getProduct()->getProductID() == productID) {
            this->currentstock.erase(this->currentstock.begin() + i);
        }
    }
}

// Set stock
void Stock::setStock(vector<StockItem*> stock) {
    this->currentstock = stock;
}

// View stock
void Stock::viewStock() {
    for(int i = 0; i < this->currentstock.size(); i++) {
        cout<< "Stock Item " << i+1 << ": " << endl;
        this->currentstock[i]->getProduct()->display_product_info();
        cout << "Quantity: " << this->currentstock[i]->getQuantity() << endl;
    }
}

// Save stock
void Stock::save(ostream& out) const {
    out << this->currentstock.size() << "\n";
    for (int i = 0; i < this->currentstock.size(); i++) {
        this->currentstock[i]->save(out);
    }
}

// Load stock
void Stock::load(istream& in) {
    string line;

    while(getline(in, line)) {
        stringstream ss(line);
        string type;
        getline(ss, type, '\n');
        StockItem* stockItem = new StockItem();
        if (type == "pants") {
            stockItem->setProduct(new Pants());
        } else if (type == "tshirt") {
            stockItem->setProduct(new TShirt());
        } else if (type == "fruit") {
            stockItem->setProduct(new Fruit());
        } else if (type == "premadelunch") {
            stockItem->setProduct(new PremadeLunch());
        } else if (type == "textbook") {
            stockItem->setProduct(new Textbook());
        } else if (type == "fictionbook") {
            stockItem->setProduct(new FictionBook());
        } else if (type == "table") {
            stockItem->setProduct(new Table());
        } else if (type == "chair") {
            stockItem->setProduct(new Chair());
        } else if (type == "action") {
            stockItem->setProduct(new Action());
        } else if (type == "rpg") {
            stockItem->setProduct(new RPG());
        } else if (type == "camera") {
            stockItem->setProduct(new Camera());
        } else if (type == "laptop") {
            stockItem->setProduct(new Laptop());
        }
        stockItem->load(in);
        this->currentstock.push_back(stockItem);
    }
}

// Destructor
Stock::~Stock() {
    currentstock.clear();
}