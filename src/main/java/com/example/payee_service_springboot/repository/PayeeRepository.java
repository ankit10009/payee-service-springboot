package com.example.payee_service_springboot.repository;

import com.example.payee_service_springboot.entity.Payee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {
}
