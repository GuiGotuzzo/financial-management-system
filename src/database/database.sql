DROP DATABASE IF EXISTS financial_management_system;
CREATE DATABASE financial_management_system;
USE financial_management_system;

CREATE TABLE expenses(
	id int not null auto_increment primary key,
    name varchar(150) not null,
    description text not null,
    expense double not null
);

CREATE TABLE revenue(
	id int not null auto_increment primary key,
    name varchar(150) not null,
    description text not null,
    revenue double not null
);