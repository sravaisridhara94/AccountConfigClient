package com.example.AccountService.Controller;

import com.example.AccountService.Model.AccountHolderModel;
import com.example.AccountService.Model.BranchModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accountHolders")
@Api(value = "AccountHolderController")
public class AccountHolderController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping
    public ResponseEntity<List<AccountHolderModel>> getAllAccountHolders(){
        List<AccountHolderModel> model = new ArrayList<>();
        // Implementation
        return ResponseEntity.ok().body(model);
    }
}
