package com.example.accountservice.controller;

import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.AccountConstants;
import com.example.accountservice.helper.AccountMapper;
import com.example.accountservice.helper.AccountServiceRestCalls;
import com.example.accountservice.helper.CustomerAccountMapperEntity;
import com.example.accountservice.model.AccountModel;
import com.example.accountservice.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Account Service Controller
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@RestController
@RequestMapping("/v1/accounts")
@RefreshScope
@Api(value = "AccountServiceController")
public class AccountServiceController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountServiceRestCalls mapper;

    public AccountServiceController(AccountService service, AccountServiceRestCalls mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Autowired
    public AccountServiceController(AccountService service) {
        this.service = service;
    }

    @ApiResponses(value = {
            @ApiResponse(code = AccountConstants.SUCCESS, message = AccountConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_AUTHORIZED, message = AccountConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = AccountConstants.FORBIDDEN, message = AccountConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_FOUND, message = AccountConstants.NOT_FOUND_MESSAGE) })
    @GetMapping
    public ResponseEntity<List<AccountModel>> fetchAccounts(){
        List<AccountModel> accounts = service.getAccounts().stream().map(o->AccountMapper.toModel(o))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(accounts);
    }

    @ApiResponses(value = {
            @ApiResponse(code = AccountConstants.SUCCESS, message = AccountConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_AUTHORIZED, message = AccountConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = AccountConstants.FORBIDDEN, message = AccountConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_FOUND, message = AccountConstants.NOT_FOUND_MESSAGE) })
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountModel> fetchAccountId(@ApiParam @PathVariable long accountId){
        Optional<Account> account = service.getAccountById(accountId);
        if (!account.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(AccountMapper.toModel(account.get()));
    }

    @ApiResponses(value = {
            @ApiResponse(code = AccountConstants.SUCCESS, message = AccountConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_AUTHORIZED, message = AccountConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = AccountConstants.FORBIDDEN, message = AccountConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_FOUND, message = AccountConstants.NOT_FOUND_MESSAGE) })
    @PostMapping
    public ResponseEntity<AccountModel> addOrUpdateAccount(@RequestBody AccountModel model){
        Optional<Account> account = service.getAccountById(model.getAccountId());
        if(account.isPresent()){
            AccountMapper.merge(model, account.get());
            return ResponseEntity.ok(AccountMapper.toModel(service.saveAccount(account.get())));
        }else{
            AccountMapper.toModel(service.saveAccount(AccountMapper.toEntity(model)));
            return ResponseEntity.ok().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = AccountConstants.SUCCESS, message = AccountConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_AUTHORIZED, message = AccountConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = AccountConstants.FORBIDDEN, message = AccountConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_FOUND, message = AccountConstants.NOT_FOUND_MESSAGE) })
    @DeleteMapping("/{accountId}")
    public ResponseEntity<AccountModel> deleteAccount(@PathVariable long accountId){
        Optional<Account> account = service.getAccountById(accountId);
        if(!account.isPresent()){
            ResponseEntity.notFound().build();
        }
        service.deleteAccount(accountId);
        return ResponseEntity.ok().build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = AccountConstants.SUCCESS, message = AccountConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_AUTHORIZED, message = AccountConstants.NOT_AUTHORIZED_MESSAGE),
            @ApiResponse(code = AccountConstants.FORBIDDEN, message = AccountConstants.FORBIDDEN_MESSAGE),
            @ApiResponse(code = AccountConstants.NOT_FOUND, message = AccountConstants.NOT_FOUND_MESSAGE) })
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerAccountMapperEntity> fetchCustomerId(@ApiParam @PathVariable long customerId){
        Optional<Account> account = service.getAccountById(customerId);
        if (!account.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mapper.getCustomerById(customerId));
    }

}
