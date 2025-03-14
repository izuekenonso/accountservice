package com.example.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accountservice.dto.PaymentDto;
import com.example.accountservice.dto.PaymentResponseDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.service.PaymentServiceImpl;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@GetMapping("/health")
	public String health() {
		return "Hello there! PaymentController is up and running!";
	}
	
	@PostMapping("/deposit")
	public PaymentResponseDto deposit(@RequestBody PaymentDto paymentDto) throws Exception {
		
		return paymentServiceImpl.deposit(paymentDto);
	}
	
	@PostMapping("/withdrawal")
	public PaymentResponseDto withdrawal(@RequestBody PaymentDto paymentDto) throws Exception {
		
		return paymentServiceImpl.withdrawal(paymentDto);
	}
	
	@PostMapping("/transfer")
	public PaymentResponseDto transfer(@RequestBody PaymentDto paymentDto) throws Exception {
		
		return paymentServiceImpl.transfer(paymentDto);
	}
}
