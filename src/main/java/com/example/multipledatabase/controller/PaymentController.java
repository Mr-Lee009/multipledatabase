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

import java.util.UUID;

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
    public ResponseDTO<Object> add(@RequestBody RequestDTO<PaymentParam> request) {
        try {
            PaymentParam param = request.getParam();
            Payment _param = param.getPayment();
            if (_param == null) {
                throw new Exception("param is not null!");
            }
            _param.setOrderId(UUID.randomUUID().toString());
            var result = paymentService.add(_param);
            if (result == null) {
                return builderDTO.error(String.format("Save payment error!"));
            }
            return builderDTO.success(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return builderDTO.exception(String.format(e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseDTO<Object> update(@RequestBody RequestDTO<PaymentParam> request) {
        try {
            PaymentParam param = request.getParam();
            Payment _param = param.getPayment();
            if (_param == null) {
                throw new Exception("param is not null!");
            }
            if (_param.getId() == null) {
                throw new Exception("Id is not empty!");
            }
            var result = paymentService.update(_param);
            if (result == null) {
                return builderDTO.error(String.format("update payment [ID|%s] [ORDER_ID|%s] error!", _param.getId(), _param.getOrderId()));
            }
            return builderDTO.success(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return builderDTO.exception(String.format(e.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseDTO delete(@RequestBody RequestDTO<PaymentParam> request) {
        try {
            PaymentParam param = request.getParam();
            Payment _param = param.getPayment();
            var result = paymentService.delete(_param.getId());
            if (!result)
                return builderDTO.error(String.format("Delete payment %s fail!", _param.getId()));
            return builderDTO.success(String.format("Delete payment %s success!", _param.getId()));
        } catch (Exception e) {
            return builderDTO.exception(String.format(e.getMessage()));
        }
    }
}
