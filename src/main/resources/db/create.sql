SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users(
id int PRIMARY KEY auto_increment,
Name VARCHAR;
age int;
email VARCHAR;
phone VARCHAR;
position VARCHAR;
Roles VARCHAR;
departmentId int;
);
CREATE TABLE IF NOT EXISTS departments(
id int PRIMARY KEY auto_increment,
Name VARCHAR;
Description VARCHAR;
Employees int;
);
CREATE TABLE IF NOT EXISTS news(
id int PRIMARY KEY auto_increment,
news VARCHAR;
author VARCHAR;
);
CREATE TABLE IF NOT EXISTS departmentalNews(
id int PRIMARY KEY auto_increment,
news VARCHAR;
author VARCHAR;
departmentId int;
);