package com.beginsecure.holidays.model;

import java.util.Arrays;

public class Holiday {
    public String date;
    public String localName;
    public String name;
    public String countryCode;
    public boolean fixed;
    public boolean global;
    public String [] counties;
    public String launchYear;
    public String type;

    public Holiday() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public String[] getCounties() {
        return counties;
    }

    public void setCounties(String[] counties) {
        this.counties = counties;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Holiday{" +
                "date='" + date + '\'' +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", fixed=" + fixed +
                ", global=" + global +
                ", counties=" + Arrays.toString(counties) +
                ", launchYear='" + launchYear + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
