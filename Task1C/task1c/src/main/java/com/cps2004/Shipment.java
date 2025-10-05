package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;


public class Shipment {
    private Transport transport;
    private List<ShipmentItem> packagedItems;
    private boolean dispatched;
    private double distance;
    private String dispatchDate;
    private int shipmentID;

    // Default constructor
    public Shipment() {
        this.transport = null;
        this.packagedItems = new ArrayList<>();
        this.dispatched = false;
        this.distance = 0.0;
        this.dispatchDate = "";
        this.shipmentID = 0;
    }

    // Parameterized constructor
    public Shipment(Transport transport, List<ShipmentItem> packagedItems, boolean dispatched, double distance, String dispatchDate, int shipmentID) {
        this.transport = transport;
        this.packagedItems = packagedItems;
        this.dispatched = dispatched;
        this.distance = distance;
        this.dispatchDate = dispatchDate;
        this.shipmentID = shipmentID;
    }

    // Getters and setters
    public Transport getTransport() { return transport; }
    public List<ShipmentItem> getPackagedItems() { return packagedItems; }
    public boolean isDispatched() { return dispatched; }
    public double getDistance() { return distance; }
    public String getDispatchDate() { return dispatchDate; }
    public int getShipmentID() { return shipmentID; }
    public void setTransport(Transport transport) {
        if (this.dispatched) {
            System.out.println("Shipment has already been dispatched. Cannot change transport.");
            return;
        }
        this.transport = transport;
    }
    public void setPackagedItems(List<ShipmentItem> packagedItems) {
        if (this.dispatched) {
            System.out.println("Shipment has already been dispatched. Cannot change packaged items.");
            return;
        }
        this.packagedItems = packagedItems;
    }
    public void setDispatched(boolean dispatched) {
        if (this.dispatched) {
            System.out.println("Shipment has already been dispatched. Cannot change dispatched status.");
            return;
        }
        this.dispatched = dispatched;
    }
    public void setDistance(double distance) {
        if (this.dispatched) {
            System.out.println("Shipment has already been dispatched. Cannot change distance.");
            return;
        }
        this.distance = distance;
    }
    public void setDispatchDate(String dispatchDate) {
        if (this.dispatched) {
            System.out.println("Shipment has already been dispatched. Cannot change dispatch date.");
            return;
        }
        this.dispatchDate = dispatchDate;
    }
    public void setShipmentID(int shipmentID) {
        if (this.dispatched) {
            System.out.println("Shipment has already been dispatched. Cannot change shipment ID.");
            return;
        }
        this.shipmentID = shipmentID;
    }

    // Calculate shipment cost
    public double shipmentCost() {
        double cost = 0.0;
        for (ShipmentItem item : packagedItems) {
            cost += item.shipment_item_cost(dispatchDate);
        }
        return cost + this.transport.deliveryCost(distance);
    }

    // Generate delivery plan
    void generateDeliveryPlan() {
        System.out.println("Dispatch date: " + this.dispatchDate);
        System.out.println("Delivery time: " + this.transport.deliveryTime(distance));
        System.out.println("Delivery cost: " + this.shipmentCost());
        System.out.println("Route stages: " + this.transport.deliveryPlan());
        if (this.dispatched) {
            System.out.println("Dispatched: Yes");
        } else {
            System.out.println("Dispatched: No");
        }
        for (ShipmentItem item : this.packagedItems) {
            item.display_shipment_item();
        }
    }

    // Save shipment information to file
    public void save(ObjectNode newItem) {
        newItem.put("dispatchDate", this.dispatchDate);
        newItem.put("distance", this.distance);
        newItem.put("shipmentID", this.shipmentID);
        newItem.put("dispatched", this.dispatched);
        this.transport.save(newItem);
        ArrayNode packagedItems = newItem.putArray("packaged_items");
        for (ShipmentItem item : this.packagedItems) {
            ObjectNode newItem2 = packagedItems.addObject();
            item.save(newItem2);
        }
    }


    // Load shipment information from file
    public void load(JsonNode node) {
        this.dispatchDate = node.get("dispatchDate").asText();
        this.distance = node.get("distance").asDouble();
        this.shipmentID = node.get("shipmentID").asInt();
        this.dispatched = node.get("dispatched").asBoolean();
        JsonNode packagedItems = node.withArray("packaged_items");
        for (int i = 0; i < packagedItems.size(); i++) {
            ObjectNode item = (ObjectNode) packagedItems.get(i);
            ShipmentItem newItem = new ShipmentItem();
            String type = item.get("type").asText();
            if (item.get("type").asText().equals("textbook")) {
                newItem.setProduct(new Textbook());
            } else if(item.get("type").asText().equals("fictionbook")) {
                newItem.setProduct(new FictionBook());
            } else if(item.get("type").asText().equals("fruit")) {
                newItem.setProduct(new Fruit());
            } else if(item.get("type").asText().equals("pants")) {
                newItem.setProduct(new Pants());
            } else if(item.get("type").asText().equals("premadeLunch")) {
                newItem.setProduct(new PremadeLunch());
            } else if (item.get("type").asText().equals("tshirt")) {
                newItem.setProduct(new TShirt());
            } else if (item.get("type").asText().equals("camera")) {
                newItem.setProduct(new Camera());
            } else if (item.get("type").asText().equals("laptop")) {
                newItem.setProduct(new Laptop());
            } else if (item.get("type").asText().equals("chair")) {
                newItem.setProduct(new Chair());
            } else if (item.get("type").asText().equals("table")) {
                newItem.setProduct(new Table());
            } else if (item.get("type").asText().equals("rpg")) {
                newItem.setProduct(new RPG());
            } else if (item.get("type").asText().equals("action")) {
                newItem.setProduct(new Action());
            }
            newItem.setPackage(new Package());
            newItem.load(item);
            this.packagedItems.add(newItem);
        }
        String type = node.get("transportType").asText();
        if (type.equals("truck")) {
            this.transport = new Truck();
        } else if (type.equals("ship")) {
            this.transport = new Ship();
        } else if (type.equals("plane")) {
            this.transport = new Plane();
        }
        this.transport.load(node);
    }

}
