package com.melita.order.rest.assembler;

import com.melita.order.dto.ProductDTO;
import com.melita.order.model.Product;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.melita.order.OrderServiceTestConstants.PACKAGE_NAME;
import static com.melita.order.OrderServiceTestConstants.PRODUCT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductModelAssemblerTest {
    private static final String INVALID_PRODUCT = "invalid product";
    private ProductModelAssembler productModelAssembler;

    @BeforeEach
    public void setup() {
        productModelAssembler = new ProductModelAssembler();
    }

    @Test
    void productDTOAssembledToProduct() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), PACKAGE_NAME);
        Product actualProduct = productModelAssembler.assemble(productDTO);
        assertEquals(new Product(PRODUCT_NAME, PACKAGE_NAME), actualProduct);
    }

    @Test
    void productDTOAssembledThrowsExceptionIfProductNameIsInvalid() {
        ProductDTO productDTO = new ProductDTO(INVALID_PRODUCT, PACKAGE_NAME);
        assertThrows(ValidationException.class, () -> productModelAssembler.assemble(productDTO));
    }
}
