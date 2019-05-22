/*
Logan Murray
March 13, 2019
CSC 355 - 502
Assingment 6 [Problem2.sql]
*/

-- SQL code to build needed tables below (uncomment when needed)

/*DROP TABLE STUDENT CASCADE CONSTRAINTS;
DROP TABLE MAJOR CASCADE CONSTRAINTS;

CREATE TABLE MAJOR
(
	MajName	VARCHAR2(10)	
			PRIMARY KEY,
	MajCount	NUMBER(2)
);

INSERT INTO MAJOR VALUES ('Comp Sci', 0);
INSERT INTO MAJOR VALUES ('Soft Eng', 0);
INSERT INTO MAJOR VALUES ('Info Tech', 0);

CREATE TABLE STUDENT
(
	StuID		CHAR(7)	
			PRIMARY KEY,
	StuName	VARCHAR2(12),
	StuMajor	VARCHAR2(10)	
			REFERENCES MAJOR(MajName)
);

SELECT * FROM MAJOR;
COMMIT;
*/

-- PL/SQL code for Problem2 (Triggers) down below

-- The FIRST TRIGEGR handles INSERTs into the STUDENT table
CREATE OR REPLACE TRIGGER AddingStudent
        AFTER INSERT ON STUDENT
FOR EACH ROW

begin
  dbms_output.put_line('Adding student to STUDENT ' || :new.StuName);
  --After the insert is made, the MAJOR table should update
  UPDATE MAJOR
  SET MajCount = MajCount + 1
  WHERE MajName = :new.StuMajor; 
end;

-- The SECOND TRIGGER handles UPDATEs on STUDENT
CREATE OR REPLACE TRIGGER UpdateStudent
        BEFORE UPDATE ON STUDENT
FOR EACH ROW

begin
  --Cancels any update and throws error
  RAISE_APPLICATION_ERROR(-20001, 'No updates are permitted on STUDENT');
end;

-- The THIRD TRIGGER handles deletion on STUDENT table
CREATE OR REPLACE TRIGGER DeleteStudent
        AFTER DELETE ON STUDENT
FOR EACH ROW

begin
  dbms_output.put_line('Removing student from STUDENT ' || :old.StuName);
  --After the deletion is made, the MAJOR table should update
  UPDATE MAJOR
  SET MajCount = MajCount - 1
  WHERE MajName = :old.StuMajor; 
end;