package com.melita.order.rest.assembler;

import com.melita.order.dto.AddressDTO;
import com.melita.order.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.melita.order.OrderServiceTestConstants.ADDRESS_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressModelAssemblerTest {

    private AddressModelAssembler addressModelAssembler;

    @BeforeEach
    public void setup() {
        addressModelAssembler = new AddressModelAssembler();
    }

    @Test
    void addressDTOAssembledToAddress() {
        AddressDTO addressDTO = new AddressDTO(ADDRESS_1);
        Address actualAddress = addressModelAssembler.assemble(addressDTO);
        assertEquals(new Address(ADDRESS_1), actualAddress);
    }
}
