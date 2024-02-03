package com.team.syberry.feign;

import com.team.syberry.domain.alfabank.NationalRatesAlfaBank;
import com.team.syberry.domain.alfabank.RateAlfaBank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "AlfaBankApiClient", url = "https://developerhub.alfabank.by:8273/partner/1.0.0")
public interface IAlfaBankApiClient {

    @GetMapping("/public/rates")
    List<RateAlfaBank> getCurrenciesList();

    @GetMapping("/public/nationalRates")
    NationalRatesAlfaBank getCurrencyRate(@RequestParam String currencyCode,
                                                 @RequestParam LocalDate date);

}
