package com.melita.order.rest.assembler;

import com.melita.order.dto.*;
import com.melita.order.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.melita.order.OrderServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderModelAssemblerTest {

    private final AddressDTO addressDTO = new AddressDTO(ADDRESS);
    private final CustomerDTO customerDTO = new CustomerDTO(FIRST_NAME, LAST_NAME);
    private final List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
    private final InstallationDateTimeDTO installationDateTimeDTO = new InstallationDateTimeDTO(timeSlots);
    private final ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), PACKAGE_NAME);
    private OrderModelAssembler orderModelAssembler;
    private AddressModelAssembler addressModelAssembler;
    private CustomerModelAssembler customerModelAssembler;
    private InstallationDateTimeModelAssembler installationDateTimeModelAssembler;
    private ProductModelAssembler productModelAssembler;

    @BeforeEach
    public void setup() {
        addressModelAssembler = new AddressModelAssembler();
        customerModelAssembler = new CustomerModelAssembler();
        installationDateTimeModelAssembler = new InstallationDateTimeModelAssembler();
        productModelAssembler = new ProductModelAssembler();
        orderModelAssembler = new OrderModelAssembler(addressModelAssembler, customerModelAssembler, installationDateTimeModelAssembler, productModelAssembler);
    }

    @Test
    void orderDTOAssembledToOrder() {
        OrderDTO orderDTO = new OrderDTO(customerDTO, addressDTO, installationDateTimeDTO, List.of(productDTO));
        Address address = addressModelAssembler.assemble(addressDTO);
        Customer customer = customerModelAssembler.assemble(customerDTO);
        InstallationDateTime installationDateTime = installationDateTimeModelAssembler.assemble(installationDateTimeDTO);
        Product product = productModelAssembler.assemble(productDTO);

        Order actualorder = orderModelAssembler.assemble(orderDTO);
        assertEquals(new Order(customer, address, installationDateTime, List.of(product)), actualorder);
    }
}
