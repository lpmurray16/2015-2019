-- my first script!

CREATE TABLE INFO
(
	StudentID	CHAR(3)
				PRIMARY KEY,
	Name		VARCHAR(20),
	ExamDate	DATE,
	Score		NUMBER(3,0)
				DEFAULT 0
				CHECK (0 <= Score AND Score <= 100)
);

INSERT INTO INFO
		VALUES ('779', 'Schwabe', DATE '2019-01-14', 91);
		
INSERT INTO INFO
		VALUES ('817', 'Murray', DATE '2019-01-11', 89);
		
INSERT INTO INFO (StudentID, Name)
		VALUES('241', 'Miller');
		
SELECT * FROM INFO;