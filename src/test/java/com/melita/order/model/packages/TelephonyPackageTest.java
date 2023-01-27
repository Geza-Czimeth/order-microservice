package com.melita.order.model.packages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TelephonyPackageTest {

    @Test
    void getByIdFindsRightEnum() {
        final TelephonyPackage[] values = TelephonyPackage.values();
        for (final TelephonyPackage telephonyPackage : values) {
            assertEquals(telephonyPackage, TelephonyPackage.getById(telephonyPackage.toString()).get());
        }
    }
}
