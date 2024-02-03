package com.team.syberry.controller;


import com.team.syberry.dto.response.RateDto;
import com.team.syberry.service.api.IBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class RateController {

    public final Map<String, IBankService> bankServiceMap;

    @GetMapping()
    public ResponseEntity<?> getCurrencyRate(@RequestParam("bank") String bank,
                                             @RequestParam("currencyCode") String currencyCode,
                                             @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        IBankService bankService = bankServiceMap.get(bank);

        RateDto currencyRate = bankService.getCurrencyRateForDate(currencyCode, date);
        return ResponseEntity.ok(currencyRate);
    }

    @GetMapping("/rates")
    public ResponseEntity<?> getCurrencyRates(@RequestParam("bank") String bank,
                                             @RequestParam("currencyCode") String currencyCode,
                                             @RequestParam("from") LocalDate from,
                                              @RequestParam("to") LocalDate to){
        IBankService bankService = bankServiceMap.get(bank);

        List<RateDto> currencyRates = bankService.getCurrencyRateForPeriod(currencyCode, from, to);
        return ResponseEntity.ok(currencyRates);
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getStatistics(@RequestParam("bank") String bank,
                                           @RequestParam("currencyCode") String currencyCode,
                                           @RequestParam("from") LocalDate from,
                                           @RequestParam("to") LocalDate to){
        IBankService bankService = bankServiceMap.get(bank);

        byte[] statisticsInfo = bankService.getStatistics(currencyCode, from, to);
        return ResponseEntity.ok(statisticsInfo);
    }


}
