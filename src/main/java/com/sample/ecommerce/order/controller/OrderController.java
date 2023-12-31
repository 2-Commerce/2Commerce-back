package com.sample.ecommerce.order.controller;

import com.sample.ecommerce.order.application.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "장바구니로 주문을 등록한다.")
    @PostMapping("/api/order")
    public OrderRegisterResponse registerOrder(@RequestBody OrderRegisterRequest orderRegisterRequest) {
        return new OrderRegisterResponse(orderService.registerOrder(orderRegisterRequest).getOrderId());
    }

    @Operation(summary = "주문을 확인한다.")
    @GetMapping("/api/order")
    public OrderGetResponse getOrder(OrderGetRequest orderGetRequest) {
        return orderService.getOrder(orderGetRequest);
    }

    @Operation(summary = "주문을 취소한다.")
    @PatchMapping("/api/order/{orderId}/cancel")
    public OrderCancelResponse cancelOrder(@PathVariable("orderId") Long orderId) {
        return orderService.cancelOrder(orderId);
    }

    @Operation(summary = "가게 주문을 확인한다.")
    @GetMapping("/api/{storeId}/order")
    public OrderInStoreResponse getOrderInStore(@PathVariable("storeId") Long storeId) {
        return new OrderInStoreResponse(orderService.getOrderInStore(storeId));
    }

    @Operation(summary = "가게 주문 물품을 배송한다.")
    @PatchMapping("/api/order/product/startDelivery")
    public OrderProductDeliveryResponse startDeliveryOrderProduct(@RequestBody OrderProductDeliveryRequest orderProductDeliveryRequest) {
        return orderService.startDeliveryOrderProduct(orderProductDeliveryRequest);
    }

    @Operation(summary = "가게 주문 물품의 배송을 완료한다.")
    @PatchMapping("/api/order/product/completeDelivery")
    public OrderProductDeliveryResponse completeDeliveryOrderProduct(@RequestBody OrderProductDeliveryRequest orderProductDeliveryRequest) {
        return orderService.completeDelivery(orderProductDeliveryRequest);
    }
}
