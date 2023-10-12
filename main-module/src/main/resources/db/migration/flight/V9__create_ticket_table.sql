CREATE TYPE ticket_class as ENUM ('ECONOMY','PREMIUM_ECONOMY','BUSINESS', 'FIRST_CLASS');

CREATE SEQUENCE ticket_id_seq START 1000 INCREMENT 10;

CREATE TABLE IF NOT EXISTS ticket
(
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('ticket_id_seq'),
    ticket_class VARCHAR(255),
    base_price INTEGER,
    luggage_fee INTEGER
);