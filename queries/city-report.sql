-- City Report
SELECT
    city.Name,  
    country.Name AS Country, 
    city.District,
    city.Population  
FROM city
JOIN country ON city.CountryCode = country.Code  
ORDER BY city.Population DESC;
