package com.sample.ecommerce.order.controller;

import com.sample.ecommerce.order.application.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
