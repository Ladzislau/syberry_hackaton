package com.team.syberry.service.implementation;

import com.team.syberry.domain.alfabank.NationalRatesAlfaBank;
import com.team.syberry.domain.alfabank.RateAlfaBank;
import com.team.syberry.dto.response.RateDto;
import com.team.syberry.dto.response.StatisticsInfo;
import com.team.syberry.feign.IAlfaBankApiClient;
import com.team.syberry.service.api.IBankService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service("alfaBankService")
public class AlfaBankService implements IBankService {

    private IAlfaBankApiClient bankApiClient;

    public AlfaBankService(IAlfaBankApiClient bankApiClient) {
        this.bankApiClient = bankApiClient;
    }

    @Override
    public List<String> getAllCurrencies() {
        List<String> resultlist = new ArrayList<>();
        List<RateAlfaBank> rateList = bankApiClient.getCurrenciesList();
        for(RateAlfaBank rate : rateList) {
            resultlist.add(rate.getName());
        }
        return resultlist;
    }

    @Override
    public RateDto getCurrencyRateToday(String currencyCode) {
        return getCurrencyRateForDate(currencyCode, LocalDate.now());
    }

    @Override
    public RateDto getCurrencyRateForDate(String currencyCode, LocalDate date) {
        NationalRatesAlfaBank rate = bankApiClient.getCurrencyRate(currencyCode, date);
        RateDto dto = new RateDto();
        dto.setDate(LocalDateTime.of(date, LocalTime.now()));
        dto.setBuyRate(rate.getRates().get(0).getRate());
        dto.setSellRate(null);
        return dto;
    }

    @Override
    public List<RateDto> getCurrencyRateForPeriod(String currencyCode, LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public StatisticsInfo getStatistics(String currencyCode, LocalDate from, LocalDate to) {
        return null;
    }
}
