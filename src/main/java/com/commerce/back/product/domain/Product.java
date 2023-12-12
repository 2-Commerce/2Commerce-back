package com.commerce.back.product.domain;

import com.commerce.back.product.application.ProductDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`product`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private Long storeId;

    private String productName;

    private String productCategory;

    private Long productQuantity;

    private Long productPrice;

    private String productImageUrl;

    public ProductDto toDto() { return new ProductDto(productId, storeId, productName, productCategory, productQuantity, productPrice, productImageUrl); }
}
