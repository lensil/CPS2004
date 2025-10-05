#include "textbook.h"

// Default constructor
Textbook::Textbook() {
    this->subject = "";
    this->edition = 0;
}

// Parameterised constructor
Textbook::Textbook(string name, int price, Supplier* supplier, int volume, int productID, string author, string publisher, int pages, string subject, int edition) : Book(name, price, supplier, volume, productID, author, publisher, pages) {
    this->subject = subject;
    this->edition = edition;
}

// Getters and setters
string Textbook::getSubject() {
    return this->subject;
}

int Textbook::getEdition() {
    return this->edition;
}

void Textbook::setSubject(string subject) {
    this->subject = subject;
}

void Textbook::setEdition(int edition) {
    this->edition = edition;
}

// Display product information
void Textbook::display_product_info() {
    Book::display_product_info();
    cout << "Subject: " << this->subject << endl;
    cout << "Edition: " << this->edition << endl;
}

// Calculate discount
double Textbook::calculate_discount(string month, int quantity) {
    double discount = 0;
    if (month == "January" || month == "February" || month == "March" || quantity >= 5) {
        discount = 0.2;
    }
    else if ((month == "April" || month == "May" || month == "June") && quantity >= 5) {
        discount = 0.1;
    }
    else if (month == "July" || month == "August" || month == "September" || quantity >= 10) {
        discount = 0.05;
    }
    else if ((month == "October" || month == "November" || month == "December") && quantity >= 10) {
        discount = 0.0;
    }
    return this->getPrice() * discount;
}

// Save product information
void Textbook::save(ostream& out) const {
    out << "textbook" << "\n";
    Book::save(out);;
    out << subject << "," << edition << "\n";
}

// Load product information
void Textbook::load(istream& in) {
    Book::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    subject = token;

    getline(ss, token, ',');
    edition = stoi(token);
}