package com.team.syberry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController(value = "/rate")
public class RateController {
    private IRateService rateService

    @GetMapping
    public ResponseEntity<?> getCurrencyRate(String bankName, String currencyCode, LocalDate date){
        return new ResponseEntity<>(, HttpStatus.OK);
    }
}
