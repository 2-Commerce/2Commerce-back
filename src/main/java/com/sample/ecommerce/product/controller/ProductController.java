package com.sample.ecommerce.product.controller;

import com.sample.ecommerce.product.application.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품을 검색해서 조회한다.")
    @GetMapping("/api/product")
    public ProductSearchResponse searchProductList(ProductSearchRequest productSearchRequest){
        return new ProductSearchResponse(productService.searchProductList(productSearchRequest));
    }

    @Operation(summary = "상품을 등록한다.")
    @PostMapping("/api/product")
    public ProductRegisterResponse registerProduct(ProductRegisterRequest productRegisterRequest){
        return new ProductRegisterResponse(productService.registerProduct(productRegisterRequest).getProductId());
    }

    @Operation(summary = "가게 물품을 확인한다.")
    @GetMapping("/api/{storeId}/product")
    public ProductInStoreGetResponse getProductInStore(@PathVariable("storeId") Long storeId){
        return new ProductInStoreGetResponse(productService.getProductInStore(storeId));
    }

    @Operation(summary = "가게 물품을 수정한다.")
    @PutMapping("/api/product")
    public ProductUpdateResponse updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest){
        return productService.updateProduct(productUpdateRequest);
    }
}
