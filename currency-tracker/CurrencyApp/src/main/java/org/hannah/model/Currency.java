package org.hannah.model;

import java.math.BigDecimal;

public class Currency {
    private int currencyId;
    private String currencyType;
    private int amount;
    private double exchangeRate;
    private BigDecimal amountInUsd;

    public Currency() {}

    public Currency(int currencyId, String currencyType, int amount, double exchangeRate) {
        this.currencyId = currencyId;
        this.currencyType = currencyType;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
        this.amountInUsd = BigDecimal.valueOf(amount * exchangeRate);
    }

    public Currency(String currencyType, int amount, double exchangeRate) {
        this.currencyType = currencyType;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
        this.amountInUsd = BigDecimal.valueOf(amount * exchangeRate);
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setAmountInUSD(BigDecimal amountInUsd) {
        this.amountInUsd = amountInUsd;
    }

    public BigDecimal getAmountInUsd() {
        return amountInUsd;
    }
}
