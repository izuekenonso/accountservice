package com.example.accountservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountservice.domain.ArithmeticOperation;
import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.Payment;
import com.example.accountservice.mapper.AccountMapper;
import com.example.accountservice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	private Account account;
	
	private AccountDto accountDto;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public AccountDto create(AccountDto accountDto) {
		
		Account account = AccountMapper.dtoToAccount(accountDto);
		Account result = accountRepository.save(account);
		
		return AccountMapper.accountToDto(result);
	}
	
	@Override
	public void updateAccountBalance(Payment payment, ArithmeticOperation ops) {

		double newBalance = processPayment(payment, ops);
		
 		account.setBalance(newBalance);
	}

	private double processPayment(Payment payment,  ArithmeticOperation ops) {
		
		double newBalance = 0.0;
		
		switch(payment.getPaymentType()) {
			case DEPOSIT: 			
				newBalance = creditOps(payment);
			break;
			case WITHDRAWAL: 
				newBalance = debitOps(payment);
			break;
			case TRANSFER: 
				if(ops == ArithmeticOperation.CREDIT) newBalance = creditOps(payment);
				if(ops == ArithmeticOperation.DEBIT) newBalance = debitOps(payment);
			break;
			default:
				newBalance = 0.0;
			break;
		}
		
		return newBalance;
		
	}

	private double debitOps(Payment payment) {
		
		accountDto = findAccount(payment.getDebitAccount());
		account = AccountMapper.dtoToAccount(accountDto);
		double debit = account.getBalance() - payment.getAmount();
		
		Account result = accountRepository.findByAccountNumber(payment.getDebitAccount());
		result.setBalance(debit);
		accountRepository.save(result);
		
		return debit;
	}

	private double creditOps(Payment payment) {
		
		accountDto = findAccount(payment.getCreditAccount());
		account = AccountMapper.dtoToAccount(accountDto);
		
		double credit = account.getBalance() + payment.getAmount();
		
		Account result = accountRepository.findByAccountNumber(payment.getCreditAccount());
		result.setBalance(credit);
		accountRepository.save(result);
		
		return credit;
	}

	@Override
	public Account getAccountBalance(String accountNumber) {
		
		accountDto = findAccount(accountNumber);
		account = AccountMapper.dtoToAccount(accountDto);
		return account;
	}

	@Override
	public AccountDto findAccount(String accountNumber) {
		
		account = accountRepository.findByAccountNumber(accountNumber);
		accountDto = AccountMapper.accountToDto(account);
		return accountDto;
	}

}
