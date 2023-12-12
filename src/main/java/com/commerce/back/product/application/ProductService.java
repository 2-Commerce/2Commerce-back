package com.commerce.back.product.application;

import com.commerce.back.product.domain.Product;
import com.commerce.back.product.domain.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;

    public List<ProductDto> searchProductList(ProductSearchRequest productSearchRequest) {
        return productRepository.searchProduct(productSearchRequest.getKeyword(), productSearchRequest.getCategory()).stream().map(Product::toDto).collect(Collectors.toList());
    }
}
