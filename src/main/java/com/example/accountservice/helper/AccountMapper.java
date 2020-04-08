package com.example.accountservice.helper;

import com.example.accountservice.entity.Account;
import com.example.accountservice.model.AccountModel;

public class AccountMapper {

    public static Account toEntity(AccountModel model){
        Account account = new Account();
        account.setAccountHolderId(model.getAccountHolderId());
        account.setAccountType(model.getAccountType());
        account.setBalanceAvailable(model.getBalanceAvailable());
        account.setBranchId(model.getBranchId());
        account.setCreationDate(model.getCreationDate());
        account.setMinimumBalance(model.getMinimumBalance());
        return account;
    }

    public static AccountModel toModel(Account account){
        AccountModel model = new AccountModel();
        model.setAccountHolderId(account.getAccountHolderId());
        model.setAccountId(account.getAccountId());
        model.setAccountType(account.getAccountType());
        model.setBalanceAvailable(account.getBalanceAvailable());
        model.setBranchId(account.getBranchId());
        model.setCreationDate(account.getCreationDate());
        model.setMinimumBalance(account.getMinimumBalance());
        return model;
    }

    public static void merge(AccountModel model, Account entity) {
        entity.setMinimumBalance(model.getMinimumBalance());
        entity.setCreationDate(model.getCreationDate());
        entity.setBranchId(model.getBranchId());
        entity.setBalanceAvailable(model.getBalanceAvailable());
        entity.setAccountType(model.getAccountType());
        entity.setAccountHolderId(model.getAccountHolderId());
    }

}
