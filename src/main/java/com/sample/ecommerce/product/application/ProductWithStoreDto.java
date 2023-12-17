package com.sample.ecommerce.product.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "물품과 가게")
public class ProductWithStoreDto {

    @Schema(description = "물품 ID")
    Long productId;

    @Schema(description = "가게 ID")
    Long storeId;

    @Schema(description = "물품 이름")
    String productName;

    @Schema(description = "물품 분류")
    String productCategory;

    @Schema(description = "물품 수량")
    Long productQuantity;

    @Schema(description = "주문 수량")
    Long productOrderQuantity;

    @Schema(description = "물품 가격")
    Long productPrice;

    @Schema(description = "물품 이미지 링크")
    String productImageUrl;

    @Schema(description = "판매자 ID")
    String sellerId;

    @Schema(description = "가게 사업자등록번호")
    String storeLicense;

    @Schema(description = "가게 계좌번호")
    String storeAccountNumber;

    @Schema(description = "가게 이름")
    String storeName;
}
