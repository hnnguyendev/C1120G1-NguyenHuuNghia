CREATE DATABASE db5ex01;

USE db5ex01;

CREATE TABLE products (
	id INT NOT NULL AUTO_INCREMENT,
	productCode VARCHAR(20) NOT NULL,
	productName VARCHAR(255) NOT NULL,
	productPrice DOUBLE NOT NULL,
	productAmount INT NOT NULL,
	productDescription VARCHAR(255) NOT NULL,
	productStatus VARCHAR(50),
    CONSTRAINT products_pk PRIMARY KEY (id)
);

INSERT INTO products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES ('P0001', 'Vinamilk', 10000, 4, 'Sua me la tot nhat cho suc khoe cua tre so sinh va tre nho', 'Yes'),
		('P0002', 'TH True Milk', 10000, 4, 'Trang trai bo sua lon nhat Dong Nam A', 'Yes'),
        ('P0003', 'Ong tho', 10000, 4, 'Nguoi dan ong nhieu sua nhat the gioi', 'Yes'),
        ('P0004', 'Co gai Ha Lan', 10000, 4, 'Nguoi phu nu nuoi song hang ti dua tre tren trai dat', 'Yes'),
        ('P0005', 'Nutri food', 10000, 4, 'Sua trai cay', 'Yes');
        
-- index

EXPLAIN 
SELECT * 
FROM products
WHERE productCode = 'P0005';

ALTER TABLE products
ADD UNIQUE INDEX idx_productCode(productCode);

ALTER TABLE products
DROP INDEX idx_productCode;

EXPLAIN 
SELECT * 
FROM products
WHERE productName = 'Co gai Ha Lan' OR productPrice = '10000';

ALTER TABLE products
ADD INDEX idx_name_price(productName, productPrice);

-- view

CREATE VIEW products_view
AS
SELECT productCode, productName, productPrice, productStatus
FROM products;

CREATE OR REPLACE VIEW products_view
AS
SELECT *
FROM products;

SELECT *
FROM products_view;

DROP VIEW products_view;

-- stored procedure

DELIMITER $$
CREATE PROCEDURE findAllProducts()
BEGIN
	SELECT * 
    FROM products;
END; $$
DELIMITER ;

CALL findAllProducts();

-- insert product

DELIMITER $$
CREATE PROCEDURE insertProduct(
	IN product_code VARCHAR(20),
    IN product_name VARCHAR(255),
    IN product_price DOUBLE,
    IN product_amount INT,
    IN product_description VARCHAR(255),
    IN product_status VARCHAR(50)
)
BEGIN
	INSERT INTO products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (product_code, product_name, product_price, product_amount, product_description, product_status);
END; $$
DELIMITER ;

CALL insertProduct('P0006', 'Milo', 5000, 5, 'Ong hut 4 chieu', 'Yes');

-- update product

DELIMITER $$
CREATE PROCEDURE updateProduct(
	IN product_code VARCHAR(20),
    IN product_name VARCHAR(255),
    IN product_price DOUBLE,
    IN product_amount INT,
    IN product_description VARCHAR(255),
    IN product_status VARCHAR(50),
    IN product_id INT
)
BEGIN
	UPDATE products
    SET productCode = product_code,
		productName = product_name,
        productPrice = product_price,
        productAmount = product_amount,
        productDescription = product_description,
        productStatus = product_status
	WHERE id = product_id;
END; $$
DELIMITER ;

CALL updateProduct('P0002', 'TH Truemilk', 7000, 2, 'Trang trai bo sua lon nhat Dong Nam A', 'Yes', 2);

-- delete product

DELIMITER $$
CREATE PROCEDURE deleteProduct(IN product_id INT)
BEGIN
	DELETE
    FROM products
    WHERE id = product_id;
END; $$
DELIMITER ;

CALL deleteProduct(1);