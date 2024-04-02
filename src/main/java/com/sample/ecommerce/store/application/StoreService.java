package com.sample.ecommerce.store.application;

import com.sample.ecommerce.seller.domain.Seller;
import com.sample.ecommerce.seller.domain.SellerRepository;
import com.sample.ecommerce.store.domain.Store;
import com.sample.ecommerce.store.domain.StoreRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoreService {

    StoreRepository storeRepository;
    SellerRepository sellerRepository;

    public StoreDto registerStore(StoreRegisterRequest storeRegisterRequest) {
        Seller seller = sellerRepository.findBySellerId(storeRegisterRequest.getSellerId()).orElseThrow();
        Store store = new Store(storeRegisterRequest, seller);
        storeRepository.save(store);
        return store.toDto();
    }

    public Store findStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow();
    }
}
