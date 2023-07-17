
CREATE SEQUENCE flight_id_sequence START 1000 INCREMENT 10;

CREATE TABLE IF NOT EXISTS flight
(
    id  BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('flight_id_sequence'),
);