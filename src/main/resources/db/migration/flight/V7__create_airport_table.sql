CREATE TYPE weather_condition as ENUM ('SUNNY','RAINING','CLOUDY', 'PARTIALLY_CLOUDY','SNOWING','THUNDERSTORM', 'WINDY', 'HURRICANE', 'CLEAR');

CREATE SEQUENCE airport_id_seq START 1000 INCREMENT 10;

--CREATE TABLE IF NOT EXISTS airports__flights
--(
--    flight_id BIGINT,
--    airport_id BIGINT
--);

CREATE TABLE IF NOT EXISTS airport
(
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('airport_id_seq'),
    name VARCHAR(255),
    last_name VARCHAR(255),
    weather_condition VARCHAR(255),
    local_date_time TIMESTAMP(6)
);