CREATE DATABASE dbsalesystem;

USE dbsalesystem;

CREATE TABLE customers (
	customerNumber INT NOT NULL,
    customerName VARCHAR(50) NOT NULL,
    contactLastName VARCHAR(50) NOT NULL,
    contactFirstName VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    creditLimit DOUBLE,
    CONSTRAINT customers_pk PRIMARY KEY (customerNumber)
);

CREATE TABLE orders (
	orderNumber INT NOT NULL,
    orderDate DATE NOT NULL,
    requiredDate DATE NOT NULL,
    shippedDate DATE,
    `status` VARCHAR(15) NOT NULL,
    comments TEXT,
    quantityOrdered INT NOT NULL,
    priceEach DOUBLE NOT NULL,
    CONSTRAINT orders_pk PRIMARY KEY (orderNumber)
);

CREATE TABLE payments (
	customerNumber INT NOT NULL,
    checkNumber VARCHAR(50) NOT NULL,
    paymentDate DATE NOT NULL,
    amount DOUBLE NOT NULL,
    CONSTRAINT payments_pk PRIMARY KEY (customerNumber)
);

CREATE TABLE products (
	productCode VARCHAR(15) NOT NULL,
    productName VARCHAR(70) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock INT NOT NULL,
    buyPrice DOUBLE NOT NULL,
    MSRP DOUBLE NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (productCode)
);

CREATE TABLE productlines (
	productLine VARCHAR(50) NOT NULL,
    textDescription TEXT,
    image VARCHAR(255),
    CONSTRAINT productlines_pk PRIMARY KEY (productLine)
);

CREATE TABLE employees (
	employeeNumber INT NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    jobTitle VARCHAR(50) NOT NULL,
    CONSTRAINT employees_pk PRIMARY KEY (employeeNumber)
);

CREATE TABLE offices (
	officeCode VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    CONSTRAINT offices_pk PRIMARY KEY (officeCode)
);

