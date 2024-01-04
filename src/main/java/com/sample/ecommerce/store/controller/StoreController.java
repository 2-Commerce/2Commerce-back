package com.sample.ecommerce.store.controller;

import com.sample.ecommerce.store.application.StoreRegisterRequest;
import com.sample.ecommerce.store.application.StoreRegisterResponse;
import com.sample.ecommerce.store.application.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @Operation(summary = "가게를 등록한다.")
    @PostMapping("/api/store")
    public StoreRegisterResponse registerStore(@RequestBody StoreRegisterRequest storeRegisterRequest) {
        return new StoreRegisterResponse(storeService.registerStore(storeRegisterRequest).getStoreId());
    }
}
