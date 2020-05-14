# Org-news
## Author
George Stephen Wangui yazz777stevie@gmail.com
## Description
this is an app where the user will be able to interact with the company's options
like seeing all the users of the company and also seeing a specific user of the company,
and will also be able to see all the department in a company and you can associate it with
the news from the department It also enables one to create departments within the company and add users onto it
This application has the ability to be an API key or an normal application
## Development
This application was created using : HTML, Java/Spark, CSS ,
tools like HandleBars,Postgresql,GSON were a great help in finishing the project
## Setup
If you would like to use this application, Use the application link above in the description
The routes to access the  general data are :<br/> /news for all general news,
/users for all users , <br/>
/departments for all departments , <br/> 
/special for  all departmental  news recorded ; <br/>
To post new users use the routes : <br/>
new users :  /users/new; <br/>
new departments : /department/new ; <br/>
new general news: /news/new ; <br/>
new departmental news : /special/news/new ; <br/>
To view individual data for( replace the :id  with numbers representing the id of the data ) <br/>
users : /users/:id ;<br/>
departments : departments/:id ;<br/>
news : /news/:id ; <br/>
departmental news : /special/news/:id ; <br/>
users in a department : /departments/:id/users ; <br/>
news of a individual department : /departments/:id/news ; <br/>
all posting are in the format of
for users <br/>
{ <br/>
name: "George stephen", <br/>
email: "yazz@gmail.com",<br/>
phone: "1234567",<br/>
departmentsId: "1" <br/>
} <br/>
for departments <br/>
{ <br/>
name: "Public relations", <br/>
story: "We deal with interactions with the community", <br/>
NoOfEmployees: "12" <br/>
} <br/>
CREATE DATABASE org_news ;  <br/>
\c org_news <br/>

CREATE TABLE users(id serial PRIMARY KEY , name VARCHAR, email VARCHAR, phone VARCHAR,position VARCHAR , departmentsid INT) ; <br/>
CREATE TABLE news(id serial PRIMARY KEY, news VARCHAR , author VARCHAR); <br/>
CREATE TABLE departments(id serial PRIMARY KEY , name VARCHAR , story VARCHAR, noofemployees int); <br/>
CREATE TABLE departmental(id serial PRIMARY KEY , news VARCHAR, author VARCHAR, departmentid int ); <br/>
CREATE DATABASE org_news_test WITH TEMPLATE org_news; <br/>
 ## License 
 This application is protected by MIT  License
 MIT License

Copyright (c) 2020 George Stephen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
