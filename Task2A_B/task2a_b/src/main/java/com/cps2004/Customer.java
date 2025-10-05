package com.cps2004;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private int ID;
    private double distanceFromWarehouse;
    private List<Shipment> shipments;

    // Default constructor
    public Customer() {
        this.name = "";
        this.address = "";
        this.ID = 0;
        this.distanceFromWarehouse = 0;
        this.shipments = new ArrayList<>();
    }

    // Parameterized constructor
    public Customer(String name, String address, int ID, double distanceFromWarehouse, List<Shipment> shipments) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.distanceFromWarehouse = distanceFromWarehouse;
        this.shipments = shipments;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getID() { return ID; }
    public double getDistanceFromWarehouse() { return distanceFromWarehouse; }
    public List<Shipment> getShipments() { return shipments; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setID(int ID) { this.ID = ID; }
    public void setDistanceFromWarehouse(double distanceFromWarehouse) { this.distanceFromWarehouse = distanceFromWarehouse; }
    public void setShipments(List<Shipment> shipments) { this.shipments = shipments; }

    // Add shipment to customer
    public void addShipment(Shipment shipment) {
        this.shipments.add(shipment);
    }

    // Remove shipment from customer
    public void removeShipment(int ID) {
        for (int i = 0; i < this.shipments.size(); i++) {
            if (this.shipments.get(i).getShipmentID() == ID) {
                if (this.shipments.get(i).isDispatched()) {
                    System.out.println("Shipment has already been dispatched. Cannot remove shipment.");
                    return;
                }
                ArrayList<Shipment> temp = new ArrayList<>(this.shipments);
                temp.remove(i);
                this.shipments = temp;
                break;
            }
        }
    }

    // View customer shipments
    public void viewCustomerShipments() {
        System.out.println("Customer shipments: ");
        for (int i = 0; i < this.shipments.size(); i++) {
            System.out.println("Shipment " + (i+1) + ": ");
            this.shipments.get(i).generateDeliveryPlan();
        }
    }

    // Save customer information to file
    public void save(ObjectNode newItem) {
        newItem.put("customerName", this.name);
        newItem.put("customerAddress", this.address);
        newItem.put("customerID", this.ID);
        newItem.put("distanceFromWarehouse", this.distanceFromWarehouse);
        ArrayNode shipmentsArray = newItem.putArray("customerShipments");
        for (int i = 0; i < this.shipments.size(); i++) {
            ObjectNode shipment = shipmentsArray.addObject();
            this.shipments.get(i).save(shipment);
        }
    }

    // Load customer information from file
    public void load(ObjectNode node) {
        this.name = node.get("customerName").asText();
        this.address = node.get("customerAddress").asText();
        this.ID = node.get("customerID").asInt();
        this.distanceFromWarehouse = node.get("distanceFromWarehouse").asDouble();
        ArrayNode shipmentsArray = (ArrayNode) node.get("customerShipments");
        for (int i = 0; i < shipmentsArray.size(); i++) {
            ObjectNode shipment = (ObjectNode) shipmentsArray.get(i);
            Shipment newShipment = new Shipment();
            newShipment.load(shipment);
            this.shipments.add(newShipment);
        }
    }

}
