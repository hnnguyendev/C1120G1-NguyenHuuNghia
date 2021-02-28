CREATE DATABASE dbuser;

USE `dbuser`;

CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(40),
    `password` VARCHAR(255),
    email VARCHAR(255),
    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE roles (
	id INT NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(50),
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

CREATE TABLE userroles (
	userid INT NOT NULL,
    roleid INT NOT NULL,
    CONSTRAINT userroles_pk PRIMARY KEY (userid, roleid),
    CONSTRAINT userroles_fk1 FOREIGN KEY (userid) REFERENCES users(id),
    CONSTRAINT userroles_fk2 FOREIGN KEY (roleid) REFERENCES roles(id)
);

CREATE TABLE testusers (
	id INT NOT NULL,
    username VARCHAR(40),
    `password` VARCHAR(255),
    email VARCHAR(255)
);

ALTER TABLE testusers 
MODIFY id INT NOT NULL AUTO_INCREMENT,
ADD CONSTRAINT testusers_pk PRIMARY KEY (id);