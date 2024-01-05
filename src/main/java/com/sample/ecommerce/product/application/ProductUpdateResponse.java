package com.sample.ecommerce.product.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "물품 수정 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateResponse {

    @Schema(description = "물품 ID")
    Long productId;

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
