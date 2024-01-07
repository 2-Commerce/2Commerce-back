package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "주문 취소 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDeliveryRequest {

    @Schema(description = "주문 물품 ID")
    private Long orderProductId;
}
