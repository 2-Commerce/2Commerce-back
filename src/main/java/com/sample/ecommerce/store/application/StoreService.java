package com.sample.ecommerce.store.application;

import com.sample.ecommerce.store.domain.Store;
import com.sample.ecommerce.store.domain.StoreRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoreService {

    StoreRepository storeRepository;
    public StoreDto registerStore(StoreRegisterRequest storeRegisterRequest) {
        final Store store = storeRepository.save(new Store(storeRegisterRequest));
        return store.toDto();
    }
}
