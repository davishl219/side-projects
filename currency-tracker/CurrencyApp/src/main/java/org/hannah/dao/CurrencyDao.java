package org.hannah.dao;

import org.hannah.model.Currency;

public interface CurrencyDao {

    Currency getCurrencyById(int currencyId);

    Currency createCurrency(Currency currency);
    Currency updateCurrency(Currency currency);





}
