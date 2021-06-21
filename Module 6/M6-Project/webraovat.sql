DROP DATABASE dbwebraovat;

CREATE DATABASE dbwebraovat;

USE dbwebraovat;

CREATE TABLE category (
	categoryId INT AUTO_INCREMENT,
    categoryName VARCHAR(50),
    CONSTRAINT category_pk PRIMARY KEY (categoryId)
);

CREATE TABLE child_category (
	childCategoryId INT AUTO_INCREMENT,
    childCategoryName VARCHAR(50),
    categoryId INT,
    CONSTRAINT child_category_pk PRIMARY KEY (childCategoryId),
    CONSTRAINT child_category_fk FOREIGN KEY (categoryId) REFERENCES category(categoryId)
);

CREATE TABLE `status` (
	statusId INT AUTO_INCREMENT,
    statusName VARCHAR(50),
    CONSTRAINT status_pk PRIMARY KEY (statusId)
);

CREATE TABLE province (
	provinceId INT AUTO_INCREMENT,
    provinceName VARCHAR(50),
    CONSTRAINT province_pk PRIMARY KEY (provinceId)
);

-- CREATE TABLE district (
-- 	districtId INT AUTO_INCREMENT,
--     districtName VARCHAR(50),
--     provinceId INT,
--     CONSTRAINT district_pk PRIMARY KEY (districtId),
--     CONSTRAINT district_fk FOREIGN KEY (provinceId) REFERENCES province(provinceId)
-- );

CREATE TABLE `account` (
	username VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(255),
    registerDate DATE,
    CONSTRAINT account_pk PRIMARY KEY (username)
);

CREATE TABLE `user` (
	userId INT AUTO_INCREMENT,
    username VARCHAR(50),
    `name` VARCHAR(50),
	email VARCHAR(50),
	phone VARCHAR(20),
	address VARCHAR(50),
	avatarUrl VARCHAR(255),
    CONSTRAINT user_pk PRIMARY KEY (userId),
    -- CONSTRAINT user_fk1 FOREIGN KEY (districtId) REFERENCES district(districtId),
    CONSTRAINT user_fk FOREIGN KEY (username) REFERENCES `account`(username)
);

CREATE TABLE `role` (
	roleId INT AUTO_INCREMENT,
    roleName VARCHAR(50),
    CONSTRAINT role_pk PRIMARY KEY (roleId)
);

CREATE TABLE account_role (
	accountRoleId INT AUTO_INCREMENT,
    roleId INT,
    username VARCHAR(50),
    CONSTRAINT user_role_pk PRIMARY KEY (accountRoleId),
    CONSTRAINT user_role_fk1 FOREIGN KEY (roleId) REFERENCES `role`(roleId),
    CONSTRAINT user_role_fk2 FOREIGN KEY (username) REFERENCES `account`(username)
);

CREATE TABLE post (
	postId INT AUTO_INCREMENT,
    `name` VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(50),
    address VARCHAR(50),
    title VARCHAR(50),
    postType BIT,
    postDateTime DATETIME,
    statusId INT,
    `enable` BIT,
    childCategoryId INT,
    price INT,
    `description` TEXT,
    provinceId INT,
    userId INT,
    CONSTRAINT post_pk PRIMARY KEY (postId),
    CONSTRAINT post_fk1 FOREIGN KEY (statusId) REFERENCES `status`(statusId),
    CONSTRAINT post_fk2 FOREIGN KEY (childCategoryId) REFERENCES child_category(childCategoryId),
    CONSTRAINT post_fk3 FOREIGN KEY (provinceId) REFERENCES province(provinceId),
    CONSTRAINT post_fk4 FOREIGN KEY (userId) REFERENCES `user`(userId)
);

CREATE TABLE image (
	imageId INT AUTO_INCREMENT,
    url VARCHAR(255),
    postId INT,
    CONSTRAINT image_pk PRIMARY KEY (imageId),
    CONSTRAINT image_fk FOREIGN KEY (postId) REFERENCES post(postId)
);

CREATE TABLE banner (
	bannerId INT AUTO_INCREMENT,
    position VARCHAR(50),
    size VARCHAR(50),
    duration DATETIME(6),
    image VARCHAR(255),
    CONSTRAINT banner_pk PRIMARY KEY (bannerId)
);







