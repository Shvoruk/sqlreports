-- Language speakers from greatest to smallest, including percentage of world population
SELECT
    cl.Language,
    SUM(c.Population * cl.Percentage / 100) AS speakers, 
    CONCAT(ROUND(SUM(c.Population * cl.Percentage / 100) / (SELECT SUM(Population) FROM country) * 100, 2), '%') AS percentage  
FROM country c
JOIN countrylanguage cl ON c.Code = cl.CountryCode
WHERE cl.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')  
GROUP BY cl.Language
ORDER BY speakers DESC;  
