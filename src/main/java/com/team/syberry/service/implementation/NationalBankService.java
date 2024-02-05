package com.team.syberry.service.implementation;

import com.team.syberry.domain.nationalbank.*;
import com.team.syberry.domain.nationalbank.CurrencyNationalBank;
import com.team.syberry.dto.response.RateDto;
import com.team.syberry.feign.INationalBankApiClient;
import com.team.syberry.service.api.IBankService;
import com.team.syberry.util.ChartUtil;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service("nationalBankService")
public class NationalBankService implements IBankService {
    private INationalBankApiClient bankApiClient;

    private final ChartUtil chartUtil;

    public NationalBankService(INationalBankApiClient bankApiClient, ChartUtil chartUtil) {
        this.bankApiClient = bankApiClient;
        this.chartUtil = chartUtil;
    }

    @Override
    public List<String> getAllCurrencies() {
        List<CurrencyNationalBank> currencyNatBankList = bankApiClient.getCurrenciesList();
        List<String> resultList = new ArrayList<>();
        for(CurrencyNationalBank currency : currencyNatBankList) {
           resultList.add(currency.getCur_Abbreviation());
        }
        return resultList;
    }

    @Override
    public RateDto getCurrencyRateToday(String currencyCode) {
//        return bankApiClient.getCurrencyRateForPeriod(currencyCode, LocalDate.now(), LocalDate);
        return null;
    }

    @Override
    public RateDto getCurrencyRateForDate(String currencyCode, LocalDate date) {
        RateNationalBank rateNationalBank = bankApiClient.getCurrencyRate(currencyCode, date, 0, "2");
        RateDto dto = new RateDto();
        dto.setDate(LocalDateTime.of(date, LocalTime.now()));
        dto.setBuyRate(rateNationalBank.getCur_OfficialRate());
        dto.setSellRate(null);
        return dto;
    }

    @Override
    public List<RateDto> getCurrencyRateForPeriod(String currencyCode, LocalDate from, LocalDate to) {
        List<RateDto> resultList = new ArrayList<>();

        List<RateShortNationalBank> rateNationalBank = bankApiClient.getCurrencyRateForPeriod(currencyCode, from, to);
        for(RateShortNationalBank rateShort : rateNationalBank) {
            RateDto dto = new RateDto();
            dto.setDate(rateShort.getDate());
            dto.setBuyRate(rateShort.getCur_OfficialRate());
            dto.setSellRate(null);

            resultList.add(dto);
        }
        return resultList;
    }

    @Override
    public byte[] getStatistics(String currencyCode, LocalDate from, LocalDate to) {
        List<RateShortNationalBank> rateList = bankApiClient.getCurrencyRateForPeriod(currencyCode, from, to);
        DefaultCategoryDataset dataset = chartUtil.createDatasetFromRateShortNationalBankList(rateList, currencyCode);
        JFreeChart chart = chartUtil.createChart(dataset);
        byte[] imageBytes = chartUtil.generateChartImage(chart);

        return imageBytes;
    }

}
