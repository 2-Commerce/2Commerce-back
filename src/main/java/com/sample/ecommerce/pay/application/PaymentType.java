package com.sample.ecommerce.pay.application;

public enum PaymentType {

    ACCOUNT("계좌"),
    CARD("카드"),
    PAY("페이");

    private final String displayName;

    PaymentType(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return displayName; }
}
