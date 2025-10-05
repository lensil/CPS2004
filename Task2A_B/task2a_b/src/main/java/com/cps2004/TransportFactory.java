package com.cps2004;

import java.util.List;

public class TransportFactory {
    public Transport createTransport(String transportType, int transportSpeed, int costPerKm, int transportID, List<String> route) {

        if (transportType.equalsIgnoreCase("Truck")) {
            return new Truck(transportSpeed, costPerKm, transportID, route);
        } else if (transportType.equalsIgnoreCase("Ship")) {
            return new Ship(transportSpeed, costPerKm, transportID, route);
        } else if (transportType.equalsIgnoreCase("Plane")) {
            return new Plane(transportSpeed, costPerKm, transportID, route);
        }
        throw new IllegalArgumentException("Invalid transport type: " + transportType);
    }

    public Transport createTransport(String transportType) {
        if (transportType.equalsIgnoreCase("Truck")) {
            return new Truck();
        } else if (transportType.equalsIgnoreCase("Ship")) {
            return new Ship();
        } else if (transportType.equalsIgnoreCase("Plane")) {
            return new Plane();
        }
        throw new IllegalArgumentException("Invalid transport type: " + transportType);
    }
}
