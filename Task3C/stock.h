#ifndef STOCK_H
#define STOCK_H

#include <string>
#include <vector>
#include "stockitem.h"
using namespace std;

class Stock {
    private:
       vector<StockItem*> currentstock;
    public:
        Stock();
        vector<StockItem*> getStock();
        void setStock(vector<StockItem*> stock);
        void removeStock(int productID);
        void viewStock();
        void save(ostream& out) const;
        void load(istream& in);
        ~Stock();
};

#endif