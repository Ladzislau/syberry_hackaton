package com.team.syberry.service.implementation;

import com.team.syberry.dto.response.RateDto;
import com.team.syberry.dto.response.StatisticsInfo;
import com.team.syberry.service.api.IBankService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("alfaBankService")
public class AlfaBankService implements IBankService {

    @Override
    public List<String> getAllCurrencies(String backName) {
        return null;
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
