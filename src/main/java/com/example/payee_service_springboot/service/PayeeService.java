package com.example.payee_service_springboot.service;

import com.example.payee_service_springboot.entity.Payee;
import com.example.payee_service_springboot.repository.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayeeService {

    @Autowired
    private PayeeRepository payeeRepository;

    public Payee addPayee(Payee payee) {
        return payeeRepository.save(payee);
    }

    public Payee updatePayee(Long payeeId, Payee updatedPayee) {
        return payeeRepository.findById(payeeId)
                .map(payee -> {
                    payee.setPayeeName(updatedPayee.getPayeeName());
                    payee.setAccountNumber(updatedPayee.getAccountNumber());
                    payee.setAddress(updatedPayee.getAddress());
                    return payeeRepository.save(payee);
                })
                .orElseThrow(() -> new RuntimeException("Payee not found"));
    }

    public void deletePayee(Long payeeId) {
        payeeRepository.deleteById(payeeId);
    }

    public Payee getPayeeById(Long payeeId) {
        return payeeRepository.findById(payeeId)
                .orElseThrow(() -> new RuntimeException("Payee not found"));
    }
}