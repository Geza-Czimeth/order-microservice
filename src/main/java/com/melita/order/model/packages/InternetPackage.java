package com.melita.order.model.packages;

import com.melita.order.model.ProductPackage;

import java.util.Arrays;
import java.util.Optional;

public enum InternetPackage implements ProductPackage {
    Mbps_250("250Mbps"), Gbps_1("1Gbps");
    private final String id;

    InternetPackage(String id) {
        this.id = id;
    }

    public static Optional<? extends ProductPackage> getById(String packageName) {
        return Arrays.stream(values()).filter(p -> p.id.equals(packageName)).findFirst();
    }

    @Override
    public String toString() {
        return id;
    }
}
