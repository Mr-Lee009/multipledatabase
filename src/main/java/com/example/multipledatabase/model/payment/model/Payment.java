package com.example.multipledatabase.model.payment.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "string_amount")
    private String stringAmount;
    @Column(name = "order_info")
    private String orderInfo;
    @Column(name = "description")
    private String description;
    @Column(name = "signature")
    private String signature;

}
