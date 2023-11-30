package com.example.multipledatabase.model.payment.repo;

import com.example.multipledatabase.model.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
