package com.melita.order.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstallationDateTimeDTOTest extends AbstractDTOTest {
    @Test
    public void validatorPassesIfCustomerIsValid() {
        List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
        InstallationDateTimeDTO installationDateTimeDTO = new InstallationDateTimeDTO(timeSlots);
        Set<ConstraintViolation<InstallationDateTimeDTO>> violations = validator.validate(installationDateTimeDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfTimeSlotsIsNull() {
        InstallationDateTimeDTO installationDateTimeDTO = new InstallationDateTimeDTO(null);
        Set<ConstraintViolation<InstallationDateTimeDTO>> violations = validator.validate(installationDateTimeDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfTimeSlotsIsEmpty() {
        @NotNull List<LocalDateTime> timeSlots = List.of();
        InstallationDateTimeDTO installationDateTimeDTO = new InstallationDateTimeDTO(timeSlots);
        Set<ConstraintViolation<InstallationDateTimeDTO>> violations = validator.validate(installationDateTimeDTO);
        assertFalse(violations.isEmpty());
    }
}
