package com.team.syberry.domain.nationalbank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateShortNationalBank {

    @JsonProperty("Cur_ID")
    private int curId;

    @JsonProperty("Date")
    private LocalDateTime date;

    @JsonProperty("Сur_OfficialRate")
    private double curOfficialRate;
}
