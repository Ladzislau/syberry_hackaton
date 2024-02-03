package com.team.syberry.domain.belarusbank;

public enum EBelarusbankCurrency {
    USD ("USD"),
    EUR("EUR"),
    RUB("RUB"),
    CNY("CNY");

    private String value;

    EBelarusbankCurrency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
