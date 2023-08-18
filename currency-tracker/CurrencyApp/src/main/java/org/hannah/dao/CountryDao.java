package org.hannah.dao;

import org.hannah.model.Country;

import java.util.List;

public interface CountryDao {

    Country getCountryById(int countryId);
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getCountriesByCurrencyId(int currencyId);
    Country getCountryByName(String countryName);




}
