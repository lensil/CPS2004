#include "camera.h"

Camera::Camera() {
    this->megaPixels = 0;
    this->zoom = 0;
    this->wirelessConnectivity = false;
}

Camera::Camera(string name, int price, Supplier* supplier, int volume, int productID, string manufacturer, int warranty, double megaPixels, int zoom, bool wirelessConnectivity) : Electronics(name, price, supplier, volume, productID, manufacturer, warranty) {
    this->megaPixels = megaPixels;
    this->zoom = zoom;
    this->wirelessConnectivity = wirelessConnectivity;
}

double Camera::getMegaPixels() {
    return this->megaPixels;
}

int Camera::getZoom() {
    return this->zoom;
}

bool Camera::getWirelessConnectivity() {
    return this->wirelessConnectivity;
}

void Camera::setMegaPixels(double megaPixels) {
    this->megaPixels = megaPixels;
}

void Camera::setZoom(int zoom) {
    this->zoom = zoom;
}

void Camera::setWirelessConnectivity(bool wirelessConnectivity) {
    this->wirelessConnectivity = wirelessConnectivity;
}

void Camera::display_product_info() {
    Electronics::display_product_info();
    cout << "Mega Pixels: " << this->megaPixels << endl;
    cout << "Zoom: " << this->zoom << endl;
    cout << "Wireless Connectivity: " << this->wirelessConnectivity << endl;
}

double Camera::calculate_discount(string month, int quantity) {
    if (month  == "January" || month  == "February" || month  == "March" || quantity >= 10) {
        return getPrice() * 0.1;
    }
    else {
        return getPrice();
    }
}

void Camera::save(ostream& out) const {
    out << "camera" << "\n";
    Electronics::save(out);
    out << megaPixels << "," << zoom << "," << wirelessConnectivity << "\n";
}

void Camera::load(istream& in) {
    Electronics::load(in);

    string line;
    getline(in, line, '\n');
    stringstream ss(line);

    string token;
    getline(ss, token, ',');
    megaPixels = stod(token);

    getline(ss, token, ',');
    zoom = stoi(token);

    getline(ss, token, ',');
    wirelessConnectivity = stoi(token);
}