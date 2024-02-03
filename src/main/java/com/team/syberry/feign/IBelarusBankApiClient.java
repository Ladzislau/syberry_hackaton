package com.team.syberry.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "BelarusBankApiClient", url = "https://belarusbank.by/api/kurs_cards")
public interface IBelarusBankApiClient {

    @GetMapping()
    List<CurrencyDto> getCurrenciesList();

}
