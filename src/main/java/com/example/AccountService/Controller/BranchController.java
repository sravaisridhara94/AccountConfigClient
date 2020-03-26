package com.example.AccountService.Controller;

import com.example.AccountService.Model.BranchModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/branch")
@Api(value = "BranchController", description = "REST APIs related to Branch Service")
public class BranchController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/getAll")
    public ResponseEntity<List<BranchModel>> getAllBranches(){
        List<BranchModel> model = new ArrayList<>();
        // Implementation
        return ResponseEntity.ok().body(model);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/{branchId}")
    public ResponseEntity<BranchModel> getByBranchId(@ApiParam @PathVariable long branchId){
        // Implementation
        return ResponseEntity.ok().body(new BranchModel());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/addOrUpdate")
    public ResponseEntity<BranchModel> addOrUpdate(@RequestBody BranchModel model){
        // Implementation
        return ResponseEntity.ok().body(new BranchModel());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("/{branchId}")
    public ResponseEntity<BranchModel> deleteBranch(@PathVariable long branchId){
        // Implementation
        return ResponseEntity.ok().build();
    }
}