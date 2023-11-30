package com.example.multipledatabase.controller;

import com.example.multipledatabase.dto.PaymentParam;
import com.example.multipledatabase.dto.RequestDTO;
import com.example.multipledatabase.dto.ResponseBuilderDTO;
import com.example.multipledatabase.dto.ResponseDTO;
import com.example.multipledatabase.model.payment.model.Payment;
import com.example.multipledatabase.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@Log4j2
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    ResponseBuilderDTO builderDTO;

    @PostMapping("/list")
    public ResponseDTO<Page<Payment>> findAll(@RequestBody RequestDTO<PaymentParam> request) {
//        PaymentParam param = request.getRequestParam();
        var result = paymentService.findAll(request.getPage(), request.getSorting());
        return builderDTO.success(result);
    }

    @PostMapping("/add")
    public ResponseDTO<Payment> add(@RequestBody RequestDTO<PaymentParam> request) {
        try {
            PaymentParam param = request.getParam();
            Payment _param = param.getPayment();
            var result = paymentService.add(_param);
            return builderDTO.success(result);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
