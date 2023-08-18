package org.hannah.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExchangeRates {

    private Map<String, Double> rates;

    // constructors, getters, setters...
    @JsonProperty("rates")
    public ExchangeRates() {}

    public ExchangeRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
