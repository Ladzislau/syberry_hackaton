package com.team.syberry.domain.nationalbank;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RateNationalBank {
    private int Cur_ID;
    private LocalDate Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private double Cur_OfficialRate;
}

