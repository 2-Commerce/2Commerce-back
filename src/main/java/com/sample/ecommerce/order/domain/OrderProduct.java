package com.sample.ecommerce.order.domain;

import com.sample.ecommerce.order.application.OrderDto;
import com.sample.ecommerce.order.application.OrderProductDto;
import com.sample.ecommerce.order.application.OrderStatus;
import com.sample.ecommerce.product.application.ProductWithStoreDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`order_product`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private Long orderQuantity;

    private Long storeId;

    private String storeName;

    private String storeAccountNumber;

    private Long productId;

    private String productName;

    private String productCategory;

    private Long productPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderProductStatus;

    public OrderProduct(OrderDto orderDto, ProductWithStoreDto productDto) {
        //this.orderId = orderDto.getOrderId();
        this.orderQuantity = productDto.getProductOrderQuantity();
        this.storeId = productDto.getStoreId();
        this.storeName = productDto.getStoreName();
        this.storeAccountNumber = productDto.getStoreAccountNumber();
        this.productId = productDto.getProductId();
        this.productName = productDto.getProductName();
        this.productCategory = productDto.getProductCategory();
        this.productPrice = productDto.getProductPrice();
        this.orderProductStatus = OrderStatus.PENDING;
    }

    public OrderProductDto toDto() { return new OrderProductDto(orderProductId, null, orderQuantity, storeId, storeName, storeAccountNumber, productId, productName, productCategory, productPrice, orderProductStatus); }

    public void pay() {
        if (this.orderProductStatus != OrderStatus.PENDING) throw new IllegalArgumentException("Order product has already been paid");
        this.orderProductStatus = OrderStatus.PROCESSING;
    }

    public void startDelivery() {
        if (this.orderProductStatus == OrderStatus.PENDING) throw new IllegalArgumentException("This order product has not been paid yet.");
        if (this.orderProductStatus == OrderStatus.SHIPPED) throw new IllegalArgumentException("This order product has already been dispatched.");
        if (this.orderProductStatus == OrderStatus.DELIVERED) throw new IllegalArgumentException("This order product has already been delivered.");
        if (this.orderProductStatus == OrderStatus.CANCELED) throw new IllegalArgumentException("This order product has been canceled.");
        this.orderProductStatus = OrderStatus.SHIPPED;
    }

    public void completeDelivery() {
        if (this.orderProductStatus == OrderStatus.PENDING) throw new IllegalArgumentException("This order product has not been paid yet.");
        if (this.orderProductStatus == OrderStatus.PROCESSING) throw new IllegalArgumentException("This order product has not been dispatched yet.");
        if (this.orderProductStatus == OrderStatus.DELIVERED) throw new IllegalArgumentException("This order product has already been delivered.");
        if (this.orderProductStatus == OrderStatus.CANCELED) throw new IllegalArgumentException("This order product has been canceled.");
        this.orderProductStatus = OrderStatus.DELIVERED;
    }
}
