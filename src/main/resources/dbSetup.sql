DROP DATABASE IF EXISTS fatcatDB;
CREATE DATABASE fatcatDB;
USE fatcatDB;

CREATE TABLE person(
                       id int PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       sector VARCHAR(40) NOT NULL,
                       description VARCHAR(250) NOT NULL,
                       danger VARCHAR(40) NOT NULL
);

CREATE TABLE sectors(
                        id int PRIMARY KEY AUTO_INCREMENT,
                        guards VARCHAR(100)
);

CREATE TABLE adminsettings(
                              id int PRIMARY KEY AUTO_INCREMENT,
                              totalguards VARCHAR(100) NOT NULL,
                              totalsectors VARCHAR(40) NOT NULL
);