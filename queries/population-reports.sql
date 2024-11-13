-- Continent Population Report
SELECT 
    country.Continent AS Name,
    SUM(country.Population) AS Total_Population,
    SUM(city.Population) AS City_Population,
    CONCAT(ROUND(SUM(city.Population) / SUM(country.Population) * 100, 2), '%') AS City_Percentage,
    (SUM(country.Population) - SUM(city.Population)) AS Rural_Population,  
    CONCAT(ROUND((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population) * 100, 2), '%') AS Rural_Percentage
FROM country  
LEFT JOIN city ON country.Code = city.CountryCode
GROUP BY country.Continent;

-- Region Population Report  
SELECT
    country.Region AS Name,
    SUM(country.Population) AS Total_Population,  
    SUM(city.Population) AS City_Population,
    CONCAT(ROUND(SUM(city.Population) / SUM(country.Population) * 100, 2), '%') AS City_Percentage,  
    (SUM(country.Population) - SUM(city.Population)) AS Rural_Population,
    CONCAT(ROUND((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population) * 100, 2), '%') AS Rural_Percentage  
FROM country
LEFT JOIN city ON country.Code = city.CountryCode  
GROUP BY country.Region;

-- Country Population Report
SELECT  
    country.Name,
    country.Population AS Total_Population,
    SUM(city.Population) AS City_Population,
    CONCAT(ROUND(SUM(city.Population) / country.Population * 100, 2), '%') AS City_Percentage,
    (country.Population - SUM(city.Population)) AS Rural_Population,
    CONCAT(ROUND((country.Population - SUM(city.Population)) / country.Population * 100, 2), '%') AS Rural_Percentage
FROM country 
LEFT JOIN city ON country.Code = city.CountryCode  
GROUP BY country.Code;
