package com.team.syberry.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GetCurrencyRateByDatesResponse {

    private final List<GetCurrencyRateResponse> currencyRates;
}
