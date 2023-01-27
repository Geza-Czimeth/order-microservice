package com.melita.order.model.packages;

import com.melita.order.model.ProductPackage;

import java.util.Arrays;
import java.util.Optional;

public enum TelephonyPackage implements ProductPackage {
    FreeOnNet("Free On net Calls"), UnlimitedCalls("Unlimited Calls");
    private final String id;

    TelephonyPackage(String id) {
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
