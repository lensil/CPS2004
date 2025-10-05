#include "book.h"

// Default constructor
Book::Book() { 
    this->author = "";
    this->publisher = "";
    this->pages = 0;
}

// Parameterised constructor
Book::Book(string name, int price, Supplier* supplier, int volume, int productID, string author, string publisher, int pages) : Product(name, price, supplier, volume, productID) {
    this->author = author;
    this->publisher = publisher;
    this->pages = pages;
}

// Getters and setters
string Book::getAuthor() {
    return this->author;
}

string Book::getPublisher() {
    return this->publisher;
}

int Book::getPages() {
    return this->pages;
}

void Book::setAuthor(string author) {
    this->author = author;
}

void Book::setPublisher(string publisher) {
    this->publisher = publisher;
}

void Book::setPages(int pages) {
    this->pages = pages;
}

// Display product information
void Book::display_product_info() {
    Product::display_product_info();
    cout << "Author: " << this->author << endl;
    cout << "Publisher: " << this->publisher << endl;
    cout << "Pages: " << this->pages << endl;
}

// Save product information to file
void Book::save(ostream& out) const {
    Product::save(out);
    out << publisher << "," << pages << "," << author << "\n";
}

// Load product information from file
void Book::load(istream& in) {
    Product::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    publisher = token;

    getline(ss, token, ',');
    pages = stoi(token);

    getline(ss, token, ',');
    author = token;
}