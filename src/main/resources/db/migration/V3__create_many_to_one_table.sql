
CREATE SEQUENCE many_to_one_seq START 1 INCREMENT 50;

CREATE TABLE IF NOT EXISTS many_to_one
(
    id BIGINT NOT NULL,
    example_entity_id BIGINT,
    many_to_one_name VARCHAR(255)
);