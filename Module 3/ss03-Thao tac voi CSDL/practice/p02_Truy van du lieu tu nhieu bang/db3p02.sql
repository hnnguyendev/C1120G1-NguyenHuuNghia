USE classicmodels;

SELECT customers.customerNumber, customers.customerName, customers.phone, payments.paymentDate, payments.amount
FROM customers
INNER JOIN payments
ON customers.customerNumber = payments.customerNumber
WHERE customers.city = 'Las Vegas';

SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.`status`, orders.comments
FROM customers
LEFT JOIN orders
ON customers.customerNumber = orders.customerNumber;

SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.`status`, orders.comments
FROM customers
LEFT JOIN orders
ON customers.customerNumber = orders.customerNumber
WHERE orders.orderNumber IS NULL;