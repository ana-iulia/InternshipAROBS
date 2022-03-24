USE restaurant

INSERT INTO OrderMenuItem(name,description,price)
VALUES('CHICKEN GYRO','Slices of seasoned chicken gyro meat', 14.50);
INSERT INTO OrderMenuItem(name,description,price)
VALUES('PORK SOUVLAKI','Pita Grilled, marinated pork medallion', 14.50);
INSERT INTO OrderMenuItem(name,description,price)
VALUES('CHICKEN SOUVLAKI PLATTER','Grilled marinated chicken medallions', 21);
INSERT INTO OrderMenuItem(name,description,price)
VALUES('MOUSSAKA','Layers of eggplant with meat sauce', 22);

SELECT * FROM OrderMenuItem

INSERT INTO Customer(first_name_c, last_name_c, phone_number_c)
VALUES('Amariei','Andrei', 0712457814)
INSERT INTO Customer(first_name_c, last_name_c, phone_number_c)
VALUES('Borcan','Ioana', 0778573648)
INSERT INTO Customer(first_name_c, last_name_c, phone_number_c)
VALUES('Popa','Crina', 0796547802)

SELECT * FROM Customer


INSERT INTO RestaurantTable(seats)
VALUES(2)
INSERT INTO RestaurantTable(seats)
VALUES(2)
INSERT INTO RestaurantTable(seats)
VALUES(4)
INSERT INTO RestaurantTable(seats)
VALUES(4)
INSERT INTO RestaurantTable(seats)
VALUES(4)
INSERT INTO RestaurantTable(seats)
VALUES(6)
INSERT INTO RestaurantTable(seats)
VALUES(6)
INSERT INTO RestaurantTable(seats)
VALUES(8)

SELECT * FROM RestaurantTable


INSERT INTO Waiter(first_name, last_name, contact)
VALUES('Andrei','Cosma',0796584526)
INSERT INTO Waiter(first_name, last_name, contact)
VALUES('Maria','Anton',0789345762)
INSERT INTO Waiter(first_name, last_name, contact)
VALUES('Diana','Vrabie',0763584587)

SELECT * FROM Waiter;


INSERT INTO Shift(date,start_hour, end_hour, waiter_id)
VALUES('2022-01-27','14:00','18:00',1)
INSERT INTO Shift(date,start_hour, end_hour, waiter_id)
VALUES('2022-01-27','10:00','15:00',2)
INSERT INTO Shift(date,start_hour, end_hour, waiter_id)
VALUES('2022-01-28','16:00','20:00',1)
INSERT INTO Shift(date,start_hour, end_hour, waiter_id)
VALUES('2022-01-28','11:00','18:00',2)
INSERT INTO Shift(date,start_hour, end_hour, waiter_id)
VALUES('2022-01-29','13:00','18:00',3)

SELECT * FROM Shift;


INSERT INTO RestaurantOrder(date, time, restaurant_table, customer, menu_item, waiter)
VALUES('2022-01-27','12:00',4,1,9,2)
INSERT INTO RestaurantOrder(date, time, restaurant_table, customer, menu_item, waiter)
VALUES('2022-01-27','14:00',5,2,1,2)
INSERT INTO RestaurantOrder(date, time, restaurant_table, customer, menu_item, waiter)
VALUES('2022-01-28','17:00',3,3,9,1)
INSERT INTO RestaurantOrder(date, time, restaurant_table, customer, menu_item, waiter)
VALUES('2022-01-28','14:00',1,1,2,3)

SELECT * FROM RestaurantOrder;
SELECT * FROM OrderMenuItem

INSERT INTO Billing(payment_id, payment_type, amount)
VALUES(4,'card', 21)
INSERT INTO Billing(payment_id, payment_type, amount)
VALUES(5,'card',14.5)
INSERT INTO Billing(payment_id, payment_type, amount)
VALUES(6,'cash', 21)
INSERT INTO Billing(payment_id, payment_type, amount)
VALUES(8,'card', 22)

SELECT * FROM Billing