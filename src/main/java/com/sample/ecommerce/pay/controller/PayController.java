package com.sample.ecommerce.pay.controller;

import com.sample.ecommerce.pay.application.PayRegisterRequest;
import com.sample.ecommerce.pay.application.PayRegisterResponse;
import com.sample.ecommerce.pay.application.PayService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PayController {

    private final PayService payService;

    @Operation(summary = "주문을 결제한다.")
    @PostMapping("/api/pay")
    public PayRegisterResponse registerPay(@RequestBody PayRegisterRequest payRegisterRequest) throws IllegalAccessException {
        return new PayRegisterResponse(payService.registerPay(payRegisterRequest).getPayTransactionId());
    }
}
