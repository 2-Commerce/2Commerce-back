package com.sample.ecommerce.product.controller;

import com.sample.ecommerce.product.application.ProductSearchRequest;
import com.sample.ecommerce.product.application.ProductSearchResponse;
import com.sample.ecommerce.product.application.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품을 검색해서 조회한다.")
    @GetMapping("/api/product")
    public ProductSearchResponse searchProductList(ProductSearchRequest productSearchRequest){
        return new ProductSearchResponse(productService.searchProductList(productSearchRequest));
    }
}
