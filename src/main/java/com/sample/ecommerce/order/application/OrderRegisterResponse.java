package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "주문 등록 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRegisterResponse {

    @Schema(description = "주문 ID")
    private Long orderId;
}
