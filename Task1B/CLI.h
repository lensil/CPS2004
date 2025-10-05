#include "transport.h"
#include "customer.h"
#include "stock.h"
#include "supplier.h"
#include "package.h"

using namespace std;

class CLI {
    private:
        vector<Customer*> customers;
        vector<Transport*> transport;
        Stock* stock;
        vector<Supplier*> suppliers;
        vector<Package*> packages;
    public:
        CLI();
        vector<Customer*> getCustomers();
        vector<Transport*> getTransport();
        Stock* getStock();
        vector<Supplier*> getSuppliers();
        vector<Package*> getPackages();
        void addCustomer(Customer* customer);
        void addItemToStock(Product* product, int quantity);
        void addItemToStock(Product* product, int quantity, Supplier* supplier);
        void viewStock();
        void updateStockItem(Product* product, int id, int quantity);
        void updateStockItem(Product* product, int id, int quantity, Supplier* supplier);
        void removeFromStock(int id);
        void orderStock(int id);
        void addTransport(Transport* transport);
        void viewTransports();
        void updateTransport(int id, Transport* transport);
        void removeTransport(int id);
        void addPackage(Package* package);
        void viewPackages();
        void updatePackage(int id, Package* package);
        void removePackage(int id);
        void addShipment(Shipment* shipment, int customerID);
        void addShipment(Shipment* shipment, Customer* customer);
        void viewShipments(int customerID);
        void updateShipment(int customerID, int shipmentID, Shipment* shipment);
        void cancelShipment(int customerID, int shipmentID);
        void save();
        void restore();
        void save_suppliers(vector<Supplier*> suppliers);
        void save_packages(vector<Package*> packages);
        void save_stock(Stock* stock); 
        void save_transports(vector<Transport*> transport);
        void save_customers(vector<Customer*> customers);
        void load_packages(vector<Package*>& packages);
        void load_suppliers(vector<Supplier*>& suppliers);
        void load_stock(Stock* stock);
        void load_transports(vector<Transport*>& transport);
        void load_customers(vector<Customer*>& customers); 
        ~CLI();
};
