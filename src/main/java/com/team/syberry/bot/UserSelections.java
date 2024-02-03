package com.team.syberry.bot;

public class UserSelections {
    private String selectedBank;
    private String selectedCurrency;

    public UserSelections(String selectedBank, String selectedCurrency) {
        this.selectedBank = selectedBank;
        this.selectedCurrency = selectedCurrency;
    }

    public String getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(String selectedBank) {
        this.selectedBank = selectedBank;
    }

    public String getSelectedCurrency() {
        return selectedCurrency;
    }

    public void setSelectedCurrency(String selectedCurrency) {
        this.selectedCurrency = selectedCurrency;
    }
}
