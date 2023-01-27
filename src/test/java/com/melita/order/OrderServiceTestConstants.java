package com.melita.order;

import com.melita.order.model.ProductName;
import com.melita.order.model.ProductPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.melita.order.model.ProductName.Internet;
import static com.melita.order.model.packages.InternetPackage.Mbps_250;

public interface OrderServiceTestConstants {
    String ADDRESS_1 = "Address 1";
    String ADDRESS = "Address 1";
    String FIRST_NAME = "firstName";
    String LAST_NAME = "lastName";
    ProductName PRODUCT_NAME = Internet;
    ProductPackage PACKAGE_NAME = Mbps_250;
    String BLANK_STRING = "";
    LocalDateTime TIMESLOT_1 = LocalDateTime.of(LocalDate.of(2023, 3, 1), LocalTime.of(10, 10));
    LocalDateTime TIMESLOT_2 = LocalDateTime.of(LocalDate.of(2023, 3, 3), LocalTime.of(10, 10));

}
