package com.melita.order.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonSerialize
public record OrderDTO(@Valid @NotNull CustomerDTO customerDTO, @Valid @NotNull AddressDTO addressDTO,
                       @Valid @NotNull InstallationDateTimeDTO installationDateTime,
                       @Valid @NotEmpty @NotNull List<ProductDTO> productList) {

}
