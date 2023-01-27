package com.melita.order.rest.assembler;

import com.melita.order.dto.ProductDTO;
import com.melita.order.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductModelAssembler implements ModelAssembler<ProductDTO, Product> {

    @Override
    public Product assemble(ProductDTO productDTO) {
        return new Product(productDTO.productName(), productDTO.packageName());
    }
}
