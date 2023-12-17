package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "주문")
public class OrderDto {

    @Schema(description = "주문 ID")
    Long orderId;

    @Schema(description = "유저 ID")
    String userId;

    @Schema(description = "주문 금액")
    Long orderAmount;

    @Schema(description = "주문 시각")
    LocalDateTime orderAt;

    @Schema(description = "주문 주소")
    String orderAddress;

    @Schema(description = "주문 상태")
    OrderStatus orderStatus;
}
