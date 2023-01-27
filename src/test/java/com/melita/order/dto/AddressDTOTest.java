package com.melita.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.melita.order.OrderServiceTestConstants.ADDRESS;
import static com.melita.order.OrderServiceTestConstants.BLANK_STRING;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressDTOTest extends AbstractDTOTest {
    @Test
    public void validatorPassesIfAddressIsValid() {
        AddressDTO addressDTO = new AddressDTO(ADDRESS);
        Set<ConstraintViolation<AddressDTO>> violations = validator.validate(addressDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfAddressIsBlank() {
        AddressDTO addressDTO = new AddressDTO(BLANK_STRING);
        Set<ConstraintViolation<AddressDTO>> violations = validator.validate(addressDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfAddressIsNull() {
        AddressDTO addressDTO = new AddressDTO(null);
        Set<ConstraintViolation<AddressDTO>> violations = validator.validate(addressDTO);
        assertFalse(violations.isEmpty());
    }
}
