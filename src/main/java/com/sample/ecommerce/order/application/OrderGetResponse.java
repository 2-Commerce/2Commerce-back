package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Schema(description = "주문 내역 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderGetResponse {
    
    @Schema(description = "주문 물품 리스트")
    private List<OrderProductGetResponse> productList;

    @Schema(description = "주문 금액")
    private long orderAmount;

    @Schema(description = "주문 상태")
    private OrderStatus orderStatus;

    public OrderGetResponse(OrderDto orderDto, List<OrderProductGetResponse> orderProductList) {
        this.orderAmount = orderDto.getOrderAmount();
        this.orderStatus = orderDto.getOrderStatus();
        this.productList = orderProductList;
    }
}
