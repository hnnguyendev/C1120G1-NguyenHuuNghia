USE classicmodels;

SELECT *
FROM products;

SELECT productCode, productName, buyprice, quantityInStock 
FROM products
WHERE buyprice > 56.76 AND quantityInStock > 10;

SELECT products.productCode, products.productName, products.buyprice, productlines.textDescription
FROM products
INNER JOIN productlines
ON products.productLine = productlines.productLine
WHERE products.buyprice > 56.76 AND products.buyprice < 95.59;

SELECT productCode, productName, buyprice, quantityInStock, productVendor, productLine 
FROM products 
WHERE productLine = 'Classic Cars' OR productVendor = 'Min Lin Diecast';
