package com.melita.order.rest.assembler;

import com.melita.order.dto.CustomerDTO;
import com.melita.order.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.melita.order.OrderServiceTestConstants.FIRST_NAME;
import static com.melita.order.OrderServiceTestConstants.LAST_NAME;

class CustomerModelAssemblerTest {
    private CustomerModelAssembler customerModelAssembler;

    @BeforeEach
    public void setup() {
        customerModelAssembler = new CustomerModelAssembler();
    }

    @Test
    void customerDTOAssembledToCustomer() {
        CustomerDTO customerDTO = new CustomerDTO(FIRST_NAME, LAST_NAME);
        Customer actualCustomer = customerModelAssembler.assemble(customerDTO);
        Assertions.assertEquals(new Customer(FIRST_NAME, LAST_NAME), actualCustomer);
    }
}
