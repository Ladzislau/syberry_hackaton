package com.team.syberry.service.implementation;

import com.team.syberry.domain.CurRateNatBank;
import com.team.syberry.domain.CurRateShortNatBank;
import com.team.syberry.domain.CurrencyNatBank;
import com.team.syberry.domain.RateNationalBank;
import com.team.syberry.dto.response.RateDto;
import com.team.syberry.dto.response.StatisticsInfo;
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
        List<CurrencyNatBank> currencyNatBankList = bankApiClient.getCurrenciesList();
        List<String> resultList = new ArrayList<>();
        for(CurrencyNatBank currency : currencyNatBankList) {
           resultList.add(currency.getCur_Abbreviation());
        }
        return resultList;
    }

    @Override
    public RateDto getCurrencyRateForDate(String currencyCode, LocalDate date) {
        CurRateNatBank rateNationalBank = bankApiClient.getCurrencyRate(currencyCode, date);
        RateDto dto = new RateDto();
        dto.setDate(LocalDateTime.of(date, LocalTime.now()));
        dto.setBuyRate(rateNationalBank.getCur_OfficialRate());
        dto.setSellRate(null);
        return dto;
    }

    @Override
    public List<RateDto> getCurrencyRateForPeriod(String currencyCode, LocalDate from, LocalDate to) {
        List<RateDto> resultList = new ArrayList<>();

        List<CurRateShortNatBank> rateNationalBank = bankApiClient.getCurrencyRateForPeriod(currencyCode, from, to);
        for(CurRateShortNatBank rateShort : rateNationalBank) {
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
