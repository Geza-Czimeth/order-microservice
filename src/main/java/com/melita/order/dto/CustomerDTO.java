package com.melita.order.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;

@JsonSerialize
public record CustomerDTO(@NotBlank String firstName, @NotBlank String lastName) {
}
