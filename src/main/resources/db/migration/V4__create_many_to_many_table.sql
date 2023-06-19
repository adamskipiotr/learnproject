
CREATE SEQUENCE many_to_many_seq START 1 INCREMENT 50;

CREATE TABLE IF NOT EXISTS example_entity__many_to_many_entity
(
    example_entity_id BIGINT,
    many_to_many_entity_id BIGINT
);

CREATE TABLE IF NOT EXISTS many_to_many
(
    id BIGINT NOT NULL,
    example_entity_id BIGINT,
    many_to_many_name VARCHAR(255)
);