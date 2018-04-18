#Create database:
create database blog

#User
CREATE TABLE USER(
	id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nickname VARCHAR(40) NOT NULL,
	NAME VARCHAR(40) NOT NULL,
	PASSWORD VARCHAR(40) NOT NULL,
	email VARCHAR(100) NOT NULL,
	activeTime BIGINT NOT NULL,
	lastLoginTime BIGINT,
	bio TEXT,
	country VARCHAR(60),
	province VARCHAR(60),
	city VARCHAR(60),
	activestatus INT(3) NOT NULL	
);