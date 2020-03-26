package com.example.AccountService.Controller;

import com.example.AccountService.Model.AccountModel;
import com.example.AccountService.Model.BranchModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
@Api(value = "AccountServiceController", description = "REST APIs related to Account Service")
public class AccountServiceController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/getAll")
    public ResponseEntity<List<AccountModel>> getAllAccounts(){
        List<AccountModel> model = new ArrayList<>();
        // Implementation
        return ResponseEntity.ok().body(model);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountModel> getByAccountId(@ApiParam @PathVariable long accountId){
        // Implementation
        return ResponseEntity.ok().body(new AccountModel());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/addOrUpdate")
    public ResponseEntity<AccountModel> addOrUpdate(@RequestBody AccountModel model){
        // Implementation
        return ResponseEntity.ok().body(new AccountModel());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("/{accountId}")
    public ResponseEntity<AccountModel> deleteAccount(@PathVariable long accountId){
        // Implementation
        return ResponseEntity.ok().build();
    }

}