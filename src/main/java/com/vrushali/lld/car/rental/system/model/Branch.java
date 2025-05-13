package com.vrushali.lld.car.rental.system.model;

import com.vrushali.lld.car.rental.system.model.enums.VehicleType;

import java.util.*;

public class Branch {
    // always declare final
    private final String name;
    private final Set<VehicleType> allowedVehicleTypes;
    private final Map<String, Vehicle> registeredVehicles;

    public Branch(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Branch name cannot be empty");
        }
        this.name = name;
        allowedVehicleTypes = new HashSet<>();
        registeredVehicles = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addVehicleType(VehicleType type) {
        allowedVehicleTypes.add(type);
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (!allowedVehicleTypes.contains(vehicle.getType())) {
            throw new IllegalArgumentException("Vehicle type " + vehicle.getType() + " not allowed in this branch");
        }

        if (registeredVehicles.containsKey(vehicle.getId())) {
            throw new IllegalArgumentException("Vehicle with ID " + vehicle.getId() + " already exists");
        }

        registeredVehicles.put(vehicle.getId(), vehicle);
        return true;
    }

    public Set<VehicleType> getAllowedVehicleTypes() {
        return Collections.unmodifiableSet(allowedVehicleTypes); // brownie points
    }

    // Always return supertype
    public Collection<Vehicle> getRegisteredVehicles() {  // brownie points
        return Collections.unmodifiableCollection(registeredVehicles.values());
    }
}
