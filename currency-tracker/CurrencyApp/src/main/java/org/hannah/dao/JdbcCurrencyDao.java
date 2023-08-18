package org.hannah.dao;

import org.hannah.exception.DaoException;
import org.hannah.model.Airport;
import org.hannah.model.Currency;
import org.hannah.model.ExchangeRates;
import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.client.RestTemplate;
//import com.fasterxml.jackson.annotation.JsonProperty;


import javax.sql.DataSource;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JdbcCurrencyDao implements CurrencyDao {
    private final JdbcTemplate jdbcTemplate;


//    HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("https://currency-exchange.p.rapidapi.com/listquotes"))
//            .header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
//            .header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
//            .method("GET", HttpRequest.BodyPublishers.noBody())
//            .build();
//    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//    response.body();

    //System.out.println(response.body());
   RestTemplate restTemplate = new RestTemplate(); // Create a new client
//   ResponseEntity response = restTemplate.getForEntity(
//           "https://api.exchangerate-api.com/v4/latest/USD",
//           String.class); // Make GET request using client
//     //System.out.println(response.getBody());
    ExchangeRates response = restTemplate.getForObject(
            "https://api.exchangerate-api.com/v4/latest/USD",
            ExchangeRates.class);
    response.getRates();


    public JdbcCurrencyDao(DataSource dataSource) throws IOException, InterruptedException {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Currency getCurrencyById(int currencyId) {
        Currency c = null;
        String sql = "SELECT currency_id, type, amount, exchange_rate, amount_in_usd FROM currency WHERE currency_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, currencyId);
            if (results.next()) {
                c = mapRowToCurrency(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return c;
    }

    @Override
    public Currency createCurrency(Currency currency) {
        Currency newCurrency = null;
        String sql = "INSERT INTO currency (type, amount, exchange_rate, amount_in_usd) VALUES (?, ?, ?, ?) RETURNING currency_id";
        try {
            int currencyId = jdbcTemplate.queryForObject(sql, int.class, currency.getCurrencyType(), currency.getAmount(), currency.getExchangeRate(), currency.getAmountInUsd());
            newCurrency = getCurrencyById(currencyId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integerity violation", e);
        }
        return newCurrency;
    }


    @Override
    public Currency updateCurrency(Currency currency) {
        return null;
    }


    private Currency mapRowToCurrency(SqlRowSet rs) {
        Currency c = new Currency();
        c.setCurrencyId(rs.getInt("currency_id"));
        c.setCurrencyType(rs.getString("type"));
        c.setAmount(rs.getInt("amount"));
        c.setExchangeRate(rs.getDouble("exchange_rate"));
        c.setAmountInUSD(rs.getBigDecimal("amount_in_usd"));
        return c;
    }

}

