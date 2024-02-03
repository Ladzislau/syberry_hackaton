package com.team.syberry.controller;

import com.team.syberry.service.api.IBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/banks")
public class BankController {

    private final IBankService bankService;

    public BankController(IBankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public ResponseEntity<?> getBanks(){
        return new ResponseEntity<>(bankService.getAllBanks(), HttpStatus.OK);
    }

    @GetMapping(value = "/{bankName}/currencies")
    public ResponseEntity<?> getCurrencies(@PathVariable String bankName){
        return new ResponseEntity<>(bankService.getAllCurrencies(), HttpStatus.OK);
    }


}
