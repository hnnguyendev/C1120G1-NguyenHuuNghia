CREATE DATABASE dbusermanagement;

USE dbusermanagement;

CREATE TABLE users (
	id INT AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    CONSTRAINT users_pk PRIMARY KEY (id)
);

INSERT INTO users (`name`, email, country)
VALUES ("Juan Mata Garcia", "mata8@gmail.com", "Spain"),
		("Leo Messi", "leomessi@gmail.com", "Argentina"),
        ("Cristiano Ronaldo", "cr7@gmail.com", "Portugal"),
        ("Robert Lewandowski", "robert@gmail.com", "Poland"),
        ("Kenvin de Bruyne", "kenvin@gmail.com", "Belgium");