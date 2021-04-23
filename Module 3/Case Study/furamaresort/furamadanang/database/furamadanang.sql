DROP DATABASE dbfuramadanang;

CREATE DATABASE dbfuramadanang;

USE dbfuramadanang;

CREATE TABLE users (
    username VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (username)
);

INSERT INTO users (username, `password`)
VALUES ('username1','123123'),
		('username2','123123'),
        ('username3','123123'),
        ('username4','123123'),
        ('username5','123123'),
        ('username6','123123'),
		('username7','123123'),
        ('username8','123123'),
        ('username9','123123'),
        ('username10','123123'),
        ('username11','123123'),
		('username12','123123'),
        ('username13','123123'),
        ('username14','123123'),
        ('username15','123123'),
        ('username16','123123'),
		('username17','123123'),
        ('username18','123123'),
        ('username19','123123'),
        ('username20','123123');
        
INSERT INTO users (username, `password`)
VALUES ('username7','123123'),
        ('username8','123123'),
        ('username9','123123'),
        ('username10','123123');

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

INSERT INTO roles (`name`)
VALUES ('ROLE_USER'),
        ('ROLE_ADMIN');

CREATE TABLE userrole (
    roleid BIGINT,
    username VARCHAR(255),
    CONSTRAINT userrole_fk1 FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT userrole_fk2 FOREIGN KEY (roleid) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO userrole (roleid, username)
VALUES (1, 'username2'),
        (2, 'username1');

CREATE TABLE positions (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    CONSTRAINT positions_pk PRIMARY KEY (id)
);

INSERT INTO positions (`name`)
VALUES ('CEO'),
		('President'),
		('Manager'),
		('Leader'),
		('Member');
        
CREATE TABLE educations (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    CONSTRAINT educations_pk PRIMARY KEY (id)
);

INSERT INTO educations (`name`)
VALUES ('Professional'),
		('Bachelor'),
        ('Master'),
        ('Academic'),
        ('Professor');
        
CREATE TABLE departments (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    CONSTRAINT departments_pk PRIMARY KEY (id)
);

INSERT INTO departments (`name`)
VALUES ('HR'),
		('Marketing'),
        ('Sale'),
        ('IT'),
        ('Accountant');
        
CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT,
    fullname VARCHAR(45),
    birthday DATE,
    idnumber VARCHAR(12),
    salary DOUBLE,
    phonenumber VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    flag INT NOT NULL,
    positionid BIGINT,
    educationid BIGINT,
    departmentid BIGINT,
    username VARCHAR(255) UNIQUE,
    CONSTRAINT employees_pk PRIMARY KEY (id),
    CONSTRAINT employees_fk1 FOREIGN KEY (positionid) REFERENCES positions (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT employees_fk2 FOREIGN KEY (educationid) REFERENCES educations (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT employees_fk3 FOREIGN KEY (departmentid) REFERENCES departments (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT employees_fk4 FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO employees (fullname, birthday, idnumber, salary, phonenumber, email, address, flag, positionid, educationid, departmentid, username)
VALUES ('Nguyen Huu Nghia','1997-06-09','201731234',1000,'012345678','nghia@gmail.com','Da Nang',1,1,1,1,'username1'),
		('Ho Huu Khanh','1997-06-09','201731234',1000,'012345678','nghia@gmail.com','Hue',1,1,1,1,'username2'),
		('Tran Van Hoa','1997-06-09','201731234',1000,'012345678','nghia@gmail.com','Ha Noi',1,1,1,1,'username3'),
		('Khoa Tan','1997-06-09','201731234',1000,'012345678','nghia@gmail.com','Hai Phong',1,1,1,1,'username4'),
		('Dang Van Lam','1997-06-09','201731234',1000,'012345678','nghia@gmail.com','Quang Tri',1,1,1,1,'username5');
        
CREATE TABLE customertypes (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    CONSTRAINT customertypes_pk PRIMARY KEY (id)
);

INSERT INTO customertypes (`name`)
VALUES ('Diamond'),
	('Platinium'),
    ('Gold'),
    ('Silver'),
    ('Member');
    
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT,
    customercode VARCHAR(10) UNIQUE,
    fullname VARCHAR(45),
    birthday DATE,
    gender INT,
    idnumber VARCHAR(12),
    phonenumber VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    flag INT NOT NULL,
    customertypeid BIGINT,
    CONSTRAINT customers_pk PRIMARY KEY (id),
    CONSTRAINT customers_fk FOREIGN KEY (customertypeid) REFERENCES customertypes (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO customers (customercode, fullname, birthday, gender, idnumber, phonenumber, email, address, flag, customertypeid)
VALUES ('CU-0001','Nguyen Cong Phuong','2002-06-09',1,'201731234','012345678','nghia@gmail.com','Da Nang',1,1),
		('CU-0002','Nguyen Huy Hung','1997-06-09',1,'201731234','012345678','nghia@gmail.com','Ha Noi',1,2),
        ('CU-0003','Phan Van Long','1920-02-26',1,'201731234','012345678','nghia@gmail.com','Hai Phong',1,3),
        ('CU-0004','Nguyen Quang Hai','1956-06-09',1,'201731234','012345678','nghia@gmail.com','Quang Tri',1,4),
        ('CU-0005','Nguyen Van Toan','2002-06-09',1,'201731234','012345678','nghia@gmail.com','Vinh',1,5);
        
CREATE TABLE renttypes (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    cost DOUBLE,
    CONSTRAINT renttypes_pk PRIMARY KEY (id)
);

INSERT INTO renttypes (`name`, cost)
VALUES ('Year',12000),
		('Month',1000),
		('Day',50),
		('Hour',20);
        
CREATE TABLE servicetypes (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    CONSTRAINT servicetypes_pk PRIMARY KEY (id)
);

INSERT INTO servicetypes (`name`)
VALUES ('Villa'),
		('House'),
		('Room');
        
CREATE TABLE services (
    id BIGINT AUTO_INCREMENT,
    servicecode VARCHAR(10) UNIQUE,
    `name` VARCHAR(45),
    `area` INT,
    cost DOUBLE,
    maxpeople INT,
    roomstandard VARCHAR(45),
    `description` VARCHAR(255),
    poolarea INT,
    numberoffloor INT,
    flag BIT(1) NOT NULL,
    renttypeid BIGINT,
    servicetypeid BIGINT,
    CONSTRAINT services_pk PRIMARY KEY (id),
    CONSTRAINT services_fk1 FOREIGN KEY (renttypeid) REFERENCES renttypes (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT services_fk2 FOREIGN KEY (servicetypeid) REFERENCES servicetypes (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO services (servicecode, `name`, `area`, cost, maxpeople, roomstandard, `description`, poolarea, numberoffloor, flag, renttypeid, servicetypeid)
VALUES ('SV-0001','Villa',100,1000,12,'Luxury','Description villa',30,3,1,3,1),
		('SV-0002','House',70,700,8,'Business','Description house',20,2,1,3,2),
		('SV-0003','Room',20,400,4,'Family','Description room',20,1,1,3,3);
        
CREATE TABLE extraservices (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(45),
    cost DOUBLE,
    unit INT,
    `status` VARCHAR(45),
    CONSTRAINT extraservices_pk PRIMARY KEY (id)
);

INSERT INTO extraservices (`name`, cost, unit, `status`)
VALUES ('Massage',100,1,'Yes'),
		('Karaoke',200,1,'Yes'),
        ('Food',300,1,'Yes'),
        ('Drink',50,1,'Yes'),
        ('Car',150,1,'Yes');
        
CREATE TABLE contracts (
    id BIGINT AUTO_INCREMENT,
    startdate DATE,
    enddate DATE,
    deposit DOUBLE,
    totalpay DOUBLE,
    employeeid BIGINT,
    customerid BIGINT,
    serviceid BIGINT,
    CONSTRAINT contracts_pk PRIMARY KEY (id),
    CONSTRAINT contracts_fk1 FOREIGN KEY (employeeid) REFERENCES employees (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT contracts_fk2 FOREIGN KEY (customerid) REFERENCES customers (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT contracts_fk3 FOREIGN KEY (serviceid) REFERENCES services (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO contracts (startdate, enddate, deposit, totalpay, employeeid, customerid, serviceid)
VALUES ('2021-02-28','2021-03-02',100,0,1,1,3),
		('2021-02-28','2021-03-02',100,0,2,2,1),
        ('2019-01-28','2019-02-01',100,0,4,3,2),
        ('2019-02-28','2021-03-02',100,0,3,5,2),
        ('2019-03-28','2021-03-02',100,0,5,4,3),
        ('2019-07-28','2021-03-02',100,0,4,5,2),
        ('2019-05-28','2021-03-02',100,0,3,4,2),
        ('2019-12-28','2021-03-02',100,0,3,3,3),
        ('2019-02-15','2019-02-20',100,0,2,2,1),
        ('2019-09-28','2021-03-02',100,0,1,1,1);

CREATE TABLE contractdetails (
    id BIGINT AUTO_INCREMENT,
    quantity INT,
    contractid BIGINT,
    extraserviceid BIGINT,
    CONSTRAINT contractdetails_pk PRIMARY KEY (id),
    CONSTRAINT contractdetails_fk1 FOREIGN KEY (contractid) REFERENCES contracts (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT contractdetails_fk2 FOREIGN KEY (extraserviceid) REFERENCES extraservices (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO contractdetails (quantity, contractid, extraserviceid)
VALUES (1,1,1),
		(1,2,3),
        (1,3,5),
        (1,4,4),
        (1,5,2),
        (1,5,2),
        (1,4,2),
        (1,6,5),
        (1,7,2),
        (1,8,2),
        (1,10,5);
INSERT INTO contractdetails (quantity, contractid, extraserviceid)
VALUES (1,1,null),
		(1,2,null);

DELIMITER $$
CREATE PROCEDURE searchCustomer(IN textSearch VARCHAR(255))
BEGIN
	SELECT *
    FROM customers
    WHERE customercode LIKE CONCAT ('%',textSearch,'%')
			OR fullname LIKE CONCAT ('%',textSearch,'%')
            OR idnumber LIKE CONCAT ('%',textSearch,'%')
            OR phonenumber LIKE CONCAT ('%',textSearch,'%')
            OR email LIKE CONCAT ('%',textSearch,'%')
            OR address LIKE CONCAT ('%',textSearch,'%');
END; $$
DELIMITER ;

CALL searchCustomer('Hung');

DELIMITER $$
CREATE PROCEDURE searchEmployee(IN textSearch VARCHAR(255))
BEGIN
	SELECT *
    FROM employees
    WHERE fullname LIKE CONCAT ('%',textSearch,'%')
			OR idnumber LIKE CONCAT ('%',textSearch,'%')
            OR phonenumber LIKE CONCAT ('%',textSearch,'%')
            OR email LIKE CONCAT ('%',textSearch,'%')
            OR address LIKE CONCAT ('%',textSearch,'%');
END; $$
DELIMITER ;

CALL searchEmployee('da nang');

DELIMITER $$
CREATE PROCEDURE searchService(IN textSearch VARCHAR(255))
BEGIN
	SELECT *
    FROM services
    WHERE servicecode LIKE CONCAT ('%',textSearch,'%')
			OR `name` LIKE CONCAT ('%',textSearch,'%')
            OR roomstandard LIKE CONCAT ('%',textSearch,'%')
            OR description LIKE CONCAT ('%',textSearch,'%');
END; $$
DELIMITER ;

CALL searchService('ocean');

-- select username chưa được employee sử dụng
select users.username, users.password 
from users
left join employees 
on users.username = employees.username 
where employees.username is null;

select customers.customercode, customers.fullname, contracts.enddate, services.name, extraservices.name
from customers
inner join contracts
on customers.id = contracts.customerid
inner join services
on contracts.serviceid = services.id
inner join contractdetails
on contracts.id = contractdetails.contractid
left join extraservices
on contractdetails.extraserviceid = extraservices.id
where contracts.enddate >= curdate();

select curdate();

select employees.fullname, employees.username, users.password, roles.name
from employees
inner join users
on employees.username = users.username
inner join userrole
on users.username = userrole.username
inner join roles
on userrole.roleid = roles.id
where employees.username = 'username1' and users.password = '123123';
