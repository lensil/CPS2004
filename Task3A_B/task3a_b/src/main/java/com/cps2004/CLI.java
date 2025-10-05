package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLI {
    private List<Customer> customers;
    private List<Transport> transport;
    private Stock stock;
    private List<Supplier> suppliers;
    private List<Package> packages;
    private Facade facade;

    // Default constructor
    public CLI() {
        this.customers = new ArrayList<>();
        this.transport = new ArrayList<>();
        this.stock = new Stock();
        this.suppliers = new ArrayList<>();
        this.packages = new ArrayList<>();
        this.facade = new Facade("state");
    }

    // Getters
    public List<Customer> getCustomers() {
        return this.customers;
    }

    public List<Transport> getTransport() {
        return this.transport;
    }

    public Stock getStock() {
        return this.stock;
    }

    public List<Supplier> getSuppliers() {
        return this.suppliers;
    }

    public List<Package> getPackages() {
        return this.packages;
    }

    // Stock CRUD operations
    public void addItemToStock(Product product, int quantity) {
        this.stock.getStock().add(new StockItem(product, quantity));
    }

    public void addItemToStock(Product product, int quantity, Supplier supplier) {
        this.stock.getStock().add(new StockItem(product, quantity));
        this.suppliers.add(supplier);
    }

    public void viewStock() {
        this.stock.viewStock();
    }

    public void updateStockItem(Product product, int id, int quantity) {
        for (int i = 0; i < this.stock.getStock().size(); i++) {
            if (this.stock.getStock().get(i).getProduct().getId() == id) {
                this.stock.getStock().get(i).setProduct(product);
                this.stock.getStock().get(i).setQuantity(quantity);
            }
        }
    }

    public void updateStockItem(Product product, int id, int quantity, Supplier supplier) {
        for (int i = 0; i < this.stock.getStock().size(); i++) {
            if (this.stock.getStock().get(i).getProduct().getId() == id) {
                this.stock.getStock().get(i).setProduct(product);
                this.stock.getStock().get(i).setQuantity(quantity);
                this.suppliers.add(supplier);
            }
        }
    }

    public void removeItemFromStock(int id) {
        for (int i = 0; i < this.stock.getStock().size(); i++) {
            if (this.stock.getStock().get(i).getProduct().getId() == id) {
                this.stock.getStock().remove(i);
                break;
            }
        }
    }

    public void orderStock(int id) {
        for (int i = 0; i < this.stock.getStock().size(); i++) {
            if (this.stock.getStock().get(i).getProduct().getId() == id) {
                this.stock.getStock().get(i).setQuantity(this.stock.getStock().get(i).getQuantity() + 50);
                break;
            }
        }
    }

    // Transport CRUD operations
    public void addTransport(Transport transport) {
        this.transport.add(transport);
    }

    public void viewTransport() {
        for (int i = 0; i < this.transport.size(); i++) {
            System.out.println("Transport " + (i + 1) + ":");
            System.out.println(this.transport.get(i).deliveryPlan());
        }
    }

    public void updateTransport(Transport transport, int id) {
        for (int i = 0; i < this.transport.size(); i++) {
            if (this.transport.get(i).getTransportID() == id) {
                this.transport.set(i, transport);
                break;
            }
        }
    }

    public void removeTransport(int id) {
        for (int i = 0; i < this.transport.size(); i++) {
            if (this.transport.get(i).getTransportID() == id) {
                this.transport.remove(i);
                break;
            }
        }
    }

    // Package CRUD operations
    public void addPackage(Package package_) {
        this.packages.add(package_);
    }

    public void viewPackages() {
        for (int i = 0; i < this.packages.size(); i++) {
            System.out.println("Package " + (i + 1) + ":");
            this.packages.get(i).viewPackage();
        }
    }

    public void updatePackage(Package package_, int id) {
        for (int i = 0; i < this.packages.size(); i++) {
            if (this.packages.get(i).getPackageID() == id) {
                this.packages.set(i, package_);
                break;
            }
        }
    }

    public void removePackage(int id) {
        for (int i = 0; i < this.packages.size(); i++) {
            if (this.packages.get(i).getPackageID() == id) {
                this.packages.remove(i);
                break;
            }
        }
    }

    // Customer CRUD operations
    public void addShipment(Shipment shipment, int id) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getID() == id) {
                this.customers.get(i).addShipment(shipment);
                break;
            }
        }

    }

    public void addShipment(Shipment shipment, Customer customer) {
        customer.addShipment(shipment);
        this.customers.add(customer);
    }

    public void viewShipments(int customerID) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getID() == customerID) {
                this.customers.get(i).viewCustomerShipments();
                break;
            }
        }
    }

    public void updateShipment(int customerID, int ShipmentID, Shipment shipment) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getID() == customerID) {
                for (int j = 0; j < this.customers.get(i).getShipments().size(); j++) {
                    if (this.customers.get(i).getShipments().get(j).getShipmentID() == ShipmentID) {
                        this.customers.get(i).getShipments().set(j, shipment);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void cancelShipment(int customerID, int ShipmentID) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getID() == customerID) {
                for (int j = 0; j < this.customers.get(i).getShipments().size(); j++) {
                    if (this.customers.get(i).getShipments().get(j).getShipmentID() == ShipmentID) {
                        this.customers.get(i).getShipments().remove(j);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void restore() {
        State state = facade.load();
        this.stock = state.getStock();
        this.packages = state.getPackages();
        this.suppliers = state.getSuppliers();
        this.customers = state.getCustomers();
        this.transport = state.getTransports();
    }

    public void save() {
        State state = new State(this.stock, this.transport, this.packages, this.suppliers, this.customers);
        facade.save(state);
    }
}
