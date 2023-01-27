package com.melita.order.rest.assembler;

import com.melita.order.dto.ProductDTO;
import com.melita.order.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.melita.order.OrderServiceTestConstants.PACKAGE_NAME;
import static com.melita.order.OrderServiceTestConstants.PRODUCT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductModelAssemblerTest {
    private ProductModelAssembler productModelAssembler;

    @BeforeEach
    public void setup() {
        productModelAssembler = new ProductModelAssembler();
    }

    @Test
    void productDTOAssembledToProduct() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME, PACKAGE_NAME);
        Product actualProduct = productModelAssembler.assemble(productDTO);
        assertEquals(new Product(PRODUCT_NAME, PACKAGE_NAME), actualProduct);
    }
}