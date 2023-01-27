package com.melita.order.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(@NotBlank String address) {
}
