package com.sample.ecommerce.store.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "가게")
public class StoreDto {

    @Schema(description = "가게 ID")
    Long storeId;

    @Schema(description = "판매자 ID")
    String sellerId;

    @Schema(description = "가게 사업자등록번호")
    String storeLicense;

    @Schema(description = "가게 계좌번호")
    String storeAccountNumber;

    @Schema(description = "가게 이름")
    String storeName;
}
