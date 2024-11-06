-- Population of the world
SELECT SUM(Population) AS world_population 
FROM country;

-- Population of a continent
SELECT SUM(Population) AS continent_population
FROM country
WHERE Continent = 'Asia'; -- Replace 'Asia' with desired continent

-- Population of a region 
SELECT SUM(Population) AS region_population
FROM country 
WHERE Region = 'Southeast Asia'; -- Replace 'Southeast Asia' with desired region

-- Population of a country
SELECT Population AS country_population  
FROM country
WHERE Name = 'Indonesia'; -- Replace 'Indonesia' with desired country

-- Population of a district
SELECT SUM(Population) AS district_population  
FROM city
WHERE District = 'Jakarta Raya'; -- Replace 'Jakarta Raya' with desired district

-- Population of a city  
SELECT Population AS city_population
FROM city 
WHERE Name = 'Jakarta'; -- Replace 'Jakarta' with desired city
