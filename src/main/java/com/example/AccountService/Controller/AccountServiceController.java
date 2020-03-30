package com.example.AccountService.Controller;

import com.example.AccountService.Model.AccountModel;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/accounts")
@Api(value = "AccountServiceController")
public class AccountServiceController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping
    public ResponseEntity<List<AccountModel>> fetchAccounts(){
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
    public ResponseEntity<AccountModel> fetchAccountId(@ApiParam @PathVariable long accountId){
        // Implementation
        return ResponseEntity.ok().body(new AccountModel());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping
    public ResponseEntity<AccountModel> addOrUpdateAccount(@RequestBody AccountModel model){
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
