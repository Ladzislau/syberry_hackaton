package com.team.syberry.feign;

import java.time.LocalDate;
import java.util.List;

public interface IBankApiClient {

    public List<String> getCurrenciesList(String bankName);

    public CurrencyRateDto getCurrencyRate(String bankName, String currencyCode, LocalDate date);

    public List<CurrencyRateDto> getCurrencyRateForPeriod(String bankName, String currencyCode, LocalDate from, LocalDate to);

    public StatisticsDto getStatistics(String bankName, String currencyCode, LocalDate from, LocalDate to);
}
