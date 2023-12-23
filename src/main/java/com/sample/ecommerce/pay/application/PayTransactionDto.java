package com.sample.ecommerce.pay.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "주문 트랜잭션")
public class PayTransactionDto {

    @Schema(description = "주문 트랜잭션 ID")
    private Long payTransactionId;

    @Schema(description = "유저 ID")
    private String userId;

    @Schema(description = "결제 금액")
    private Long payAmount;

    @Schema(description = "결제 시각")
    private LocalDateTime payAt;

    @Schema(description = "결제 타입")
    private PaymentType paymentType;

    @Schema(description = "결제 수단 이름")
    private String paymentName;

    @Schema(description = "계좌 번호")
    private String accountNumber;

    @Schema(description = "카드 번호")
    private String cardNumber;

}
