use restaurant

--dirty reads part2
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
BEGIN TRANSACTION
SELECT * FROM Waiter
WAITFOR DELAY '00:00:15'
SELECT * FROM Waiter
COMMIT TRANSACTION

--solution: SET TRANSACTION ISOLATION LEVEL TO READ COMMITTED
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
BEGIN TRANSACTION
SELECT * FROM Waiter
WAITFOR DELAY '00:00:15'
SELECT * FROM Waiter
COMMIT TRANSACTION



--nonrepeatable reads part2
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
BEGIN TRANSACTION
SELECT * FROM Waiter
WAITFOR DELAY '00:00:15'
SELECT * FROM Waiter
COMMIT TRANSACTION


--solution: SET TRANSACTION ISOLATION LEVEL TO REPEATABLE READ
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
BEGIN TRANSACTION
SELECT * FROM Waiter
WAITFOR DELAY '00:00:15'
SELECT * FROM Waiter
COMMIT TRANSACTION


--phantom reads part2
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
BEGIN TRANSACTION
SELECT * FROM Waiter
WAITFOR DELAY '00:00:15'
SELECT * FROM Waiter
COMMIT TRANSACTION

--solution: SET TRANSACTION ISOLATION LEVEL TO SERIALIZABLE
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
BEGIN TRANSACTION
SELECT * FROM Waiter
WAITFOR DELAY '00:00:15'
SELECT * FROM Waiter
COMMIT TRANSACTION