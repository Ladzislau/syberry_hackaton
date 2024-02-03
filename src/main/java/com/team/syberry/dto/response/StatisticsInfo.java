package com.team.syberry.dto.response;

import lombok.Data;

@Data
public class StatisticsInfo {
    private String chartImage;

    private Double minRate;

    private Double maxRate;

    private Double rateAtPeriodStart;

    private Double rateAtPeriodEnd;

    private Double averageRate;
}