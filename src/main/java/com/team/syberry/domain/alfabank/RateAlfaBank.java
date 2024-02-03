package com.team.syberry.domain.alfabank;

import lombok.Data;

@Data
public class RateAlfaBank {
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
