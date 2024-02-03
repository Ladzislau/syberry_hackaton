package com.team.syberry.service.api;

import com.team.syberry.dto.response.RateDto;
import com.team.syberry.dto.response.StatisticsInfo;
import com.team.syberry.service.EBank;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface IBankService {

   default List<String> getAllBanks(){
      return Arrays.stream(EBank.values())
              .map(EBank::getValue)
              .collect(Collectors.toList());
   }

   List<String> getAllCurrencies(String backName);

   List<RateDto> getCurrencyRateForPeriod(String bankName, String currencyCode, LocalDate from, LocalDate to);

   StatisticsInfo getStatistics(String bankName, String currencyCode, LocalDate from, LocalDate to);
}
