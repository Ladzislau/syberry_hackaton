package com.team.syberry.service;

import com.team.syberry.domain.belarusbank.RateBelarusBank;
import com.team.syberry.dto.response.RateInfoDto;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BelarusbankMapper {

    public List<RateInfoDto> processCurrencyExchangeRates(RateBelarusBank rate) {
        List<RateInfoDto> currencyRates = new ArrayList<>();

        try {
            for (Field field : RateBelarusBank.class.getDeclaredFields()) {
                String fieldName = field.getName();
                if (fieldName.endsWith("In")) {
                    String currencyCode = fieldName.substring(0, fieldName.length() - 2);
                    double buyRate = getRate(rate, fieldName);
                    double sellRate = getRate(rate, fieldName.replace("In", "Out"));

                    String currencyIn = fieldName.substring(0, fieldName.lastIndexOf("CardIn"));


                    RateInfoDto dto = new RateInfoDto();
                    dto.setCurName(currencyIn.toUpperCase());
                    dto.setBuyRate(buyRate);
                    dto.setSellRate(sellRate);
                    dto.setDate(LocalDateTime.now());

                    currencyRates.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyRates;
    }

    private double getRate(RateBelarusBank rate, String fieldName) throws Exception {
        String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        return Double.parseDouble((String) rate.getClass().getMethod(getterName).invoke(rate));
    }
}
