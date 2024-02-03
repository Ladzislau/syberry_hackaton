package com.team.syberry.dto.response;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateInfoDto {

    private String curName;

    private Double sellRate;

    private Double buyRate;

    private LocalDateTime date;

}
