package com.team.syberry.controller;

import com.team.syberry.service.EBank;
import com.team.syberry.service.api.IBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final Map<String, IBankService> bankServiceMap;

    @GetMapping
    public ResponseEntity<?> getBanks(){
        List<String> banks = Arrays.stream(EBank.values())
                    .map(EBank::getValue)
                    .toList();

        return ResponseEntity.ok(banks);
    }

    @GetMapping(value = "/{bankName}/currencies")
    public ResponseEntity<?> getCurrencies(@PathVariable("bankName") String bankName) {
        IBankService bankService = bankServiceMap.get(bankName);
        List<String> currencies = bankService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

}
