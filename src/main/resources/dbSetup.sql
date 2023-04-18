DROP DATABASE IF EXISTS fatcatDB;
CREATE DATABASE fatcatDB;
USE fatcatDB;

CREATE TABLE person(
                       id int PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       sector int NOT NULL,
                       description VARCHAR(100) NOT NULL,
                       danger int NOT NULL
);

CREATE TABLE sectors(
                        id int PRIMARY KEY AUTO_INCREMENT,
                        guards int
);

CREATE TABLE adminsettings(
                              id int PRIMARY KEY AUTO_INCREMENT,
                              totalguards int NOT NULL,
                              totalsectors int NOT NULL
);