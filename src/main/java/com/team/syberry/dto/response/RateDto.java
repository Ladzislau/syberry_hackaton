package com.team.syberry.dto.response;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateDto {

    private Double sellRate;

    private Double buyRate;

    private LocalDateTime date;

}
