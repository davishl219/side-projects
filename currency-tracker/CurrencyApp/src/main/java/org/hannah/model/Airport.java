package org.hannah.model;

public class Airport {

    public int airportId;
    public int countryId;
    public String airportCode;
    public String airportName;
    public String cityLocation;

    public Airport() {}

    public Airport(int airportId, int countryId, String airportCode, String airportName, String cityLocation) {
        this.airportId = airportId;
        this.countryId = countryId;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.cityLocation = cityLocation;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getCityLocation() {
        return cityLocation;
    }
}
