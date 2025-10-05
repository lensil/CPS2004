package com.cps2004;

public abstract class ShipmentDecorator extends Shipment {
    protected Shipment shipment;

    public ShipmentDecorator(Shipment shipment){
        this.shipment = shipment;
    }

    @Override
   public double shipmentCost() {
        return shipment.shipmentCost();

    }

    @Override
    public void generateDeliveryPlan() {
        shipment.generateDeliveryPlan();
    }
}
