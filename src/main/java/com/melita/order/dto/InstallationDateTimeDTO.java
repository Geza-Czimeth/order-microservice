package com.melita.order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record InstallationDateTimeDTO(@NotNull @NotEmpty List<LocalDateTime> availableTimeSlots) {
}
