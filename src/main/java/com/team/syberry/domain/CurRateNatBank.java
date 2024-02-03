package com.team.syberry.domain;

import lombok.Data;

@Data
public class CurRateNatBank {
    private int cur_ID;
    private String date;
    private String cur_Abbreviation;
    private int cur_Scale;
    private String cur_Name;
    private double cur_OfficialRate;

}
