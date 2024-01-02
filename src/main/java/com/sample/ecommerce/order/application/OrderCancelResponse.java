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
public class OrderCancelResponse {

    @Schema(description = "주문 ID")
    private Long orderId;

    @Schema(description = "주문 상태")
    private OrderStatus orderStatus;

    public OrderCancelResponse(OrderDto orderDto) {
        this.orderId = orderDto.getOrderId();
        this.orderStatus = orderDto.getOrderStatus();
    }
}
