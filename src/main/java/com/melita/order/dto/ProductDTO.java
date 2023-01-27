package com.melita.order.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductDTO(@NotBlank String productName, @NotBlank String packageName) {
}
