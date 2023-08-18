package org.hannah.dao;

import org.hannah.model.Airport;

import java.util.List;

public interface AirportDao {
    Airport getAirportById(int airportId);
    Airport createAirport(Airport airport);
    Airport updateAirport(Airport airport);
    List<Airport> getAirportsByCountryId(int countryId);


}
