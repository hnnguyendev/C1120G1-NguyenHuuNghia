USE `classicmodels`;

SELECT * 
FROM `customers`;

SELECT `customerName`, `phone`, `city`, `country` 
FROM `customers`;

SELECT *
FROM `customers`
WHERE `customerName` = 'Atelier graphique';

SELECT *
FROM `customers`
WHERE `customerName` LIKE '%A%';

SELECT *
FROM `customers`
WHERE `city` IN ('Nantes',' Las Vegas',' Warszawa','NYC');