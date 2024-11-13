DROP TABLE IF EXISTS country;

CREATE TABLE country (
    Code VARCHAR(3) PRIMARY KEY,
    Name VARCHAR(255),
    Continent VARCHAR(255),
    Region VARCHAR(255),
    Population INT,
    Capital INT
);
