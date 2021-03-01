CREATE DATABASE db4ex01;

USE db4ex01;

CREATE TABLE students (
	id INT NOT NULL AUTO_INCREMENT,
    studentname VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    CONSTRAINT students_pk PRIMARY KEY (id)
);

INSERT INTO students (studentname, age, course, amount)
VALUES ('Hoang', 21, 'CNTT', 400000),
		('Viet', 19, 'DTVT', 400000),
		('Thanh', 18, 'KTDN', 400000),
		('Nhan', 19, 'CK', 400000),
		('Huong', 20, 'TCNH', 400000),
        ('Huong', 20, 'TCNH', 400000);
		
SELECT *
FROM students
WHERE studentname = 'Huong';

SELECT studentname, SUM(amount) AS total
FROM students
GROUP BY studentname
HAVING studentname = 'Huong';

SELECT DISTINCT studentname
FROM students;