CREATE DATABASE org_news ;
\c org_news

CREATE TABLE users(id serial PRIMARY KEY , name VARCHAR, email VARCHAR, phone VARCHAR,position VARCHAR , departmentsid INT)
CREATE TABLE news(id serial PRIMARY KEY, news VARCHAR , author VARCHAR);
CREATE TABLE departments(id serial PRIMARY KEY , name VARCHAR , story VARCHAR, noofemployees int);
CREATE TABLE departmental(id serial PRIMARY KEY , news VARCHAR, author VARCHAR, departmentid int );
CREATE DATABASE org_news_test WITH TEMPLATE org_news;