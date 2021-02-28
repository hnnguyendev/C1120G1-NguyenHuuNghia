CREATE DATABASE dbp01;

USE dbp01;

CREATE TABLE contacts (
	id INT(11) NOT NULL AUTO_INCREMENT,
    lastname VARCHAR(30) NOT NULL,
    firstname VARCHAR(25),
    birthday DATE,
    CONSTRAINT contacts_pk PRIMARY KEY (id)
);

CREATE TABLE suppliers (
	id INT(11) NOT NULL AUTO_INCREMENT,
    suppliername VARCHAR(50) NOT NULL,
    accountrep VARCHAR(30) NOT NULL DEFAULT 'TDB',
    CONSTRAINT suppliers_pk PRIMARY KEY (id)
);

-- ADD 
ALTER TABLE contacts
ADD address VARCHAR(100) NOT NULL
AFTER firstname;

ALTER TABLE contacts
ADD phone VARCHAR(20)
FIRST,
ADD email VARCHAR(50) NOT NULL
AFTER lastname;

-- MODIFY
ALTER TABLE contacts
MODIFY phone VARCHAR(20)
AFTER firstname;

-- DROP
ALTER TABLE contacts
DROP COLUMN email;

-- CHANGE
ALTER TABLE contacts
CHANGE COLUMN address `add` VARCHAR(50) NOT NULL;

-- RENAME
ALTER TABLE contacts
RENAME TO people;