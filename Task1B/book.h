#ifndef BOOK_H
#define BOOK_H

#include "product.h"
using namespace std;

class Book : public Product {
    private:
        string publisher;
        int pages;
        string author;
    public:
        Book();
        Book(string name, int price, Supplier* supplier, int volume, int productID, string publisher, string author, int pages);
        string getPublisher();
        int getPages();
        string getAuthor();
        void setPublisher(string publisher);
        void setPages(int pages);
        void setAuthor(string author);
        virtual void display_product_info();
        virtual double calculate_discount(string month, int quantity) = 0;
        virtual void save(ostream& out) const;
        virtual void load(istream& in);
};

#endif