package com.team.syberry.service.api;

import com.team.syberry.dto.response.RateDto;

import java.time.LocalDate;
import java.util.List;

public interface IBankService {

   List<String> getAllCurrencies();

   RateDto getCurrencyRateForDate(String currencyCode, LocalDate date);

   List<RateDto> getCurrencyRateForPeriod(String currencyCode, LocalDate from, LocalDate to);

   byte[] getStatistics(String currencyCode, LocalDate from, LocalDate to);
}
