CREATE SEQUENCE passenger_id_seq START 1000 INCREMENT 10;

CREATE TABLE IF NOT EXISTS passenger
(
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('passenger_id_seq'),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    is_premium BOOLEAN,
    age INTEGER
);