package com.example.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.accountservice.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByAccountNumber(String accountNumber);

}
