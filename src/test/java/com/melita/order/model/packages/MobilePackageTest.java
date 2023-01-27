package com.melita.order.model.packages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MobilePackageTest {
    @Test
    void getByIdFindsRightEnum() {
        final MobilePackage[] values = MobilePackage.values();
        for (final MobilePackage mobilePackage : values) {
            assertEquals(mobilePackage, MobilePackage.getById(mobilePackage.toString()).get());
        }
    }
}
