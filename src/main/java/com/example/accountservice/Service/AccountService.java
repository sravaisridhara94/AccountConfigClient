package com.example.accountservice.service;

import com.example.accountservice.entity.Account;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Account Service
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@Service
@Transactional
public class AccountService {

    private AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account saveAccount(Account account){
        return repository.saveAndFlush(account);
    }

    public Optional<Account> getAccountById(long accountId){
        return repository.findById(accountId);
    }

    public List<Account> getAccounts(){
        return repository.findAll();
    }

    public void deleteAccount(long accountId){
        repository.deleteById(accountId);
    }
}
