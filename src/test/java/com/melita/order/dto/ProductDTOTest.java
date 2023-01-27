package com.melita.order.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.melita.order.OrderServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductDTOTest extends AbstractDTOTest {

    @Test
    public void validatorPassesIfProductDTOIsValid() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), PACKAGE_NAME.toString());
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductNameIsNull() {
        ProductDTO productDTO = new ProductDTO(null, PACKAGE_NAME.toString());
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfProductNameIsBlank() {
        ProductDTO productDTO = new ProductDTO(BLANK_STRING, PACKAGE_NAME.toString());
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfPackageNameIsNull() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), null);
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validatorFailsIfPackageNameIsBlank() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), BLANK_STRING);
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertFalse(violations.isEmpty());
    }
}
