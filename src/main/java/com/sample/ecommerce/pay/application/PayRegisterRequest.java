package com.sample.ecommerce.pay.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "결제 등록 요청")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayRegisterRequest {

    @Schema(description = "주문 ID")
    private Long orderId;

    @Schema(description = "유저 ID")
    private String userId;

    @Schema(description = "결제 금액")
    private Long payAmount;

    @Schema(description = "결제 타입")
    private PaymentType paymentType;

    @Schema(description = "결제 이름")
    private String paymentName;

    @Schema(description = "계좌 번호")
    private String accountNumber;

    @Schema(description = "카드 번호")
    private String cardNumber;
}
