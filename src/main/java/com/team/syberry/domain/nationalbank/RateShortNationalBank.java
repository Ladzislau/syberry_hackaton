package com.team.syberry.domain.nationalbank;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RateShortNationalBank {
    private int curId;
    private int curParentId;
    private String curCode;
    private String curAbbreviation;
    private String curName;
    private String curNameBel;
    private String curNameEng;
    private String curQuotName;
    private String curQuotNameBel;
    private String curQuotNameEng;
    private String curNameMulti;
    private String curNameBelMulti;
    private String curNameEngMulti;
    private int curScale;
    private int curPeriodicity;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime curDateStart;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime curDateEnd;
}
