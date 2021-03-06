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
	intro text,
	admin int(3) not null,
	ipAddr varchar(100)
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

#Badge
CREATE TABLE badge(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10) NOT NULL,
	color INT NOT NULL
);

#Article
CREATE TABLE article(
	id BIGINT(30) PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	cid BIGINT NOT NULL,
	FOREIGN KEY(cid) REFERENCES category(id),
	TYPE INT NOT NULL,
	#badge many to many relatioship
	hit BIGINT NOT NULL,
	lastmodifytime BIGINT NOT NULL,
	publishTime BIGINT,
	uid BIGINT NOT NULL,
	FOREIGN KEY(uid) REFERENCES USER(id),
	abst TEXT NOT NULL,
	content TEXT NOT NULL,
	accessTime bigint not null default 0,
	publish int(2) not null default 0,
	allowComments INT(3) NOT NULL DEFAULT 0,
	inuse int(3) not null default 1,
	mid bigint,
	FOREIGN KEY(mid) REFERENCES MONTH(id)
);

#Intermediate article_badge
#Need to use trigger modify this table when doing update, delete, create if we change data in article or badge
CREATE TABLE article_badge(
	id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	aid BIGINT NOT NULL,
	FOREIGN KEY(aid) REFERENCES article(id),
	bid BIGINT,
	FOREIGN KEY(bid) REFERENCES badge(id),
);

#Add foreign key for existing field
ALTER TABLE article_badge ADD FOREIGN KEY (aid) REFERENCES article(id)

#Link
CREATE TABLE link(
	id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(100) NOT NULL,
	link VARCHAR(255) NOT NULL,
	descript varchar(255) not null
);

#Album
CREATE TABLE album(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(100) NOT NULL
);

#Image
CREATE TABLE image(
	id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(200),
	path VARCHAR(100) NOT NULL,
	removeHash varchar(255) not null,
	aid BIGINT,
	FOREIGN KEY(aid) REFERENCES article(id),
	alid BIGINT,
	FOREIGN KEY(alid) REFERENCES album(id)
);

#Access
CREATE TABLE access(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	dayAccessNum BIGINT NOT NULL DEFAULT 0,
	currentTime BIGINT NOT NULL
);

#Month
CREATE TABLE MONTH(
	id BIGINT primary key AUTO_INCREMENT NOT NULL,
	DATE DATETIME NOT NULL
);