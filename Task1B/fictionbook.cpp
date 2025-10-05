#include "fictionbook.h"

// Default constructor
FictionBook::FictionBook() : Book() {
    this->genre = "";
    this->publicationDate = "";
}

// Parameterised constructor
FictionBook::FictionBook(string name, int price, Supplier* supplier, int volume, int productID, string author, string genre, int pages, string publicationDate) : Book(name, price, supplier, volume, productID, author, genre, pages) {
    this->genre = genre;
    this->publicationDate = publicationDate;
}

// Getters and setters
string FictionBook::getGenre() {
    return this->genre;
}

string FictionBook::getPublicationDate() {
    return this->publicationDate;
}

void FictionBook::setGenre(string genre) {
    this->genre = genre;
}

void FictionBook::setPublicationDate(string publicationDate) {
    this->publicationDate = publicationDate;
}

// Display product information
void FictionBook::display_product_info() {
    Book::display_product_info();
    cout << "Genre: " << this->genre << endl;
    cout << "Publication Date: " << this->publicationDate << endl;
}

// Calculate discount
double FictionBook::calculate_discount(string month, int quantity) {
    if (month == "January" || month == "February" || month == "March" || quantity >= 15) {
        return this->getPrice() * 0.1;
    }
    else {
        return this->getPrice() * 0.05;
    }
}

// Save product information
void FictionBook::save(ostream& out) const {
    out << "fictionbook" << "\n";
    Book::save(out);
    out << genre << "," << publicationDate << "\n";
}

// Load product information
void FictionBook::load(istream& in) {
    Book::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    genre = token;

    getline(ss, token, ',');
    publicationDate = token;
}