package com.team.syberry.domain.belarusbank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateBelarusBank {

    @JsonProperty("kurs_date_time")
    private LocalDateTime kursDateTime;

    @JsonProperty("USDCARD_in")
    private String usdCardIn;

    @JsonProperty("USDCARD_out")
    private String usdCardOut;

    @JsonProperty("EURCARD_in")
    private String eurCardIn;

    @JsonProperty("EURCARD_out")
    private String eurCardOut;

    @JsonProperty("RUBCARD_in")
    private String rubCardIn;

    @JsonProperty("RUBCARD_out")
    private String rubCardOut;

    @JsonProperty("CNYCARD_in")
    private String cnyCardIn;

    @JsonProperty("CNYCARD_out")
    private String cnyCardOut;

    @JsonProperty("USDCARD_EURCARD_in")
    private String usdCardEurCardIn;

    @JsonProperty("USDCARD_EURCARD_out")
    private String usdCardEurCardOut;

    @JsonProperty("USDCARD_RUBCARD_in")
    private String usdCardRubCardIn;

    @JsonProperty("USDCARD_RUBCARD_out")
    private String usdCardRubCardOut;

    @JsonProperty("RUBCARD_EURCARD_out")
    private String rubCardEurCardOut;

    @JsonProperty("RUBCARD_EURCARD_in")
    private String rubCardEurCardIn;

    @JsonProperty("CNYCARD_USDCARD_in")
    private String cnyCardUsdCardIn;

    @JsonProperty("CNYCARD_USDCARD_out")
    private String cnyCardUsdCardOut;

    @JsonProperty("CNYCARD_EURCARD_in")
    private String cnyCardEurCardIn;

    @JsonProperty("CNYCARD_EURCARD_out")
    private String cnyCardEurCardOut;

    @JsonProperty("CNYCARD_RUBCARD_in")
    private String cnyCardRubCardIn;

    @JsonProperty("CNYCARD_RUBCARD_out")
    private String cnyCardRubCardOut;
}