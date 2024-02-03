package com.team.syberry.domain.nationalbank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RateNationalBank {
    private int Cur_ID;
    private LocalDate Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;

    @JsonProperty(value = "Cur_Name")
    private String curName;
    private double Cur_OfficialRate;
}

