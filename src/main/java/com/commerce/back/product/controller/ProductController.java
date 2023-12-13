package com.commerce.back.product.controller;

import com.commerce.back.product.application.ProductDto;
import com.commerce.back.product.application.ProductSearchRequest;
import com.commerce.back.product.application.ProductSearchResponse;
import com.commerce.back.product.application.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
