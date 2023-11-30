package com.example.multipledatabase.service;

import com.example.multipledatabase.model.PageDTO;
import com.example.multipledatabase.model.SortDTO;
import com.example.multipledatabase.model.payment.model.Payment;
import org.springframework.data.domain.Page;

public interface PaymentService {

    Page<Payment> findAll(PageDTO page, SortDTO sort);

    Payment add(Payment payment);
    Payment update(Payment payment);
    Boolean delete(Long Id);
}
