package com.team.syberry.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticsInfo {

    private Double minRate;

    private Double maxRate;

    private Double averageRate;
}