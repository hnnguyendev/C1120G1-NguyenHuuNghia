USE classicmodels;

SELECT `status`, COUNT(`status`) AS count
FROM orders
GROUP BY `status`;

SELECT orders.`status`, SUM(orderdetails.quantityOrdered * orderdetails.priceEach) AS sum
FROM orders
INNER JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
GROUP BY `status`;

SELECT orderNumber, SUM(quantityOrdered * priceEach) AS total
FROM orderdetails
GROUP BY orderNumber;

SELECT YEAR(orders.orderDate) AS `year`, SUM(orderdetails.quantityOrdered * orderdetails.priceEach) AS total
FROM orders
INNER JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
WHERE orders.`status` = 'shipped'
GROUP BY `year`
HAVING `year` > 2003;



