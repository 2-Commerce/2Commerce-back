package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "주문 물품")
public class OrderProductDto {

    @Schema(description = "주문 물품 ID")
    Long orderProductId;

    @Schema(description = "주문 ID")
    Long orderId;

    @Schema(description = "주문 수량")
    Long orderQuantity;

    @Schema(description = "가게 ID")
    Long storeId;

    @Schema(description = "가게 이름")
    String storeName;

    @Schema(description = "가게 계좌 번호")
    String storeAccountNumber;

    @Schema(description = "물품 ID")
    Long productId;

    @Schema(description = "물품 이름")
    String productName;

    @Schema(description = "물품 카테고리")
    String productCategory;

    @Schema(description = "물품 가격")
    Long productPrice;

    @Schema(description = "주문 물품 상태")
    OrderStatus orderProductStatus;

    public OrderProductGetResponse toGetResponse() {
        return new OrderProductGetResponse(this.orderProductId, this.orderQuantity, this.productId, this.productName, this.productPrice, this.orderProductStatus);
    }

    public OrderProductDeliveryResponse toDeliveryResponse() {
        return new OrderProductDeliveryResponse(this.orderProductId, this.orderProductStatus);
    }
}
