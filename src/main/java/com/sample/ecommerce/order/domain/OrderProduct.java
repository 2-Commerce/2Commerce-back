package com.sample.ecommerce.order.domain;

import com.sample.ecommerce.order.application.OrderDto;
import com.sample.ecommerce.order.application.OrderProductDto;
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

    private Long orderId;

    private Long orderQuantity;

    private Long storeId;

    private String storeName;

    private String storeAccountNumber;

    private Long productId;

    private String productName;

    private String productCategory;

    private Long productPrice;

    public OrderProduct(OrderDto orderDto, ProductWithStoreDto productDto) {
        this.orderId = orderDto.getOrderId();
        this.orderQuantity = productDto.getProductOrderQuantity();
        this.storeId = productDto.getStoreId();
        this.storeName = productDto.getStoreName();
        this.storeAccountNumber = productDto.getStoreAccountNumber();
        this.productId = productDto.getProductId();
        this.productName = productDto.getProductName();
        this.productCategory = productDto.getProductCategory();
        this.productPrice = productDto.getProductPrice();
    }

    public OrderProductDto toDto() { return new OrderProductDto(orderProductId, orderId, orderQuantity, storeId, storeName, storeAccountNumber, productId, productName, productCategory, productPrice); }
}
