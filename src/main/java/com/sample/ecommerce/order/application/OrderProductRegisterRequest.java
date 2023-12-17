package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductRegisterRequest {

    @Schema(description = "물품 ID")
    private Long productId;

    @Schema(description = "물품 주문 수량")
    private Long productOrderQuantity;
}
