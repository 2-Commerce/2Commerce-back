package com.sample.ecommerce.order.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Schema(description = "가게 주문 확인 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInStoreResponse {

    @Schema(description = "주문 응답 리스트")
    List<OrderProductGetResponse> orderProductList;
}
