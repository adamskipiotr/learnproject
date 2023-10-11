CREATE TYPE crew_member_rank as ENUM ('FIRST_OFFICER','SENIOR_FIRST_OFFICER','CAPTAIN');

CREATE SEQUENCE crew_member_id_seq START 1000 INCREMENT 10;

CREATE TABLE IF NOT EXISTS flights__crew_members
(
    flight_id BIGINT,
    crew_member_id BIGINT
);

CREATE TABLE IF NOT EXISTS crew_member
(
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('crew_member_id_seq'),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    crew_member_rank VARCHAR(255),
    age INTEGER
);
