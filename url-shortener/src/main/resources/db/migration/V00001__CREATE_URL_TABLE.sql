
CREATE TABLE url(
    id SERIAL PRIMARY KEY NOT NULL,
    long_url  TEXT  NOT NULL,
    short_url  TEXT  NOT NULL,
    number_of_accesses  INT  NOT NULL
);
