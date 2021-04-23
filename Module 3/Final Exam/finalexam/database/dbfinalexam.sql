drop database dbfinalexam;

create database dbfinalexam;

use dbfinalexam;

create table paymentmethods (
	id bigint auto_increment,
    `name` varchar(50),
    primary key (id));
    
INSERT INTO paymentmethods (`name`)
VALUES ('Month'),
		('Three Month'),
		('Year');

create table rentrooms (
	id bigint auto_increment,
    fullname varchar(255),
    phone varchar(10),
    startday varchar(20),
    note varchar(255),
    idpaymentmethod bigint,
    primary key (id),
    constraint rooms_fk foreign key (idpaymentmethod) references paymentmethods (id));
    
INSERT INTO rentrooms (fullname, phone, startday, note, idpaymentmethod)
VALUES ('Leo Messi','0123456789','2021-06-09','Note 1',1),
		('Nguyen Huu Nghia','0123456789','2022-06-09','Note 2',1),
		('Paul Pogba','0123456789','2021-06-09','Note 2',1);
        
DELIMITER $$
CREATE PROCEDURE search(IN textSearch VARCHAR(255))
BEGIN
	SELECT *
    FROM rentrooms
    WHERE id LIKE CONCAT ('%',textSearch,'%')
			OR fullname LIKE CONCAT ('%',textSearch,'%')
            OR phone LIKE CONCAT ('%',textSearch,'%');
END; $$
DELIMITER ;
    
call search('messi');

    