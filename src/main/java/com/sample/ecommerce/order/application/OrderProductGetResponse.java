package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "주문 물품 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductGetResponse {

    @Schema(description = "주문 물품 ID")
    Long orderProductId;

    @Schema(description = "주문 수량")
    Long orderQuantity;

    @Schema(description = "물품 ID")
    Long productId;

    @Schema(description = "물품 이름")
    String productName;

    @Schema(description = "물품 가격")
    Long productPrice;

    @Schema(description = "물품 상태")
    OrderStatus orderProductStatus;
}
