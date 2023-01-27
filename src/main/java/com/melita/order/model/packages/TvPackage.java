package com.melita.order.model.packages;

import com.melita.order.model.ProductPackage;

import java.util.Arrays;
import java.util.Optional;

public enum TvPackage implements ProductPackage {

    TV_90("TV with 90 channels"), TV_140("TV with 140 channels");

    private final String id;

    TvPackage(String id) {
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
