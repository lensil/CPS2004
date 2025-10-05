#include "CLI.h"
#include <iostream>

int main() {
    CLI cli = CLI();

    cli.restore();

    Product* laptop = new Laptop("Laptop", 1000, new Supplier("Supplier 1", 1), 10, 1, "Manufacturer", 1, 15.6, "Windows", 8);
    Supplier* supplier1 = new Supplier("Supplier 1", 1);
    Product* action = new Action("Action", 1000, new Supplier("Supplier 2", 2), 20, 5, "Platform", "Developer", 1, "Rating");
    Supplier* supplier2 = new Supplier("Supplier 2", 2);
    //dummy stock
    cli.addItemToStock(laptop, 10, supplier1);
    cli.addItemToStock(action, 18, supplier2);

    std::cout << "Current Stock Snapshot:" << std::endl;
    cli.viewStock();

    return 0;
}