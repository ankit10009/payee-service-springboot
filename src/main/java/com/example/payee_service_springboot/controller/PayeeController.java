package com.example.payee_service_springboot.controller;

import com.example.payee_service_springboot.entity.Payee;
import com.example.payee_service_springboot.service.PayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payees")
public class PayeeController {

    @Autowired
    private PayeeService payeeService;

    @PostMapping
    public ResponseEntity<Payee> addPayee(@RequestBody Payee payee) {
        return new ResponseEntity<>(payeeService.addPayee(payee), HttpStatus.CREATED);
    }

    @PutMapping("/{payeeId}")
    public ResponseEntity<Payee> updatePayee(@PathVariable Long payeeId, @RequestBody Payee payee) {
        return new ResponseEntity<>(payeeService.updatePayee(payeeId, payee), HttpStatus.OK);
    }

    @DeleteMapping("/{payeeId}")
    public ResponseEntity<Void> deletePayee(@PathVariable Long payeeId) {
        payeeService.deletePayee(payeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{payeeId}")
    public ResponseEntity<Payee> getPayeeById(@PathVariable Long payeeId) {
        return new ResponseEntity<>(payeeService.getPayeeById(payeeId), HttpStatus.OK);
    }
}
