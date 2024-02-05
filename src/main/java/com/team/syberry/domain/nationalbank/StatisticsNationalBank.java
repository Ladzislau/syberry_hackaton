package com.team.syberry.domain.nationalbank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StatisticsNationalBank {

    @JsonProperty("Cur_ID")
    private int curId;

    @JsonProperty("Date")
    private LocalDateTime date;

    @JsonProperty("Cur_Abbreviation")
    private String curAbbreviation;

    @JsonProperty("Cur_Scale")
    private int curScale;

    @JsonProperty("Cur_Name")
    private String curName;

    @JsonProperty("Cur_OfficialRate")
    private double curOfficialRate;
}
