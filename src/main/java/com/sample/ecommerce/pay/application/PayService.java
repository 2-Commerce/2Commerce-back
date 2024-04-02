package com.sample.ecommerce.pay.application;

import com.sample.ecommerce.order.application.OrderService;
import com.sample.ecommerce.pay.domain.PayTransaction;
import com.sample.ecommerce.pay.domain.PayTransactionRepository;
import com.sample.ecommerce.user.domain.User;
import com.sample.ecommerce.user.domain.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PayService {

    OrderService orderService;

    UserRepository userRepository;

    PayTransactionRepository payTransactionRepository;

    public PayTransactionDto registerPay(PayRegisterRequest payRegisterRequest) throws IllegalAccessException {
        User user = userRepository.findByUserId(payRegisterRequest.getUserId()).orElseThrow();
        final PayTransaction payTransaction = payTransactionRepository.save(new PayTransaction(payRegisterRequest, orderService.payOrder(payRegisterRequest), user));
        return payTransaction.toDto();
    }
}
