package com.team.syberry.controller;

import com.team.syberry.service.api.IBankService;
import com.team.syberry.service.BankInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankInfoService bankInfoService;

    private final Map<String, IBankService> bankServiceMap;

    @GetMapping
    public ResponseEntity<?> getBanks(){
        List<String> banks = bankInfoService.getAllBanks();
        return ResponseEntity.ok(banks);
    }

    @GetMapping(value = "/{bankName}/currencies")
    public ResponseEntity<?> getCurrencies(@PathVariable("bankName") String bankName) {
        IBankService bankService = bankServiceMap.get(bankName);
        List<String> currencies = bankService.getAllCurrencies(bankName);
        return ResponseEntity.ok(currencies);
    }

}
