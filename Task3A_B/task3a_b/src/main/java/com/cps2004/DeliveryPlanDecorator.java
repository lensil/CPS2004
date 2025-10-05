package com.cps2004;

import java.util.List;

public class DeliveryPlanDecorator extends ShipmentDecorator{
    private List<String> newRoute;

    public DeliveryPlanDecorator(Shipment decoratedShipment, List<String> newRoute) {
        super(decoratedShipment);
        this.newRoute = newRoute;
    }

    @Override
    public void generateDeliveryPlan() {
        shipment.generateDeliveryPlan();
        System.out.println("Previous route is unavailable. New route: " + newRoute);
    }
}
