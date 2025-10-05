#ifndef FICTIONBOOK_H
#define FICTIONBOOK_H

#include "book.h"

class FictionBook : public Book {
    private:
        string genre;
        string publicationDate;
    public:
        FictionBook();
        FictionBook(string name, int price, Supplier* supplier, int volume, int productID, string author, string genre, int pages, string publicationDate);
        string getGenre();
        string getPublicationDate();
        void setGenre(string genre);
        void setPublicationDate(string publicationDate);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif