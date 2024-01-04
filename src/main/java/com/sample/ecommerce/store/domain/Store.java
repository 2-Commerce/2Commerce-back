package com.sample.ecommerce.store.domain;

import com.sample.ecommerce.product.domain.Product;
import com.sample.ecommerce.store.application.StoreDto;
import com.sample.ecommerce.store.application.StoreRegisterRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "`store`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String sellerId;

    private String storeLicense;

    private String storeAccountNumber;

    private String storeName;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList;

    public Store(StoreRegisterRequest storeRegisterRequest) {
        this.sellerId = storeRegisterRequest.getSellerId();
        this.storeLicense = storeRegisterRequest.getStoreLicense();
        this.storeAccountNumber = storeRegisterRequest.getStoreAccountNumber();
        this.storeName = storeRegisterRequest.getStoreName();
    }

    public StoreDto toDto() {return new StoreDto(storeId, sellerId, storeLicense, storeAccountNumber, storeName); }
}
