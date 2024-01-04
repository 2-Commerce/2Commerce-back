package com.sample.ecommerce.store.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "가게 등록 요청")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegisterRequest {

    @Schema(description = "판매자 ID")
    private String sellerId;

    @Schema(description = "사업자 등록번호")
    private String storeLicense;

    @Schema(description = "가게 계좌 번호")
    private String storeAccountNumber;

    @Schema(description = "가게 이름")
    private String storeName;
}
