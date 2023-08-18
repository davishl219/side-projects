BEGIN TRANSACTION;

DROP TABLE IF EXISTS country, currency, airport CASCADE;


CREATE TABLE currency (
	currency_id serial,
	type varchar(50) NOT NULL,
	amount int CONSTRAINT DF_amount DEFAULT(0),
	exchange_rate decimal(12,2),
	amount_in_usd decimal(5,2),
	CONSTRAINT PK_currency PRIMARY KEY (currency_id),
	CONSTRAINT UQ_type UNIQUE(type)
);

CREATE TABLE country (
	country_id serial,
	name varchar(50) NOT NULL,
	currency_id int NOT NULL,
	visited boolean NOT NULL,
	future_visit_intended boolean,
	CONSTRAINT PK_country PRIMARY KEY (country_id),
	CONSTRAINT FK_country_currency_id FOREIGN KEY (currency_id) REFERENCES currency(currency_id),
	CONSTRAINT UQ_name UNIQUE(name)
);


CREATE TABLE airport (
	airport_id serial,
	country_id int NOT NULL,
	airport_code char(3) NOT NULL,
	name varchar(100) NOT NULL,
	city varchar(50) NOT NULL,
	CONSTRAINT PK_airport PRIMARY KEY (airport_id),
	CONSTRAINT FK_airport_country_id FOREIGN KEY (country_id) REFERENCES country(country_id),
	CONSTRAINT UQ_airport_code UNIQUE(airport_code)
);

COMMIT TRANSACTION;

SELECT * FROM COUNTRY;
