package com.melita.order.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@JsonSerialize
public record InstallationDateTimeDTO(@NotNull @NotEmpty List<LocalDateTime> availableTimeSlots) {
}
