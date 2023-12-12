package com.commerce.back.product.application;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "물품")
public class ProductDto {

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

    @Schema(description = "물품 가격")
    Long productPrice;

    @Schema(description = "물품 이미지 링크")
    String productImageUrl;

}
