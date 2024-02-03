package com.team.syberry.domain;

import lombok.Data;

import java.util.List;

@Data
public class RateListAlfaBank {

    private List<Rate> rateList;

    @Data
    public static class Rate {
        private double sellRate;
        private String sellIso;
        private int sellCode;
        private double buyRate;
        private String buyIso;
        private int buyCode;
        private int quantity;
        private String name;
        private String date;
    }
}

