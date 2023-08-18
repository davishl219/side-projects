package org.hannah.dao;

import org.hannah.model.Airport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.List;

public class JdbcAirportDao implements AirportDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAirportDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Airport getAirportById(int airportId) {
        return null;
    }
    @Override
    public Airport createAirport(Airport airport) {
        return null;
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return null;
    }

    @Override
    public List<Airport> getAirportsByCountryId(int countryId) {
        return null;
    }

    private Airport mapRowToAirport(SqlRowSet rs) {
        Airport ap = new Airport();
        ap.setAirportCode(rs.getString("airport_code"));
        ap.setAirportId(rs.getInt("airport_id"));
        ap.setAirportName(rs.getString("name"));
        ap.setCityLocation(rs.getString("city"));
        ap.setCountryId(rs.getInt("country_id"));
        return ap;
    }
}
