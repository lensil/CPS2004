#ifndef CAMERA_H
#define CAMERA_H

#include "electronics.h"

class Camera: public Electronics {
    private:
        double megaPixels;
        int zoom;
        bool wirelessConnectivity;
    public:
        Camera();
        Camera(string name, int price, Supplier* supplier, int volume, int productID, string manufacturer, int warranty, double megaPixels, int zoom, bool wirelessConnectivity);
        double getMegaPixels();
        int getZoom();
        bool getWirelessConnectivity();
        void setMegaPixels(double megaPixels);
        void setZoom(int zoom);
        void setWirelessConnectivity(bool wirelessConnectivity);
        void display_product_info();
        double calculate_discount(string month, int quantity);
        void save(ostream& out) const;
        void load(istream& in);
};

#endif