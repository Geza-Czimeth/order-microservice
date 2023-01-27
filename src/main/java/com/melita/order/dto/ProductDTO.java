package com.melita.order.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;

@JsonSerialize
public record ProductDTO(@NotBlank String productName, @NotBlank String packageName) {
}
