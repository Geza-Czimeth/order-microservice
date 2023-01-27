package com.melita.order.model.packages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TvPackageTest {

    @Test
    void getByIdFindsRightEnum() {
        final TvPackage[] values = TvPackage.values();
        for (final TvPackage tvPackage : values) {
            assertEquals(tvPackage, TvPackage.getById(tvPackage.toString()).get());
        }
    }
}
