package com.melita.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderDTO(@Valid @NotNull CustomerDTO customer, @Valid @NotNull AddressDTO address,
                       @Valid @NotNull InstallationDateTimeDTO installationDateTime,
                       @Valid @NotEmpty @NotNull List<ProductDTO> productList) {

}
