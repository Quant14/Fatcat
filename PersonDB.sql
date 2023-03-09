USE fatcatDB;

CREATE TABLE Person(
	id int PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	sector VARCHAR(10) NOT NULL,
    description VARCHAR(300) NOT NULL,
    danger int CHECK(danger >=1 AND danger <=5) NOT NULL
);
