CREATE DATABASE dbbank;

USE dbbank;

CREATE TABLE customers (
	customer_number INT NOT NULL AUTO_INCREMENT,
    fullname VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(50),
    phone VARCHAR(20),
    CONSTRAINT customers_pk PRIMARY KEY (customer_number)
);

CREATE TABLE accounts (
	account_number INT NOT NULL AUTO_INCREMENT,
    account_type VARCHAR(20),
    `date` DATE,
    balance INT,
    CONSTRAINT accounts_pk PRIMARY KEY (account_number)
);

CREATE TABLE transactions (
	tran_number INT NOT NULL AUTO_INCREMENT,
    account_number INT,
    `date` DATE,
    amounts INT,
    descriptions VARCHAR(70),
    CONSTRAINT transactions_pk PRIMARY KEY (tran_number)
);

ALTER TABLE accounts
ADD customer_number INT UNIQUE,
ADD CONSTRAINT accounts_fk FOREIGN KEY (customer_number) REFERENCES customers(customer_number);

ALTER TABLE transactions 
ADD CONSTRAINT transactions_fk FOREIGN KEY (account_number) REFERENCES accounts(account_number);

-- trong EER không thể hiện được quan hệ 1-1 (mình tự ngầm hiểu), để customers và accounts đúng bản chất quan hệ 1-1 ta thêm 
-- constraint UNIQUE cho customer_number trong bảng accounts