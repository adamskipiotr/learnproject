CREATE TYPE example_enum as ENUM ('POSITION_1','POSITION_2','POSITION_3');

CREATE SEQUENCE config_id_seq START 1000 INCREMENT 1;

CREATE TABLE IF NOT EXISTS example_table
(
    id  BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('config_id_seq'),
    name VARCHAR(255) NOT NULL,
    "value" BIGINT,
    example_enum VARCHAR(255)
);