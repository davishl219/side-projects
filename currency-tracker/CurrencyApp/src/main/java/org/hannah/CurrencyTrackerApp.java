package org.hannah;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hannah.dao.*;
import org.hannah.model.Currency;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;


public class CurrencyTrackerApp {

    private final Scanner userInput = new Scanner(System.in);

    private final AirportDao airportDao;
    private final CountryDao countryDao;
    private final CurrencyDao currencyDao;
    public static void main(String[] args) throws IOException, InterruptedException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Currency");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        CurrencyTrackerApp application = new CurrencyTrackerApp(dataSource);
        application.run();
    }

    public CurrencyTrackerApp(DataSource dataSource) throws IOException, InterruptedException {
        airportDao = new JdbcAirportDao(dataSource);
        countryDao = new JdbcCountryDao(dataSource);
        currencyDao = new JdbcCurrencyDao(dataSource);
    }

    private void run() {

        boolean running = true;
        while (running) {
            System.out.println("Add a currency");
            System.out.println("Submit in this order: type, amount, exchange rate.");
            String type = userInput.nextLine();
            int amount = Integer.parseInt(userInput.nextLine());
            double exchangeRate = Double.parseDouble(userInput.nextLine());
            Currency c = new Currency(type, amount, exchangeRate);
            c = currencyDao.createCurrency(c);
            currencyDao.getCurrencyById(1);
            System.out.println(c.getAmountInUsd());
        }

    }
}