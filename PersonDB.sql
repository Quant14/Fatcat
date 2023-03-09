CREATE DATABASE fatcatDB;
USE fatcatDB;

CREATE TABLE Person(
	id int PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	sector VARCHAR(10) NOT NULL,
    description VARCHAR(300) NOT NULL,
    danger ENUM("LOW", "MEDIUM", "HIGH") NOT NULL
);