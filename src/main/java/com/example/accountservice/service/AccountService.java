package com.example.accountservice.service;

import com.example.accountservice.domain.ArithmeticOperation;
import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.Payment;

public interface AccountService {
	
	AccountDto create(AccountDto accountDto);
	void updateAccountBalance(Payment payment, ArithmeticOperation ops);
	Account getAccountBalance(String accountNumber);
	Account findAccount(String accountNumber);
	
}
