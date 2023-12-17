package com.sample.ecommerce.order.domain;

import com.sample.ecommerce.order.application.OrderDto;
import com.sample.ecommerce.order.application.OrderRegisterRequest;
import com.sample.ecommerce.order.application.OrderStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "`order`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String userId;

    private Long orderAmount;

    private LocalDateTime orderAt;

    private String orderAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order(OrderRegisterRequest request, Long orderAmount) {
        this.userId = request.getUserId();
        this.orderAmount = orderAmount;
        this.orderAt = LocalDateTime.now();
        this.orderAddress = request.getOrderAddress();
        this.orderStatus = OrderStatus.PENDING;
    }

    public OrderDto toDto() { return new OrderDto(orderId, userId, orderAmount, orderAt, orderAddress, orderStatus); }
}
