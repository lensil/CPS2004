#ifndef SUPPLIER_H
#define SUPPLIER_H

#include <vector>
#include <string>
class Stock;
class Product;
using namespace std;

class Supplier {
    private:
        string name;
        int ID;
    public:
        Supplier();
        Supplier(string name, int ID);
        string getName();
        int getID();
        void setName(string name);
        void setID(int ID);
        void viewSupplierInfo();
        void save(ostream& out) const;
        void load(istream& in);
};

#endif 