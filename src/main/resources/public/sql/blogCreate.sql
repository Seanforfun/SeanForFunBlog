#Create database:
create database blog

#User
CREATE TABLE USER(
	id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nickname VARCHAR(40) NOT NULL,
	NAME VARCHAR(40) NOT NULL,
	PASSWORD VARCHAR(40) NOT NULL,
	email VARCHAR(100) NOT NULL,
	pic varchar(255),
	activeTime BIGINT NOT NULL,
	lastLoginTime BIGINT,
	bio TEXT,
	country VARCHAR(60),
	province VARCHAR(60),
	city VARCHAR(60),
	activestatus INT(3) NOT NULL,
	url varchar(255) NOT NULL,
	intro text
);

#Category
CREATE TABLE category(
	id BIGINT PRIMARY KEY NOT NULL,
	category_type INT(2) NOT NULL,
	pid BIGINT,
	NAME VARCHAR(50) NOT NULL,
	uid BIGINT(20) NOT NULL,
	FOREIGN KEY(uid) REFERENCES USER(id),
	icon VARCHAR(255),
	link VARCHAR(255) NOT NULL,
	role INT(3) NOT NULL
)