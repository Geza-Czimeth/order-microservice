package com.melita.order.model.packages;

import com.melita.order.model.ProductPackage;

import java.util.Arrays;
import java.util.Optional;

public enum MobilePackage implements ProductPackage {
    Prepaid("Prepaid"), PostPaid("Post-paid");

    private final String id;

    MobilePackage(String id) {
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
