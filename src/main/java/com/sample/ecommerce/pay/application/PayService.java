package com.sample.ecommerce.pay.application;

import com.sample.ecommerce.order.application.OrderService;
import com.sample.ecommerce.pay.domain.PayTransaction;
import com.sample.ecommerce.pay.domain.PayTransactionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PayService {

    OrderService orderService;

    PayTransactionRepository payTransactionRepository;

    public PayTransactionDto registerPay(PayRegisterRequest payRegisterRequest) throws IllegalAccessException {
        final PayTransaction payTransaction = payTransactionRepository.save(new PayTransaction(payRegisterRequest, orderService.payOrder(payRegisterRequest)));
        return payTransaction.toDto();
    }
}
