-- Reset schema
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS countrylanguage;

-- Create tables
CREATE TABLE country (
Code VARCHAR(10) PRIMARY KEY,
Name VARCHAR(255),
Continent VARCHAR(255),
Region VARCHAR(255),
Population BIGINT
);

CREATE TABLE city (
ID INT PRIMARY KEY,
Name VARCHAR(255),
Population INT,
District VARCHAR(255),
CountryCode VARCHAR(10),
FOREIGN KEY (CountryCode) REFERENCES country(Code)
);

CREATE TABLE countrylanguage (
CountryCode VARCHAR(10),
Language VARCHAR(255),
Percentage DECIMAL(5, 2),
PRIMARY KEY (CountryCode, Language),
FOREIGN KEY (CountryCode) REFERENCES country(Code)
);

-- Insert test data
INSERT INTO country (Code, Name, Continent, Region, Population) VALUES
('CH', 'China', 'Asia', 'East Asia', 1400000000),
('IN', 'India', 'Asia', 'South Asia', 1300000000),
('US', 'United States', 'North America', 'Northern America', 331000000),
('FR', 'France', 'Europe', 'Western Europe', 800000000);

INSERT INTO city (ID, Name, Population, District, CountryCode) VALUES
(1, 'Shanghai', 24000000, 'District A', 'CH'),
(2, 'Beijing', 21000000, 'District A', 'CH'),
(3, 'Delhi', 30000000, 'District B', 'IN'),
(4, 'Mumbai', 18000000, 'District B', 'IN'),
(5, 'New York', 8419600, 'District C', 'US'),
(6, 'Paris', 5000000, 'District D', 'FR');

INSERT INTO countrylanguage (CountryCode, Language, Percentage) VALUES
('CH', 'Chinese', 90.00),
('IN', 'Hindi', 40.00),
('IN', 'English', 15.00),
('US', 'English', 80.00),
('US', 'Spanish', 15.00),
('FR', 'French', 98.00);
