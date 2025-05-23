package com.example.bank_transfer.service;

import com.example.bank_transfer.exception.AccountNotFoundException;
import com.example.bank_transfer.exception.InsufficientFundsException;
import com.example.bank_transfer.model.Account;
import com.example.bank_transfer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(Long sourceId, Long targetId, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive");

        Account source = accountRepository.findById(sourceId)
                .orElseThrow(() -> new AccountNotFoundException("Source account not found"));

        Account target = accountRepository.findById(targetId)
                .orElseThrow(() -> new AccountNotFoundException("Target account not found"));

        if (source.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient balance in source account");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        accountRepository.save(source);
        accountRepository.save(target);
    }
}
