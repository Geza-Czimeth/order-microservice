package com.melita.order.rest.assembler;

import com.melita.order.dto.ProductDTO;
import com.melita.order.model.Product;
import com.melita.order.model.ProductName;
import com.melita.order.model.ProductPackage;
import com.melita.order.model.packages.InternetPackage;
import com.melita.order.model.packages.MobilePackage;
import com.melita.order.model.packages.TelephonyPackage;
import com.melita.order.model.packages.TvPackage;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.text.MessageFormat.format;

@Component
public class ProductModelAssembler implements ModelAssembler<ProductDTO, Product> {


    private static final String PACKAGE_NAME_IS_NOT_VALID = "Package name {0} is not valid";
    private static final String PRODUCT_NAME_IS_NOT_VALID = "Product name {0} is not valid";

    private static ProductName getProduct(String productNameAsString) {
        ProductName productName;
        try {
            productName = ProductName.valueOf(productNameAsString);
        } catch (Exception ex) {
            throw new ValidationException(format(PRODUCT_NAME_IS_NOT_VALID, productNameAsString));
        }
        return productName;
    }

    @Override
    public Product assemble(ProductDTO productDTO) {
        ProductName productName;
        final String productNameAsString = productDTO.productName();
        productName = getProduct(productNameAsString);
        ProductPackage productPackage = getProductPackage(productName, productDTO.packageName());
        return new Product(productName, productPackage);
    }

    private ProductPackage getProductPackage(ProductName productName, String packageName) {
        Optional<? extends ProductPackage> productPackage = switch (productName) {
            case Internet -> InternetPackage.getById(packageName);
            case TV -> TvPackage.getById(packageName);
            case Telephony -> TelephonyPackage.getById(packageName);
            case Mobile -> MobilePackage.getById(packageName);
        };

        return productPackage.orElseThrow(() -> new ValidationException(format(PACKAGE_NAME_IS_NOT_VALID, packageName)));
    }
}
