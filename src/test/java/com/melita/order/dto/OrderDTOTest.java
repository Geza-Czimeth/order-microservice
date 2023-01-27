package com.melita.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static com.melita.order.OrderServiceTestConstants.*;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderDTOTest extends AbstractDTOTest {

    private final AddressDTO addressDTO = new AddressDTO(ADDRESS);
    private final CustomerDTO customerDTO = new CustomerDTO(FIRST_NAME, LAST_NAME);
    private final List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
    private final InstallationDateTimeDTO installationDateTimeDTO = new InstallationDateTimeDTO(timeSlots);
    private final ProductDTO productDTO = new ProductDTO(PRODUCT_NAME, PACKAGE_NAME);

    @Test
    public void validatorPassesIfOrderDTOIsValid() {
        OrderDTO orderDTO = new OrderDTO(customerDTO, addressDTO, installationDateTimeDTO, List.of(productDTO));
        Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfCustomerDTOIsNull() {
        OrderDTO orderDTO = new OrderDTO(null, addressDTO, installationDateTimeDTO, List.of(productDTO));
        Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfAddressDTOIsNull() {
        OrderDTO orderDTO = new OrderDTO(customerDTO, null, installationDateTimeDTO, List.of(productDTO));
        Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfInstallationDateTimeDTOIsNull() {
        OrderDTO orderDTO = new OrderDTO(customerDTO, addressDTO, null, List.of(productDTO));
        Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductDTOIsNull() {
        OrderDTO orderDTO = new OrderDTO(customerDTO, addressDTO, installationDateTimeDTO, null);
        Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductListIsEmpty() {
        OrderDTO orderDTO = new OrderDTO(customerDTO, addressDTO, installationDateTimeDTO, EMPTY_LIST);
        Set<ConstraintViolation<OrderDTO>> violations = validator.validate(orderDTO);
        assertFalse(violations.isEmpty());
    }
}
