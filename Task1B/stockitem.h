#ifndef STOCKITEM_H
#define STOCKITEM_H

#include "product.h"

class StockItem {
    private:
        Product* product;
        int quantity;
    public:
        StockItem();
        StockItem(Product* product, int quantity);
        Product* getProduct();
        int getQuantity();
        void setProduct(Product* product);
        void setQuantity(int quantity);
        void save(ostream& out) const;
        void load(istream& in);
        ~StockItem();
};

#endif