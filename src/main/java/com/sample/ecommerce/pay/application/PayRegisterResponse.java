package com.sample.ecommerce.pay.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "결제 등록 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayRegisterResponse {

    @Schema(description = "결제 트랜잭션 ID")
    private Long payTransactionId;
}
