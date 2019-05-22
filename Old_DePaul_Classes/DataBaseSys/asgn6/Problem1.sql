/*
Logan Murray
March 13, 2019
CSC 355 - 502
Assignment 6 [Problem1.sql]
*/

-- This first section is SQL code taken directly from the Homework
-- Problem 1 (uncomment when needed)

/*DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;
CREATE TABLE EMPLOYEE
(
	ID		CHAR(5),
	Name		VARCHAR2(16),
	Hours		NUMBER(2),

	CONSTRAINT PK_EMPLOYEE
		PRIMARY KEY (ID)
);
INSERT INTO EMPLOYEE VALUES ('22144', 'Anderson', 30);
INSERT INTO EMPLOYEE VALUES ('31902', 'Bruford', 45);
INSERT INTO EMPLOYEE VALUES ('42771', 'Wakeman', 20);
INSERT INTO EMPLOYEE VALUES ('82889', 'Howe', 40);
SELECT * FROM EMPLOYEE;

DROP TABLE PAYINFO;
CREATE TABLE PAYINFO
(
	Regular	NUMBER(5,2),
	Overtime	NUMBER(5,2),
	HourLimit	NUMBER(2)
);
INSERT INTO PAYINFO VALUES (12.00, 18.50, 30);
SELECT * FROM PAYINFO;
COMMIT;
*/



-- PL/SQL code for Problem 1 below

declare
    --Variables for the PAYINFO table
    cRegular PAYINFO.Regular%type;
    cOvertime PAYINFO.Overtime%type;
    cHourLimit PAYINFO.HourLimit%type;
    
    --Variables for the EMPLOYEE table
    cID EMPLOYEE.ID%type;
    cName EMPLOYEE.Name%type;
    cHours EMPLOYEE.Hours%type;
    
    --Global variables to use in output
    totalHour NUMBER(5,2);
    payrollSum NUMBER(6,2) : = 0.0;
    
    -- cursor to point into EMPLOYEE table
    cursor employeePtr is SELECT * FROM EMPLOYEE;

begin
    SELECT Regular, Overtime, HourLimit
    INTO cRegular, cOvertime, cHourLimit
    FROM PAYINFO;
    
    dbms_output.put_line('Payroll data is: ' || cRegular || ', ' || cOvertime || ', ' || cHourLimit);
    dbms_output.put_line('');
    
    open employeePtr;
    
    loop
        fetch employeePtr into cID, cName, cHours;
        
        if employeePtr%found then
            --Calculate each employees total pay
            if cHours <= cHourLimit then
                totalHour:=cHours*cRegular;
                
            elsif cHours > cHourLimit then
                totalHour:= (cRegular * cHourLimit) + (cOvertime * (cHours - cHourLimit));
                
            end if;
            
            -- increase the payroll total based on current totalHour
            payrollSum := payrollSum + totalHour;
            
            -- display results per employee
            dbms_output.put_line(cID || ' ' || cName || ' ' || totalHour);
        else
            exit;
        end if;
    end loop;
    
    dbms_output.put_line('');
    dbms_output.put_line('Payroll total is ' || payrollSum);
    
    close employeePtr;
end;

