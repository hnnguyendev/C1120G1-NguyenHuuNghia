CREATE DATABASE dblibmanagement;

USE dblibmanagement;

CREATE TABLE categories (
	categoryid VARCHAR(15) NOT NULL UNIQUE,
    categoryname VARCHAR(255),
    CONSTRAINT categories_pk PRIMARY KEY (categoryid)
);

CREATE TABLE books (
	bookid VARCHAR(15) NOT NULL UNIQUE,
    bookname VARCHAR(255) NOT NULL,
    publishcompany VARCHAR(255) NOT NULL,
    publishyear VARCHAR(4) NOT NULL,
    numofpublish INT NOT NULL,
    price DOUBLE NOT NULL,
    image VARCHAR(255) NOT NULL,
    categoryid VARCHAR(15) NOT NULL,
    CONSTRAINT books_pk PRIMARY KEY (bookid),
    CONSTRAINT books_fk FOREIGN KEY (categoryid) REFERENCES categories(categoryid)
);

CREATE TABLE authors (
	authorid VARCHAR(15) NOT NULL UNIQUE,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    bookid VARCHAR(15) NOT NULL,
    CONSTRAINT authors_pk PRIMARY KEY (authorid),
    CONSTRAINT authors_fk FOREIGN KEY (bookid) REFERENCES books(bookid)
);

CREATE TABLE students (
	studentid VARCHAR(15) NOT NULL UNIQUE,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    image VARCHAR(255) NOT NULL,
    CONSTRAINT students_pk PRIMARY KEY (studentid)
);

CREATE TABLE address (
	addressid VARCHAR(15) NOT NULL UNIQUE,
    district VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    studentid VARCHAR(15) NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (addressid),
    CONSTRAINT address_fk FOREIGN KEY (studentid) REFERENCES students(studentid)
);

CREATE TABLE borroworders (
	orderid VARCHAR(15) NOT NULL UNIQUE,
    borrowdate DATE NOT NULL,
    expiredate DATE NOT NULL,
    returndate DATE NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    studentid VARCHAR(15) NOT NULL UNIQUE,
    CONSTRAINT borroworders_pk PRIMARY KEY (orderid),
    CONSTRAINT borroworders_fk FOREIGN KEY (studentid) REFERENCES students(studentid)
);

CREATE TABLE detailborroworders (
	bookid VARCHAR(15) NOT NULL,
    orderid VARCHAR(15) NOT NULL,
    CONSTRAINT detailborroworders_pk PRIMARY KEY (bookid, orderid),
    CONSTRAINT detailborroworders_fk1 FOREIGN KEY (bookid) REFERENCES books(bookid),
    CONSTRAINT detailborroworders_fk2 FOREIGN KEY (orderid) REFERENCES borroworders(orderid)
);
