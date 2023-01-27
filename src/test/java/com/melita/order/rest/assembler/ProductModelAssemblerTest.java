package com.melita.order.rest.assembler;

import com.melita.order.dto.ProductDTO;
import com.melita.order.model.Product;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.melita.order.OrderServiceTestConstants.PACKAGE_NAME;
import static com.melita.order.OrderServiceTestConstants.PRODUCT_NAME;
import static com.melita.order.model.ProductName.*;
import static com.melita.order.model.packages.MobilePackage.PostPaid;
import static com.melita.order.model.packages.TelephonyPackage.FreeOnNet;
import static com.melita.order.model.packages.TvPackage.TV_90;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductModelAssemblerTest {
    private static final String INVALID_PRODUCT = "invalid product";
    private static final String INVALID_PACKAGE = "Invalid package";
    private ProductModelAssembler productModelAssembler;

    @BeforeEach
    public void setup() {
        productModelAssembler = new ProductModelAssembler();
    }

    @Test
    void productDTOAssembledToProduct() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), PACKAGE_NAME.toString());
        Product actualProduct = productModelAssembler.assemble(productDTO);
        assertEquals(new Product(PRODUCT_NAME, PACKAGE_NAME), actualProduct);
    }

    @Test
    void productDTOAssembledToTelephony() {
        ProductDTO productDTO = new ProductDTO(Telephony.name(), FreeOnNet.toString());
        Product actualProduct = productModelAssembler.assemble(productDTO);
        assertEquals(new Product(Telephony, FreeOnNet), actualProduct);
    }

    @Test
    void productDTOAssembledToMobile() {
        ProductDTO productDTO = new ProductDTO(Mobile.name(), PostPaid.toString());
        Product actualProduct = productModelAssembler.assemble(productDTO);
        assertEquals(new Product(Mobile, PostPaid), actualProduct);
    }

    @Test
    void productDTOAssembledToTv() {
        ProductDTO productDTO = new ProductDTO(TV.toString(), TV_90.toString());
        Product actualProduct = productModelAssembler.assemble(productDTO);
        assertEquals(new Product(TV, TV_90), actualProduct);
    }

    @Test
    void productDTOAssembledThrowsExceptionIfPackageNameIsInvalid() {
        ProductDTO productDTO = new ProductDTO(PRODUCT_NAME.toString(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelAssembler.assemble(productDTO));
    }

    @Test
    void productDTOAssembledThrowsExceptionIfProductNameIsInvalid() {
        ProductDTO productDTO = new ProductDTO(INVALID_PRODUCT, PACKAGE_NAME.toString());
        assertThrows(ValidationException.class, () -> productModelAssembler.assemble(productDTO));
    }

    @Test
    void productDTOAssembledThrowsExceptionIfProductNameIsInvalidForTelephony() {
        ProductDTO productDTO = new ProductDTO(Telephony.name(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelAssembler.assemble(productDTO));
    }

    @Test
    void productDTOAssembledThrowsExceptionIfProductNameIsInvalidForTV() {
        ProductDTO productDTO = new ProductDTO(TV.name(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelAssembler.assemble(productDTO));
    }

    @Test
    void productDTOAssembledThrowsExceptionIfProductNameIsInvalidForMobile() {
        ProductDTO productDTO = new ProductDTO(Mobile.name(), INVALID_PACKAGE);
        assertThrows(ValidationException.class, () -> productModelAssembler.assemble(productDTO));
    }
}
