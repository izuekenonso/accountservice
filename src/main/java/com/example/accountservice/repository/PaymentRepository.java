package com.example.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.accountservice.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
