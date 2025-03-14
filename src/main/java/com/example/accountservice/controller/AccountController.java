package com.example.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.dto.PaymentDto;
import com.example.accountservice.dto.PaymentResponseDto;
import com.example.accountservice.service.AccountServiceImpl;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@GetMapping("/health")
	public String health() {
		return "Hello there! AccountController is up and running!";
	}
	
	@PostMapping("/create")
	public AccountDto create(@RequestBody AccountDto accountDto) throws Exception {
		
		return accountServiceImpl.create(accountDto);
	}
	
	
}
