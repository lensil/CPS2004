#include "package.h"
#include "stock.h"
#include "pants.h"
#include "tshirt.h"
#include "fruit.h"
#include "premadelunch.h"
#include "textbook.h"
#include "fictionbook.h"
#include "table.h"
#include "chair.h"
#include "action.h"
#include "rpg.h"
#include "camera.h"
#include "laptop.h"

class ShipmentItem {
    private:
        int id;
        int quantity;
        Product* product;
        Package* package;
    public:
        ShipmentItem();
        ShipmentItem(int id, int quantity, Product* product, Package* package);
        int getId();
        int getQuantity();
        Product* getProduct();
        Package* getPackage();
        void setId(int id);
        void setQuantity(int quantity);
        void setProduct(Product* product);
        void setPackage(Package* package);
        void display_shipment_item();
        void save(ostream& out) const;
        void load(istream& in);
        ~ShipmentItem();
};