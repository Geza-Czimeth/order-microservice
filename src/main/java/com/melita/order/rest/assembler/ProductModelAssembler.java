package com.melita.order.rest.assembler;

import com.melita.order.dto.ProductDTO;
import com.melita.order.model.Product;
import com.melita.order.model.ProductName;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import static java.text.MessageFormat.format;

@Component
public class ProductModelAssembler implements ModelAssembler<ProductDTO, Product> {


    @Override
    public Product assemble(ProductDTO productDTO) {
        ProductName productName;
        final String productNameAsString = productDTO.productName();
        productName = getProduct(productNameAsString);
        return new Product(productName, productDTO.packageName());
    }

    private static ProductName getProduct(String productNameAsString) {
        ProductName productName;
        try {
            productName = ProductName.valueOf(productNameAsString);
        } catch (Exception ex) {
            throw new ValidationException(format("Product name {0} is not valid", productNameAsString));
        }
        return productName;
    }
}
