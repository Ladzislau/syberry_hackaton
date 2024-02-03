package com.team.syberry.domain.nationalbank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StatisticsNationalBank {

    private int Cur_ID;
    private LocalDateTime Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private double Cur_OfficialRate;
}
