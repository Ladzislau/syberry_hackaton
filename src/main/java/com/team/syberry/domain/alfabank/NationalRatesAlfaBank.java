package com.team.syberry.domain.alfabank;

import lombok.Data;
import java.util.List;

@Data
public class NationalRatesAlfaBank {
    private List<Rate> rates;

    @Data
    public static class Rate {
        private double rate;
        private String iso;
        private int code;
        private int quantity;
        private String date;
        private String name;
    }
}

