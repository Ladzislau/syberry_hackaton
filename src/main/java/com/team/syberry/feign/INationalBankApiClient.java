package com.team.syberry.feign;

import com.team.syberry.domain.nationalbank.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Component
@FeignClient(name = "NationalBankApiClient", url = "https://api.nbrb.by")
public interface INationalBankApiClient {

    @GetMapping("/exrates/currencies")
    List<CurrencyNationalBank> getCurrenciesList();

    @GetMapping("/exrates/rates/{cur_id}")
    RateNationalBank getCurrencyRate(@PathVariable(name = "cur_id") String currencyCode,
                                            @RequestParam(name = "ondate", required = false) LocalDate date,
                                            @RequestParam(name = "periodicity", defaultValue = "0") Integer periodicity,
                                            @RequestParam(name = "parammode", defaultValue = "0") String paramMode);

    @GetMapping("/exrates/rates/dynamics/{cur_id}")
    List<RateShortNationalBank> getCurrencyRateForPeriod(@PathVariable(name = "cur_id") String currencyCode,
                                                                @RequestParam(name = "startdate", required = false) LocalDate from,
                                                                @RequestParam(name = "enddate", required = false) LocalDate to);
}
