package com.melita.order.model.packages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InternetPackageTest {

    @Test
    void getByIdFindsRightEnum() {
        final InternetPackage[] values = InternetPackage.values();
        for (final InternetPackage internetPackage : values) {
            assertEquals(internetPackage, InternetPackage.getById(internetPackage.toString()).get());
        }
    }
}
