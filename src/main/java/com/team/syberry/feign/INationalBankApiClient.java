package com.team.syberry.feign;

import com.team.syberry.domain.CurRateNatBank;
import com.team.syberry.domain.CurRateShortNatBank;
import com.team.syberry.domain.CurrencyNatBank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "NationalBankApiClient", url = "https://api.nbrb.by")
public interface INationalBankApiClient {

    @GetMapping("/exrates/currencies")
    List<CurrencyNatBank> getCurrenciesList();

    @GetMapping("/exrates/rates/{cur_id}")
    public CurRateNatBank getCurrencyRate(@PathVariable String currencyCode,
                                          @RequestParam LocalDate ondate);

    @GetMapping("/exrates/rates/dynamics/{cur_id}")
    public List<CurRateShortNatBank> getCurrencyRateForPeriod(@PathVariable String currencyCode,
                                                              @RequestParam LocalDate startDate,
                                                              @RequestParam  LocalDate endDate);

}
