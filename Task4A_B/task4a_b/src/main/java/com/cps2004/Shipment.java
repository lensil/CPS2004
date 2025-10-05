package com.cps2004;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.List;


public class Shipment {
    private Transport transport;
    private List<ShipmentItem> packagedItems;
    private boolean dispatched;
    private double distance;
    private String dispatchDate;
    private int shipmentID;
    private final ShipmentServiceGrpc.ShipmentServiceBlockingStub shipmentServiceStub;


    // Default constructor
    public Shipment() {
        this.transport = null;
        this.packagedItems = new ArrayList<>();
        this.dispatched = false;
        this.distance = 0.0;
        this.dispatchDate = "";
        this.shipmentID = 0;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
       this.shipmentServiceStub = ShipmentServiceGrpc.newBlockingStub(channel);
    }

    // Parameterized constructor
    public Shipment(Transport transport, List<ShipmentItem> packagedItems, boolean dispatched, double distance, String dispatchDate, int shipmentID) {
        this.transport = transport;
        this.packagedItems = packagedItems;
        this.dispatched = dispatched;
        this.distance = distance;
        this.dispatchDate = dispatchDate;
        this.shipmentID = shipmentID;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        shipmentServiceStub = ShipmentServiceGrpc.newBlockingStub(channel);
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
    double shipmentCost() {
        DataStructures.Shipment shipment = DataStructures.Shipment.newBuilder()
                .setDistance(this.distance)
                .setDispatchedDate(this.dispatchDate)
                .setDispatched(this.dispatched)
                .setShipmentID(this.shipmentID)
                .addAllPackagedItems(this.packagedItems.stream().map(item -> DataStructures.ShipmentItem.newBuilder()
                        .setQuantity(item.getQuantity())
                        .setProduct(DataStructures.Product.newBuilder()
                                .setProductID(item.getProduct().getId())
                                .setName(item.getProduct().getName())
                                .setPrice(item.getProduct().getPrice())
                                .build())
                        .setPackage(DataStructures.Package.newBuilder()
                                .setPackageID(item.getPackage().getPackageID())
                                .setType(item.getPackage().getType())
                                .setCost(item.getPackage().getCost())
                                .build())
                        .build()).toList())
                .build();
        ShipmentServiceOuterClass.CalculateTotalPriceRequest request = ShipmentServiceOuterClass.CalculateTotalPriceRequest.newBuilder()
                .setShipment(shipment)
                .build();

        ShipmentServiceOuterClass.CalculateTotalPriceResponse response = shipmentServiceStub.calculateTotalPrice(request);
        return response.getTotalPrice();
    }



    // Generate delivery plan
    public void generateDeliveryPlan() {
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

}
