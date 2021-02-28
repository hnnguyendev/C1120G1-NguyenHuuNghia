CREATE DATABASE dbcustomer;

USE dbcustomer;

CREATE TABLE customers (
   id INT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255),
   CONSTRAINT customers_pk PRIMARY KEY (id)
);

CREATE TABLE orders (
   id INT NOT NULL AUTO_INCREMENT,
   staff VARCHAR(50),
   customerid INT,
   CONSTRAINT orders_pk PRIMARY KEY (id),
   CONSTRAINT orders_fk FOREIGN KEY (customerid) REFERENCES customers(id)
);