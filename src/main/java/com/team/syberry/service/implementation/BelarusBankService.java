package com.team.syberry.service.implementation;

import com.team.syberry.domain.belarusbank.EBelarusbankCurrency;
import com.team.syberry.domain.belarusbank.RateBelarusBank;
import com.team.syberry.dto.response.RateDto;
import com.team.syberry.dto.response.RateInfoDto;
import com.team.syberry.dto.response.StatisticsInfo;
import com.team.syberry.feign.IBelarusBankApiClient;
import com.team.syberry.service.BelarusbankMapper;
import com.team.syberry.service.api.IBankService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service("belarusbankService")
public class BelarusBankService implements IBankService {
    private IBelarusBankApiClient bankApiClient;
    private BelarusbankMapper mapper;

    public BelarusBankService(IBelarusBankApiClient bankApiClient, BelarusbankMapper mapper) {
        this.bankApiClient = bankApiClient;
        this.mapper = mapper;
    }

    @Override
    public List<String> getAllCurrencies() {

        return Arrays.stream(EBelarusbankCurrency.values())
                .map(EBelarusbankCurrency::getValue)
                .toList();
    }

    @Override
    public RateDto getCurrencyRateToday(String currencyCode) {
        RateBelarusBank rate = bankApiClient.getCurrenciesList().get(0);
        List<RateInfoDto> list = mapper.processCurrencyExchangeRates(rate);
        for(RateInfoDto infoDto : list) {
            if( infoDto.getCurName().equals(currencyCode)) {
                RateDto dto = new RateDto();
                dto.setDate(LocalDateTime.now());
                dto.setSellRate(infoDto.getSellRate());
                dto.setBuyRate(infoDto.getBuyRate());

                return dto;
            }
        }

        return null;
    }

    @Override
    public RateDto getCurrencyRateForDate(String currencyCode, LocalDate date) {
        return null;
    }

    @Override
    public List<RateDto> getCurrencyRateForPeriod(String currencyCode, LocalDate from, LocalDate to) {

        return null;
    }

    @Override
    public byte[] getStatistics(String currencyCode, LocalDate from, LocalDate to) {
        return null;
    }
}
