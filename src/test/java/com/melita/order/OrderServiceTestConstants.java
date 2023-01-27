package com.melita.order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface OrderServiceTestConstants {
    String ADDRESS_1 = "Address 1";
    String ADDRESS = "Address 1";
    String FIRST_NAME = "firstName";
    String LAST_NAME = "lastName";
    String PRODUCT_NAME = "productName";
    String PACKAGE_NAME = "packageName";
    String BLANK_STRING = "";
    LocalDateTime TIMESLOT_1 = LocalDateTime.of(LocalDate.of(2023, 3, 1), LocalTime.of(10, 10));
    LocalDateTime TIMESLOT_2 = LocalDateTime.of(LocalDate.of(2023, 3, 3), LocalTime.of(10, 10));

}
