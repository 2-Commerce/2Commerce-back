package com.sample.ecommerce.pay.domain;

import com.sample.ecommerce.order.application.OrderDto;
import com.sample.ecommerce.order.domain.Order;
import com.sample.ecommerce.pay.application.PayRegisterRequest;
import com.sample.ecommerce.pay.application.PayTransactionDto;
import com.sample.ecommerce.pay.application.PaymentType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "`pay_transaction`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PayTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payTransactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private String userId;

    private Long payAmount;

    private LocalDateTime payAt;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private String paymentName;

    private String accountNumber;

    private String cardNumber;

    public PayTransaction(PayRegisterRequest payRegisterRequest, Order order) throws IllegalAccessException {
        if(!payRegisterRequest.getUserId().equals(order.getUserId())) throw new IllegalAccessException("User ID's not match");
        if(!Objects.equals(payRegisterRequest.getPayAmount(), order.getOrderAmount())) throw new IllegalAccessException("Payment amount does not match the order amount");
        this.userId = payRegisterRequest.getUserId();
        this.payAmount = payRegisterRequest.getPayAmount();
        this.payAt = LocalDateTime.now();
        this.paymentType = payRegisterRequest.getPaymentType();
        this.paymentName = payRegisterRequest.getPaymentName();
        this.accountNumber = payRegisterRequest.getAccountNumber();
        this.cardNumber = payRegisterRequest.getCardNumber();
        this.order = order;
    }

    public PayTransactionDto toDto() { return new PayTransactionDto(payTransactionId, userId, payAmount, payAt, paymentType, paymentName, accountNumber, cardNumber); }
}
