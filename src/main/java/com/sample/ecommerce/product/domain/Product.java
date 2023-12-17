package com.sample.ecommerce.product.domain;

import com.sample.ecommerce.product.application.ProductDto;
import com.sample.ecommerce.product.application.ProductWithStoreDto;
import com.sample.ecommerce.store.domain.Store;
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

    private String productName;

    private String productCategory;

    private Long productQuantity;

    @Transient
    private Long productOrderQuantity;

    private Long productPrice;

    private String productImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void order(Long productOrderQuantity){
        if( productOrderQuantity > 0 && this.productQuantity >= productOrderQuantity ){
            this.productOrderQuantity = productOrderQuantity;
            this.productQuantity -= this.productOrderQuantity;
        }
    }

    public ProductDto toDto() { return new ProductDto(productId, productName, productCategory, productQuantity, productPrice, productImageUrl); }

    public ProductWithStoreDto toDtoWithStore() { return new ProductWithStoreDto(productId, store.getStoreId(), productName, productCategory, productQuantity, productOrderQuantity, productPrice, productImageUrl, store.getSellerId(), store.getStoreLicense(), store.getStoreAccountNumber(), store.getStoreName()); }
}
