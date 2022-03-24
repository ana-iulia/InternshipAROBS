use restaurant

--dirty reads part1
--UPDATE Waiter SET contact = 0711111111 WHERE last_name = 'Cosma'
BEGIN TRANSACTION
UPDATE Waiter SET contact = 0700000000 WHERE last_name = 'Cosma'
WAITFOR DELAY '00:00:10'
ROLLBACK TRANSACTION



--nonrepeatable reads part1
--DELETE FROM Waiter WHERE last_name = 'Coman'
INSERT INTO Waiter(first_name, last_name, contact)
VALUES('Irina','Coman',0799999999)
BEGIN TRANSACTION
WAITFOR DELAY '00:00:10'
UPDATE Waiter SET contact = 0711111111 WHERE last_name = 'Coman'
COMMIT TRANSACTION



--phantom reads part1
--DELETE FROM Waiter WHERE last_name = 'Trifan'
BEGIN TRANSACTION
WAITFOR DELAY '00:00:10'
INSERT INTO Waiter(first_name, last_name, contact)
VALUES('Denisa','Trifan',0733333333)
COMMIT TRANSACTION