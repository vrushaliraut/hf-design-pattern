package com.vrushali.lld.car.rental.system.model;

import com.vrushali.lld.car.rental.system.model.enums.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BranchTest {

    Branch branch;

    @BeforeEach
    void setup() {
        branch = new Branch("HSR");
    }

    @Test
    void shouldAddVehicleTypeSuccessfully() {
        branch.addVehicleType(VehicleType.SUV);
        assertThat(branch.getAllowedVehicleTypes()).contains(VehicleType.SUV);
    }

    @Test
    void shouldAddVehicleWhenTypeIsAllowed() {
        branch.addVehicleType(VehicleType.SEDAN);
        Vehicle vehicle = new Vehicle("V1", VehicleType.SEDAN, 200);
        boolean added = branch.addVehicle(vehicle);
        assertThat(added).isTrue();
        assertThat(branch.getRegisteredVehicles()).contains(vehicle);
    }

    @Test
    void shouldThrowIfVehicleTypeIsNotAllowed(){
        Vehicle vehicle = new Vehicle("V2", VehicleType.HATCHBACK, 150);

        assertThatThrownBy(() -> branch.addVehicle(vehicle))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not allowed");
    }

    @Test
    void shouldThrowIfVehicleIdAlreadyExists(){
        branch.addVehicleType(VehicleType.SUV);
        Vehicle v1 = new Vehicle("V3", VehicleType.SUV, 300);
        Vehicle v2 = new Vehicle("V3", VehicleType.SUV, 400);

        branch.addVehicle(v1);

        assertThatThrownBy(() -> branch.addVehicle(v2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("already exists");
    }

}