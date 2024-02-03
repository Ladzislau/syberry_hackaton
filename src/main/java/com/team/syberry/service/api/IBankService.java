package com.team.syberry.service.api;

import com.team.syberry.dto.response.RateDto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface IBankService {

   default List<String> getAllBanks() {
      return Arrays.stream(EBank.values())
              .map(EBank::getValue)
              .collect(Collectors.toList());
   }

   List<String> getAllCurrencies();

   RateDto getCurrencyRateToday(String currencyCode);

   RateDto getCurrencyRateForDate(String currencyCode, LocalDate date);

   List<RateDto> getCurrencyRateForPeriod(String currencyCode, LocalDate from, LocalDate to);

   byte[] getStatistics(String currencyCode, LocalDate from, LocalDate to);
}
