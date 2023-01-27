package com.melita.order.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class AbstractDTOTest {

    protected static final String ADDRESS = "Address 1";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    protected static final String PRODUCT_NAME = "productName";
    protected static final String PACKAGE_NAME = "packageName";
    protected static final String BLANK_STRING = "";
    protected static final LocalDateTime TIMESLOT_1 = LocalDateTime.of(LocalDate.of(2023, 3, 1), LocalTime.of(10, 10));
    protected static final LocalDateTime TIMESLOT_2 = LocalDateTime.of(LocalDate.of(2023, 3, 3), LocalTime.of(10, 10));

    protected static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}
