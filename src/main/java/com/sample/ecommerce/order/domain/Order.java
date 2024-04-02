package com.sample.ecommerce.order.domain;

import com.sample.ecommerce.order.application.OrderDto;
import com.sample.ecommerce.order.application.OrderRegisterRequest;
import com.sample.ecommerce.order.application.OrderStatus;
import com.sample.ecommerce.pay.application.PayRegisterRequest;
import com.sample.ecommerce.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`order`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private User user;

    private Long orderAmount;

    private LocalDateTime orderAt;

    private String orderAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderProduct> orderProductList;

    public Order(OrderRegisterRequest request, Long orderAmount, User user) {
        this.orderAmount = orderAmount;
        this.orderAt = LocalDateTime.now();
        this.orderAddress = request.getOrderAddress();
        this.orderStatus = OrderStatus.PENDING;
    }

    public OrderDto toDto() { return new OrderDto(orderId, user.getUserId(), orderAmount, orderAt, orderAddress, orderStatus); }

    public void pay(PayRegisterRequest payRegisterRequest) {
        if (!payRegisterRequest.getUserId().equals(this.user.getUserId())) throw new IllegalArgumentException("User IDs do not match");
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

    public void completeDelivery() {
        if (this.orderStatus == OrderStatus.PENDING) throw new IllegalArgumentException("This order product has not been paid yet.");
        if (this.orderStatus == OrderStatus.PROCESSING) throw new IllegalArgumentException("This order product has not been dispatched yet.");
        if (this.orderStatus == OrderStatus.DELIVERED) throw new IllegalArgumentException("This order product has already been delivered.");
        if (this.orderStatus == OrderStatus.CANCELED) throw new IllegalArgumentException("This order product has been canceled.");
        boolean allProductsDelivered = orderProductList.stream()
                .allMatch(orderProduct -> orderProduct.getOrderProductStatus() == OrderStatus.DELIVERED);
        if (allProductsDelivered) this.orderStatus = OrderStatus.DELIVERED;
    }

}
