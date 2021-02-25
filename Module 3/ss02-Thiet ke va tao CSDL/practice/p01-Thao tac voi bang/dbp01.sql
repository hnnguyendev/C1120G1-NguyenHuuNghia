CREATE DATABASE dbp01;

USE dbp02;

CREATE TABLE contacts (
	id INT(11) NOT NULL AUTO_INCREMENT,
    lastname VARCHAR(30) NOT NULL,
    firstname VARCHAR(25),
    birthday DATE,
    CONSTRAINT contacts_pk PRIMARY KEY (id)
);