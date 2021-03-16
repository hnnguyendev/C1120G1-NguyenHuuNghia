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
        
DELIMITER $$
CREATE PROCEDURE findAllUser()
BEGIN
	SELECT *
    FROM
    users;
END; $$
DELIMITER ;

CALL findAllUser();

DELIMITER $$
CREATE PROCEDURE updateUser(
	IN userName VARCHAR(255),
    IN userEmail VARCHAR(255),
    IN userCountry VARCHAR(255),
    IN userId INT
)
BEGIN
	UPDATE users 
    SET `name` = userName, email = userEmail, country = userCountry
    WHERE id = userId;

END; $$
DELIMITER ;

CALL updateUser("Mata", "mata@gmail.com", "Tây Ban Nha", 1);

DELIMITER $$
CREATE PROCEDURE deleteUser(
    IN userId INT
)
BEGIN
	DELETE
    FROM users
    WHERE id = userId;

END; $$
DELIMITER ;

CALL deleteUser(1);