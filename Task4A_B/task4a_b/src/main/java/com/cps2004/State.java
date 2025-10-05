package com.cps2004;

import java.util.ArrayList;
import java.util.List;

public class State {
    private Stock stock;
    private List<Transport> transports;
    private List<Package> packages;
    private List<Supplier> suppliers;
    private List<Customer> customers;

    // Default constructor
    public State() {
        this.transports = new ArrayList<>();
        this.packages = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Parameterized constructor
    public State(Stock stock, List<Transport> transports, List<Package> packages, List<Supplier> suppliers, List<Customer> customers) {
        this.stock = stock;
        this.transports = transports;
        this.packages = packages;
        this.suppliers = suppliers;
        this.customers = customers;
    }

    // Getters and setters
    public Stock getStock() { return stock; }
    public List<Transport> getTransports() { return transports; }
    public List<Package> getPackages() { return packages; }
    public List<Supplier> getSuppliers() { return suppliers; }
    public List<Customer> getCustomers() { return customers; }
    public void setStock(Stock stock) { this.stock = stock; }
    public void setTransports(List<Transport> transports) { this.transports = transports; }
    public void setPackages(List<Package> packages) { this.packages = packages; }
    public void setSuppliers(List<Supplier> suppliers) { this.suppliers = suppliers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }

}
