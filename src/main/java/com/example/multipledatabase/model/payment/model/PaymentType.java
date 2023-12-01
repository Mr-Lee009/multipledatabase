package com.example.multipledatabase.model.payment.model;

public enum PaymentType {
    ELECTRONIC_WALLET("electronic_wallet"),
    CASH("cash"),
    DEBIT_CARDS("debit_cards"),
    CHECK("checks"),
    CREDIT_CARDS("credit_cards");
    private String value;

    PaymentType(String value) {
        this.value = value;
    }
}
