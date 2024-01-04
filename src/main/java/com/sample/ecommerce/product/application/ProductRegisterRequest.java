package com.sample.ecommerce.product.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "물품 등록 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterRequest {

    @Schema(description = "판매자 ID")
    private String sellerId;

    @Schema(description = "가게 ID")
    private Long storeId;

    @Schema(description = "물품 카테고리")
    private String productCategory;

    @Schema(description = "물품 이름")
    private String productName;

    @Schema(description = "물품 가격")
    private Long productPrice;

    @Schema(description = "물품 수량")
    private Long productQuantity;

    @Schema(description = "url")
    private String url;
}
