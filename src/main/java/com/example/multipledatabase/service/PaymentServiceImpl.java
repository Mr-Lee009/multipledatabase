package com.example.multipledatabase.service;

import com.example.multipledatabase.model.PageDTO;
import com.example.multipledatabase.model.SortDTO;
import com.example.multipledatabase.model.payment.model.Payment;
import com.example.multipledatabase.model.payment.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo repository;

    @Override
    public Page<Payment> findAll(PageDTO page, SortDTO sort) {

        Sort sorting;
        if (sort.isEmpty()) {
            sorting = null;
        } else sorting = Sort.by(sort.getDirection(), sort.getBy());

        Pageable paging;
        if (page == null) {
            paging = PageRequest.of(0, 10, sorting);
        } else paging = PageRequest.of(page.getPageNo(), page.getPageSize(), sorting);

        return repository.findAll(paging);
    }

    @Override
    public Payment add(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Boolean delete(Long Id) throws ClassNotFoundException {
        if (repository.findById(Id).isEmpty())
            throw new ClassNotFoundException("ko tim thay thang nay");
        else {
            repository.deleteById(Id);
            return true;
        }
    }
}
