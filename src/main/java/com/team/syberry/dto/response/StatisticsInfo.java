package com.team.syberry.dto.response;

import lombok.Data;

@Data
public class StatisticsInfo {
    private String chartImage;

    private double minRate;

    private double maxRate;

    private double rateAtPeriodStart;

    private double rateAtPeriodEnd;

    private double averageRate;
}