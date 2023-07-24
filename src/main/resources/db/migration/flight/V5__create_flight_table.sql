CREATE TYPE flight_status as ENUM ('SCHEDULED','ONGOING','FINISHED', 'CANCELLED', 'DELAYED', 'OTHER');

CREATE SEQUENCE flight_id_seq START 1000 INCREMENT 10;

CREATE TABLE IF NOT EXISTS flight
(
    id  BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('flight_id_seq'),
    flight_status VARCHAR(255),
    flight_start TIMESTAMP(6),
    flight_end TIMESTAMP(6)
);