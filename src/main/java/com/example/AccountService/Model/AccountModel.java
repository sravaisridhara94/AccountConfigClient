package com.example.AccountService.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class AccountModel {

    @JsonProperty
    private long accountId;
    @JsonProperty
    private String accountType;
    @JsonProperty
    private long accountHolderID;
    @JsonProperty
    private String accountCreationDate;
    @JsonProperty
    private String accountCreationBranchId;


    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(String accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public String getAccountCreationBranchId() {
        return accountCreationBranchId;
    }

    public void setAccountCreationBranchId(String accountCreationBranchId) {
        this.accountCreationBranchId = accountCreationBranchId;
    }

    public long getAccountHolderID() {
        return accountHolderID;
    }

    public void setAccountHolderID(long accountHolderID) {
        this.accountHolderID = accountHolderID;
    }
}
