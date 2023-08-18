package org.hannah.dao;

import org.hannah.model.Country;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcCountryDao implements CountryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCountryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Country getCountryById(int countryId) {
        return null;
    }
    @Override
    public Country createCountry(Country country) {
        return null;
    }

    @Override
    public Country updateCountry(Country country) {
        return null;
    }

    @Override
    public List<Country> getCountriesByCurrencyId(int currencyId) {
        return null;
    }

    @Override
    public Country getCountryByName(String countryName) {
        return null;
    }

    private Country mapRowToCountry(SqlRowSet rs) {
        Country c = new Country();
        c.setCountryId(rs.getInt("country_id"));
        c.setCountryName(rs.getString("name"));
        c.setCurrencyId(rs.getInt("currency_id"));
        c.setVisited(rs.getBoolean("visited"));
        c.setFutureVisit(rs.getBoolean("future_visit_intended"));
        return c;
    }

}
