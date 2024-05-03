package com.example.accountservice.service;

import com.example.accountservice.dto.PaymentDto;
import com.example.accountservice.dto.PaymentResponseDto;

public interface PaymentService {
	
	PaymentResponseDto deposit(PaymentDto paymentDto) throws Exception;
	PaymentResponseDto withdrawal(PaymentDto paymentDto) throws Exception;
	PaymentResponseDto transfer(PaymentDto paymentDto) throws Exception;
	
}
