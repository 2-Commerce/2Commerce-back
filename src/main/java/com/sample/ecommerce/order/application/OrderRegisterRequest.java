package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Schema(description = "주문 등록 요청")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRegisterRequest {

    @Schema(description = "유저 ID")
    private String userId;

    @Schema(description = "주문 주소")
    private String orderAddress;

    @Schema(description = "물품 리스트")
    private List<OrderProductRegisterRequest> productList;

}
