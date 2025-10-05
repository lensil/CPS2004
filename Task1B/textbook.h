#ifndef TEXTBOOK_H
#define TEXTBOOK_H

#include "book.h"

class Textbook: public Book {
    private:
        string subject;
        int edition;
    public:
        Textbook();
        Textbook(string name, int price, Supplier* supplier, int volume, int productID, string author, string genre, int pages, string subject, int edition);
        string getSubject();
        int getEdition();
        void setSubject(string subject);
        void setEdition(int edition);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif