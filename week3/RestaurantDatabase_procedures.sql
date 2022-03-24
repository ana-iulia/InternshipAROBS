USE restaurant

CREATE TABLE TriggerModifications
(cod INT PRIMARY KEY IDENTITY,
table_name VARCHAR(50) NOT NULL,
operation_name VARCHAR(50) NOT NULL,
operation_date_time DATETIME NOT NULL);

ALTER TRIGGER dbo.triggerAddWaiter
ON Waiter
FOR INSERT AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO TriggerModifications(table_name, operation_name, operation_date_time)
	VALUES('Waiter', 'INSERT', GETDATE())
END;

ALTER TRIGGER dbo.triggerAddShift
ON Shift
FOR INSERT AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO TriggerModifications(table_name, operation_name, operation_date_time)
	VALUES('Shift', 'INSERT', GETDATE())
END;

ALTER TRIGGER dbo.triggerUpdateWaiter
ON Waiter
FOR UPDATE AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO TriggerModifications(table_name, operation_name, operation_date_time)
	VALUES('Waiter', 'UPDATE', GETDATE())
END;

ALTER TRIGGER dbo.triggerDeleteWaiter
ON Waiter
FOR DELETE AS
BEGIN
	SET NOCOUNT ON
	INSERT INTO TriggerModifications(table_name, operation_name, operation_date_time)
	VALUES('Waiter', 'DELETE', GETDATE())
END;



--verify if a parameter is char
CREATE FUNCTION dbo.verif_char(@c VARCHAR(50))
RETURNS INT
AS
BEGIN
	IF isnumeric(@c)=1
	BEGIN
		SET @c=0
	END
	ELSE
	BEGIN
		IF (@c >= 'a') 
		BEGIN
			SET @c=1
		END
	END
	RETURN @c
END;

--verify if a parameter is phonenumber
ALTER FUNCTION dbo.verif_phonenumber(@p INT)
RETURNS INT
AS
BEGIN
	IF isnumeric(@p)!=1
	BEGIN
		SET @p=0
	END
	ELSE
	BEGIN
		IF (@p > 0) 
		BEGIN
			DECLARE @count INT
			SET @count = 0
			WHILE @p > 0
			BEGIN
				SET @count = @count+1
				SET @p = @p / 10
			END
			IF(@count = 9)
			BEGIN
				SET @p=1
			END
		END
	END
	RETURN @p
END;



ALTER FUNCTION dbo.viewWaitersByPhone(@phoneNumber INT)
RETURNS TABLE
AS
RETURN
(
	SELECT w.id, w.first_name,w.last_name,s.date
	FROM Waiter w 
	INNER JOIN Shift s ON s.waiter_id=w.id
	WHERE w.contact=@phoneNumber
);



--add in tables waiter and shift
ALTER PROCEDURE addWaiter 
	@firstname VARCHAR(50), 
	@lastname VARCHAR(50), 
	@phoneNumber INT

AS
BEGIN
--verify parameters
	IF(dbo.verif_char(@firstname)=1 AND dbo.verif_char(@lastname)=1 AND dbo.verif_phonenumber(@phoneNumber)=1)
	BEGIN
		INSERT INTO Waiter(first_name, last_name, contact)
		VALUES(@firstname,@lastname,@phoneNumber)
		DECLARE @dateStart	DATE = '2022-01-01'
				,@dateEnd	DATE = '2022-03-20'
		DECLARE @dateShift DATE

		IF(EXISTS(
			SELECT first_name,last_name
			FROM Waiter
			WHERE first_name=@firstname AND last_name=@lastname))
		BEGIN
			SET @dateShift = (SELECT DATEADD(DAY, RAND() * DATEDIFF(DAY, @dateStart, @dateEnd), @dateStart))
			DECLARE @idWaiter INT
			SET @idWaiter = (SELECT id FROM Waiter WHERE first_name=@firstname AND last_name=@lastname)
			INSERT INTO Shift(date,start_hour, end_hour, waiter_id)
			VALUES(@dateShift,'10:00','18:00',@idWaiter)
		END
		ELSE
		BEGIN
			THROW 50001,'Waiter does ot exist!',1;
		END
	END
	ELSE
	BEGIN
		THROW 50001,'Invalid input!',1;
	END
	PRINT('Procedure addWaiter is done.');
END



--delete from tabels waiter and shift
CREATE PROCEDURE deleteWaiter 
	@firstname VARCHAR(50), 
	@lastname VARCHAR(50)

AS
BEGIN
IF(EXISTS(
	SELECT first_name,last_name
	FROM Waiter
	WHERE first_name=@firstname AND last_name=@lastname))
	BEGIN
		DECLARE @id INT
		SET @id = (SELECT id	FROM Waiter	
					WHERE first_name=@firstname AND last_name=@lastname)
		DELETE FROM Shift
		WHERE @id=waiter_id
		DELETE FROM Waiter
		WHERE @id=id
		IF(@@ROWCOUNT > 0)
		BEGIN
			PRINT('Waiter was deleted');
		END
	END
ELSE
BEGIN
	THROW 50001,'Waiter does ot exist!',1;
END
PRINT('Procedure is done.');
END

--update in table waiter
ALTER PROCEDURE updateWaiter 
	@firstname VARCHAR(50), 
	@lastname VARCHAR(50), 
	@phoneNumber INT

AS
BEGIN
--verify parameters
	IF(dbo.verif_char(@firstname)=1 AND dbo.verif_char(@lastname)=1 AND dbo.verif_phonenumber(@phoneNumber)=1)
	BEGIN
		IF(EXISTS(
			SELECT first_name,last_name
			FROM Waiter
			WHERE first_name=@firstname AND last_name=@lastname))
		BEGIN
			UPDATE Waiter SET contact = @phoneNumber
			WHERE (first_name = @firstname AND last_name = @lastname)
		END
		ELSE
		BEGIN
			THROW 50001,'Waiter does ot exist!',1;
		END
	END
	ELSE
	BEGIN
		THROW 50001,'Invalid input!',1;
	END
	PRINT('Procedure addWaiter is done.');
END



--CRUD operations for Waiter
ALTER PROCEDURE [dbo].[CRUD_Waiter]
	@firstname VARCHAR(50),
	@lastname VARCHAR(50),
	@phonenumber INT
	
AS
BEGIN

	BEGIN TRY
		EXEC addWaiter @firstname, @lastname, @phonenumber
		SELECT * FROM dbo.viewWaitersByPhone(@phoneNumber)
		SELECT* FROM TriggerModifications
		SET @phonenumber = 0741523678
		EXEC updateWaiter @firstname, @lastname, @phonenumber
		SELECT * FROM dbo.viewWaitersByPhone(@phoneNumber)
		SELECT* FROM TriggerModifications
		EXEC deleteWaiter @firstname, @lastname
		SELECT* FROM TriggerModifications
		PRINT 'S-au executat cu succes operatiile CRUD pentru tabelul People'
	END TRY
	BEGIN CATCH
		PRINT 'NAME OF THE PROCEDURE THAT GENERATED ERROR IS: '+ERROR_PROCEDURE()
		PRINT 'THE LINE IS: '+CONVERT(VARCHAR(50),ERROR_LINE())
		PRINT ERROR_MESSAGE()
	END CATCH
	
END;

--Tests
EXEC dbo.CRUD_Waiter 'Alexandra','Marin',0712345678 --correct
EXEC dbo.CRUD_Waiter '','Marin',0712345678 -- char error
EXEC dbo.CRUD_Waiter 'Alexandra','',0712345678 --char error
EXEC dbo.CRUD_Waiter 'Alexandra','Marin',071 --phonenumber error


