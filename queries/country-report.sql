-- Country Report 
SELECT  
    Code,
    Name,
    Continent,
    Region,  
    Population,
    (SELECT Name FROM city WHERE ID = Capital) AS Capital
FROM country  
ORDER BY Population DESC;
