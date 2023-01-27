package com.melita.order.rest.assembler;

import com.melita.order.dto.CustomerDTO;
import com.melita.order.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelAssembler implements ModelAssembler<CustomerDTO, Customer> {

    @Override
    public Customer assemble(CustomerDTO customerDTO) {
        return new Customer(customerDTO.firstName(), customerDTO.lastName());
    }
}
