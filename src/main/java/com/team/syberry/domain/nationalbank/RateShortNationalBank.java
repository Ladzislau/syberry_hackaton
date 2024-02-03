package com.team.syberry.domain.nationalbank;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateShortNationalBank {
    private int cur_ID;
    private LocalDateTime date;
    private double cur_OfficialRate;
}
