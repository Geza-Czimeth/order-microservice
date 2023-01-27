package com.melita.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.melita.order.OrderServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerDTOTest extends AbstractDTOTest {
    @Test
    public void validatorPassesIfCustomerIsValid() {
        CustomerDTO customerDTO = new CustomerDTO(FIRST_NAME, LAST_NAME);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfFirstNameIsNull() {
        CustomerDTO customerDTO = new CustomerDTO(null, LAST_NAME);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfFirstNameIsBlank() {
        CustomerDTO customerDTO = new CustomerDTO(BLANK_STRING, LAST_NAME);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfLastNameIsNull() {
        CustomerDTO customerDTO = new CustomerDTO(FIRST_NAME, null);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorThrowsExceptionIfLastNameIsBlank() {
        CustomerDTO customerDTO = new CustomerDTO(FIRST_NAME, BLANK_STRING);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertFalse(violations.isEmpty());
    }
}
