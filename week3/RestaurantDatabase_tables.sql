CREATE DATABASE restaurant

USE restaurant

CREATE TABLE Customer
(cod_c INT PRIMARY KEY IDENTITY,
first_name_c VARCHAR(50) NOT NULL,
last_name_c VARCHAR(50) NOT NULL,
phone_number_c INT NOT NULL);

SELECT * FROM Customer


CREATE TABLE OrderMenuItem
(item_id INT PRIMARY KEY IDENTITY,
name VARCHAR(50) NOT NULL,
description VARCHAR(50) NOT NULL,
price FLOAT NOT NULL);

SELECT * FROM OrderMenuItem;

CREATE TABLE RestaurantTable
(table_id INT PRIMARY KEY IDENTITY,
seats INT NOT NULL);

SELECT * FROM RestaurantTable;


CREATE TABLE Waiter
(id INT PRIMARY KEY IDENTITY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
contact INT NOT NULL);

SELECT * FROM Waiter;

CREATE TABLE Shift
(cod_s INT PRIMARY KEY IDENTITY,
date DATE NOT NULL,
start_hour TIME NOT NULL,
end_hour TIME NOT NULL,
waiter_id INT FOREIGN KEY REFERENCES Waiter(id));

SELECT * FROM Shift;

CREATE TABLE RestaurantOrder
(code_o INT PRIMARY KEY IDENTITY,
date DATE NOT NULL,
time TIME NOT NULL,
restaurant_table INT FOREIGN KEY REFERENCES RestaurantTable(table_id),
customer INT FOREIGN KEY REFERENCES Customer(cod_c),
menu_item INT FOREIGN KEY REFERENCES OrderMenuItem(item_id),
waiter INT FOREIGN KEY REFERENCES Waiter(id));

--bill INT FOREIGN KEY REFERENCES Billing(payment_id)

SELECT * FROM RestaurantOrder;

CREATE TABLE Billing(
payment_id INT FOREIGN KEY REFERENCES RestaurantOrder(code_o),
payment_type VARCHAR(50), 
amount FLOAT NOT NULL,
CONSTRAINT pk_bill PRIMARY KEY (payment_id));

SELECT * FROM Billing

