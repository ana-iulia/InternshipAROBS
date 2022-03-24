USE restaurant

SELECT * FROM OrderMenuItem
SELECT * FROM Customer
SELECT * FROM RestaurantTable
SELECT * FROM Waiter;
SELECT * FROM Shift;
SELECT * FROM RestaurantOrder;
SELECT * FROM Billing

--view customers number of orders and the total amount payed
CREATE VIEW customers_restaurant AS
SELECT c.first_name_c, c.last_name_c, COUNT(ro.code_o) AS 'orders', SUM(b.amount) as 'payed'
FROM Customer c INNER JOIN  RestaurantOrder ro
ON c.cod_c=ro.customer INNER JOIN Billing b
ON b.payment_id = ro.code_o
GROUP BY c.first_name_c,c.last_name_c

SELECT * FROM customers_restaurant

--view waiters that worked on 27.01.2022 between 14:00 and 15:00
ALTER VIEW employees_shift_restaurant AS
SELECT w.id, w.first_name, w.last_name
FROM Waiter w 
INNER JOIN  Shift s
ON s.waiter_id=w.id
GROUP BY w.id, w.first_name,w.last_name, s.date, s.start_hour, s.end_hour
HAVING s.date='2022-01-27' AND s.start_hour <= '14:00' AND s.end_hour >= '15:00'


SELECT * FROM employees_shift_restaurant

--view waiters that worked on 29.01.2022 but did not work on 27.01.2022 between 14:00 and 15:00
SELECT w.first_name,w.last_name
FROM Waiter w 
INNER JOIN Shift s ON s.waiter_id=w.id
LEFT JOIN employees_shift_restaurant e ON w.id = e.id
WHERE e.id IS NULL AND s.date = '2022-01-29'





