package com.team.syberry.feign;

import com.team.syberry.domain.belarusbank.RateBelarusBank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "BelarusBankApiClient", url = "https://belarusbank.by/api/kurs_cards")
public interface IBelarusBankApiClient {

    @GetMapping()
    List<RateBelarusBank> getCurrenciesList();

}
