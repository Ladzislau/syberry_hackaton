package com.team.syberry.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetCurrencyRateResponse {

    private final BankInfo bankInfo;

    private final CurrencyInfo currencyInfo;

    private final RateInfo rateInfo;
}
