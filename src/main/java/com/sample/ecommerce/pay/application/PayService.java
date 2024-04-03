package com.sample.ecommerce.pay.application;

import com.sample.ecommerce.order.application.OrderService;
import com.sample.ecommerce.pay.domain.PayTransaction;
import com.sample.ecommerce.pay.domain.PayTransactionRepository;
import com.sample.ecommerce.user.application.UserService;
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

    PayTransactionRepository payTransactionRepository;

    UserService userService;
    OrderService orderService;

    public PayTransactionDto registerPay(PayRegisterRequest payRegisterRequest) throws IllegalAccessException {
        final User user = userService.getUser(payRegisterRequest.getUserId());
        final PayTransaction payTransaction = payTransactionRepository.save(new PayTransaction(payRegisterRequest, orderService.payOrder(payRegisterRequest), user));
        return payTransaction.toDto();
    }
}
