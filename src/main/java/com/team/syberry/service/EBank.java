package com.team.syberry.service;

public enum EBank {
    NAT_BANK("Нацбанк Республики Беларусь"),
    ALFA_BANK("Альфа-Банк"),
    BELARUSBANK("Беларусбанк");

    private String value;

    EBank(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
