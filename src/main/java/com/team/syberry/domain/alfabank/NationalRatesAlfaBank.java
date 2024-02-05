package com.team.syberry.domain.alfabank;

import lombok.Data;

import java.time.LocalDateTime;
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

        private LocalDateTime date;

        private String name;
    }
}

