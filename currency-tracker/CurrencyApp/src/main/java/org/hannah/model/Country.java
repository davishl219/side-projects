package org.hannah.model;

public class Country {
    public int countryId;
    public String countryName;
    public int currencyId;
    public boolean visited;
    public boolean futureVisit;

    public Country() {}

    public Country(int countryId, String countryName, int currencyId, boolean visited, boolean futureVisit) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.currencyId = currencyId;
        this.visited = visited;
        this.futureVisit = futureVisit;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isFutureVisit() {
        return futureVisit;
    }

    public void setFutureVisit(boolean futureVisit) {
        this.futureVisit = futureVisit;
    }
}
