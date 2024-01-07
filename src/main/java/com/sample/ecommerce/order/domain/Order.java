package com.sample.ecommerce.order.domain;

import com.sample.ecommerce.order.application.OrderDto;
import com.sample.ecommerce.order.application.OrderRegisterRequest;
import com.sample.ecommerce.order.application.OrderStatus;
import com.sample.ecommerce.pay.application.PayRegisterRequest;
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

    public void pay(PayRegisterRequest payRegisterRequest) {
        if (!payRegisterRequest.getUserId().equals(this.userId)) throw new IllegalArgumentException("User IDs do not match");
        if (this.orderStatus != OrderStatus.PENDING) throw new IllegalArgumentException("Order has already been paid");
        this.orderStatus = OrderStatus.PROCESSING;
    }

    public void cancel() {
        if (this.orderStatus != OrderStatus.PENDING) throw new IllegalArgumentException("The order cannot be canceled as it has already been processed.");
        this.orderStatus = OrderStatus.CANCELED;
    }

    public void startDelivery() {
        if (this.orderStatus == OrderStatus.PENDING) throw new IllegalArgumentException("This order has not been paid yet.");
        if (this.orderStatus == OrderStatus.DELIVERED) throw new IllegalArgumentException("This order has already been delivered.");
        if (this.orderStatus == OrderStatus.CANCELED) throw new IllegalArgumentException("This order has been canceled.");
        this.orderStatus = OrderStatus.SHIPPED;
    }

    public OrderDto toDto() { return new OrderDto(orderId, userId, orderAmount, orderAt, orderAddress, orderStatus); }

}
