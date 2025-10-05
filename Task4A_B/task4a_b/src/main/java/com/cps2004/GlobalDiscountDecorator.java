package com.cps2004;

public class GlobalDiscountDecorator extends ShipmentDecorator{
    private double discountRate;

    public GlobalDiscountDecorator(Shipment decoratedShipment, double discountRate) {
        super(decoratedShipment);
        this.discountRate = discountRate;
    }

    @Override
    public double shipmentCost() {
        double originalCost = shipment.shipmentCost();
        return originalCost * (discountRate);  
    }

    @Override
    public void generateDeliveryPlan() {
        shipment.generateDeliveryPlan(); 
        System.out.println("Adjusted Cost with Global Discount: " + this.shipmentCost());
    }
}
