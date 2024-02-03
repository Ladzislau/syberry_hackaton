package com.team.syberry.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "AlfaBankApiClient", url = "https://developerhub.alfabank.by:8273/partner/1.0.0")
public interface IAlfaBankApiClient {

    @GetMapping("/public/rates")
    List<CurrencyDto> getCurrenciesList();

    @GetMapping("/public/nationalRates")
    public CurrencyRateDto getCurrencyRate(@RequestParam String currencyCode,
                                           @RequestParam LocalDate date);

}
