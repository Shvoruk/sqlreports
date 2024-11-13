-- Capital City Report
SELECT
    city.Name,
    country.Name AS Country,  
    city.Population
FROM city  
JOIN country ON city.ID = country.Capital
ORDER BY city.Population DESC;  
