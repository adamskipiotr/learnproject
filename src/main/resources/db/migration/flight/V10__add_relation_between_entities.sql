CREATE TABLE IF NOT EXISTS airports__crew_members
(
    crew_member_id BIGINT,
    airport_id BIGINT
);

ALTER TABLE IF EXISTS ticket
ADD COLUMN flight_id BIGINT,
ADD COLUMN passenger_id BIGINT;

ALTER TABLE IF EXISTS flight
ADD COLUMN flight_name VARCHAR(255),
ADD COLUMN max_passenger_count INTEGER,
ADD COLUMN start_airport_id BIGINT,
ADD COLUMN end_airport_id BIGINT;