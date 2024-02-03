package com.team.syberry.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GetCurrenciesResponse {

    private List<CurrencyInfo> currencies;
}
