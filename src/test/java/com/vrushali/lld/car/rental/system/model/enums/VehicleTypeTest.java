package com.vrushali.lld.car.rental.system.model.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTypeTest {

    @Test
    void shouldContainAllDefinedVehicleTypes() {
        assertThat(VehicleType.values()).containsExactlyInAnyOrder(
                VehicleType.SEDAN,
                VehicleType.SUV,
                VehicleType.BIKE,
                VehicleType.HATCHBACK
        );
    }
}