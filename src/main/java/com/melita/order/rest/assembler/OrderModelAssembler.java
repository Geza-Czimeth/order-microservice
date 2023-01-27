package com.melita.order.rest.assembler;

import com.melita.order.dto.OrderDTO;
import com.melita.order.model.*;

import java.util.List;

public class OrderModelAssembler implements ModelAssembler<OrderDTO, Order> {

    private final AddressModelAssembler addressModelAssembler;
    private final CustomerModelAssembler customerModelAssembler;
    private final InstallationDateTimeModelAssembler installationDateTimeModelAssembler;
    private final ProductModelAssembler productModelAssembler;

    public OrderModelAssembler(AddressModelAssembler addressModelAssembler, CustomerModelAssembler customerModelAssembler, InstallationDateTimeModelAssembler installationDateTimeModelAssembler, ProductModelAssembler productModelAssembler) {
        this.addressModelAssembler = addressModelAssembler;
        this.customerModelAssembler = customerModelAssembler;
        this.installationDateTimeModelAssembler = installationDateTimeModelAssembler;
        this.productModelAssembler = productModelAssembler;
    }
    @Override
    public Order assemble(OrderDTO orderDTO) {
        Customer customer = customerModelAssembler.assemble(orderDTO.customerDTO());
        Address address = addressModelAssembler.assemble(orderDTO.addressDTO());
        InstallationDateTime installationDateTime = installationDateTimeModelAssembler.assemble(orderDTO.installationDateTime());
        List<Product> products = orderDTO.productList().stream().map(productDTO -> productModelAssembler.assemble(productDTO)).toList();

        return new Order(customer, address, installationDateTime, products);
    }
}
