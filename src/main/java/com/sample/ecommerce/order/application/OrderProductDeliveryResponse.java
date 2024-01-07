package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "주문 물품 배송 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDeliveryResponse {

    @Schema(description = "주문 물품 ID")
    private Long orderProductId;

    @Schema(description = "주문 물품 상태")
    private OrderStatus orderProductStatus;
}
