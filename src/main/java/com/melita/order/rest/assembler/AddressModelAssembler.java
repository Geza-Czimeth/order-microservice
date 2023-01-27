package com.melita.order.rest.assembler;

import com.melita.order.dto.AddressDTO;
import com.melita.order.model.Address;

public class AddressModelAssembler implements ModelAssembler<AddressDTO, Address> {

    @Override
    public Address assemble(AddressDTO addressDTO) {
        return new Address(addressDTO.address());
    }
}
