package com.team.syberry.dto.response;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateDto {

    private double sellRate;

    private double buyRate;

    private LocalDateTime date;

}
