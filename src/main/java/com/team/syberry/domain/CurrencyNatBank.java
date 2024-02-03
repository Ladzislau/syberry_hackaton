package com.team.syberry.domain;

import lombok.Data;

@Data
public class CurrencyNatBank {

    private int cur_ID;
    private int cur_ParentID;
    private int cur_Code;
    private String cur_Abbreviation;
    private String cur_Name;
    private String cur_Name_Bel;
    private String cur_Name_Eng;
    private String cur_QuotName;
    private String cur_QuotName_Bel;
    private String cur_QuotName_Eng;
    private String cur_NameMulti;
    private String cur_Name_BelMulti;
    private String cur_Name_EngMulti;
    private int cur_Scale;
    private int cur_Periodicity;
    private String cur_DateStart;
    private String cur_DateEnd;
}
