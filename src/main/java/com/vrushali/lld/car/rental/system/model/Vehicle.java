package com.vrushali.lld.car.rental.system.model;

import com.vrushali.lld.car.rental.system.model.enums.VehicleType;

import java.util.Objects;

public class Vehicle {
    private  final String id;
    private final VehicleType type;
    private final double pricePerHour;

    public Vehicle(String id, VehicleType type, double pricePerHour) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Vehicle Id cannot be null or empty");
        }

        if (pricePerHour <= 0){
            throw new IllegalArgumentException("Price per hour must be positive");
        }

        this.id = id;
        this.type = type;
        this.pricePerHour = pricePerHour;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(pricePerHour, vehicle.pricePerHour) == 0 && Objects.equals(id, vehicle.id) && type == vehicle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, pricePerHour);
    }
}
