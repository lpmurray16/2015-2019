/*
	Furniture2019.sql
	Eric J. Schwabe
	January 23rd, 2019

	Script to set up CUSTOMER, ORDERTABLE, ORDERLINE, PRODUCT tables
	for CSC 355 Assignment 3

	Sample data modified from Modern Database Management (7th edition),
		Hoffer, Prescott, McFadden
	
	For use in assignment only -- do not copy...
*/

-- drop tables

DROP TABLE REQUEST CASCADE CONSTRAINTS;
DROP TABLE FULLORDER CASCADE CONSTRAINTS;
DROP TABLE PRODUCT CASCADE CONSTRAINTS;
DROP TABLE CUSTOMER CASCADE CONSTRAINTS;

-- create and link tables

CREATE TABLE CUSTOMER
(
	CustomerID	INTEGER,
	Name		VARCHAR2(40),
	City		VARCHAR2(20),
	State		CHAR(2),
	Zip		CHAR(5),

	CONSTRAINT PK_CUSTOMER
		PRIMARY KEY (CustomerID)
);
CREATE TABLE PRODUCT
(
	ProductID	INTEGER,
	Description	VARCHAR2(30),
	Material	VARCHAR2(20),
	Price		NUMBER(5,2),

	CONSTRAINT PK_PRODUCT
		PRIMARY KEY (ProductID)
);
CREATE TABLE FULLORDER
(	OrderID		INTEGER,
	OrderDate	DATE,
	CustomerID	INTEGER,

	CONSTRAINT PK_FULLORDER
		PRIMARY KEY (OrderID),

	CONSTRAINT FK_FULLORDER_CUSTOMER
		FOREIGN KEY (CustomerID)
		REFERENCES CUSTOMER(CustomerID)
);
CREATE TABLE REQUEST
(
	OrderID		INTEGER,
	ProductID	INTEGER,
	Quantity	INTEGER,

	CONSTRAINT PK_REQUEST
		PRIMARY KEY (OrderID, ProductID),

	CONSTRAINT FK_REQUEST_FULLORDER
		FOREIGN KEY (OrderID)
		REFERENCES FULLORDER(OrderID),

	CONSTRAINT FK_REQUEST_PRODUCT
		FOREIGN KEY (ProductID)
		REFERENCES PRODUCT(ProductID)
);

-- populate tables

INSERT INTO CUSTOMER VALUES
	(1, 'Mannys Home Style', 'Newburgh', 'NY', '12550');
INSERT INTO CUSTOMER VALUES
	(2, 'Furniture-palooza', 'Hauppauge', 'NY', '11788');
INSERT INTO CUSTOMER VALUES
	(3, 'Finer Home Furniture', 'Hartford', 'CT', '06167');
INSERT INTO CUSTOMER VALUES
	(4, 'Midwest Antique Furnishings', 'Lansing', 'MI', '48922');
INSERT INTO CUSTOMER VALUES
	(5, 'Californian Comfort', 'Irvine', 'CA', '92612');
INSERT INTO CUSTOMER VALUES
	(6, 'Unpainted Arizona', 'Sedona', 'AZ', '87507');
INSERT INTO CUSTOMER VALUES
	(7, 'Furthur Furnishings', 'San Francisco', 'CA', '94121');
INSERT INTO CUSTOMER VALUES
	(10, 'Coastal Casuals', 'Miami', 'FL', '33101');
INSERT INTO CUSTOMER VALUES
	(11, 'Mountain Forest Home', 'Oregon City', 'OR', '97045');
INSERT INTO CUSTOMER VALUES
	(12, 'Classic Home', 'Albany', 'NY', '12209');
INSERT INTO CUSTOMER VALUES
	(13, 'East Coast Furnishings', 'Nutley', 'NJ', '07110');
INSERT INTO CUSTOMER VALUES
	(14, 'Home Impressions', 'Fort Myers', 'FL', '33901');
INSERT INTO CUSTOMER VALUES
	(15, 'Mountain Furniture', 'Boulder', 'CO', '80514');
INSERT INTO CUSTOMER VALUES
	(16, 'Vintage Furniture', 'Ann Arbor', 'MI', '48103');
INSERT INTO CUSTOMER VALUES
	(17, 'Home Design Classics', 'Simsbury', 'CT', '06070');
INSERT INTO CUSTOMER VALUES
	(20, 'M and H Casual Furniture and Stuff', 'Seattle', 'WA', '98105');
INSERT INTO CUSTOMER VALUES
	(21, 'Seminole Interiors', 'Seminole', 'FL', '34646');
INSERT INTO PRODUCT VALUES
	(101, 'Dining Table', 'Oak', 500.00);
INSERT INTO PRODUCT VALUES
	(102, 'Dining Table', 'Maple', 475.00);
INSERT INTO PRODUCT VALUES	
	(103, 'Dining Table', 'Maple', 500.00);
INSERT INTO PRODUCT VALUES
	(104, 'Dining Table', 'Oak', 250.00);
INSERT INTO PRODUCT VALUES
	(105, 'Wardrobe', 'Oak', 300.00);
INSERT INTO PRODUCT VALUES
	(106, 'Wardrobe', 'Pine', 375.00);
INSERT INTO PRODUCT VALUES
	(107, 'Wardrobe', 'Oak', 425.00);
INSERT INTO PRODUCT VALUES
	(208, 'Entertainment Center', 'Cherry', 550.00);
INSERT INTO PRODUCT VALUES
	(209, 'Entertainment Center', 'Pine', 350.00);
INSERT INTO FULLORDER VALUES
	(1001, DATE '2017-12-30', 10);
INSERT INTO FULLORDER VALUES
	(1002, DATE '2017-12-30', 5);
INSERT INTO FULLORDER VALUES
	(1003, DATE '2017-12-30', 12);
INSERT INTO FULLORDER VALUES
	(1004, DATE '2018-01-15', 13);
INSERT INTO FULLORDER VALUES
	(1005, DATE '2018-02-03', 20);
INSERT INTO FULLORDER VALUES
	(1006, DATE '2018-02-03', 6);
INSERT INTO FULLORDER VALUES
	(1007, DATE '2018-03-10', 13);
INSERT INTO FULLORDER VALUES
	(1008, DATE '2018-08-01', 20);
INSERT INTO FULLORDER VALUES
	(1009, DATE '2018-08-01', 13);
INSERT INTO FULLORDER VALUES
	(1010, DATE '2018-09-30', 6);
INSERT INTO FULLORDER VALUES
	(1011, DATE '2018-09-30', 2);
INSERT INTO FULLORDER VALUES
	(1012, DATE '2019-01-15', 10);
INSERT INTO FULLORDER VALUES
	(1013, DATE '2019-01-15', 1);
INSERT INTO FULLORDER VALUES
	(1014, DATE '2019-01-15', 7);
INSERT INTO FULLORDER VALUES
	(1015, DATE '2019-01-15', 20);
INSERT INTO FULLORDER VALUES
	(1016, DATE '2018-01-20', 7);
INSERT INTO FULLORDER VALUES
	(1017, DATE '2018-01-23', 20);
INSERT INTO REQUEST VALUES
	(1001, 106, 2);
INSERT INTO REQUEST VALUES
	(1001, 102, 2);
INSERT INTO REQUEST VALUES
	(1001, 104, 1);
INSERT INTO REQUEST VALUES
	(1002, 103, 3);
INSERT INTO REQUEST VALUES
	(1003, 103, 4);
INSERT INTO REQUEST VALUES
	(1004, 208, 2);
INSERT INTO REQUEST VALUES
	(1004, 104, 1);
INSERT INTO REQUEST VALUES
	(1005, 104, 4);
INSERT INTO REQUEST VALUES
	(1006, 104, 2);
INSERT INTO REQUEST VALUES
	(1006, 103, 2);
INSERT INTO REQUEST VALUES
	(1006, 102, 2);
INSERT INTO REQUEST VALUES
	(1007, 106, 4);
INSERT INTO REQUEST VALUES
	(1007, 102, 5);
INSERT INTO REQUEST VALUES
	(1008, 103, 1);
INSERT INTO REQUEST VALUES
	(1008, 208, 1);
INSERT INTO REQUEST VALUES
	(1010, 104, 5);
INSERT INTO REQUEST VALUES
	(1010, 107, 4);
INSERT INTO REQUEST VALUES
	(1011, 208, 5);
INSERT INTO REQUEST VALUES
	(1012, 106, 1);
INSERT INTO REQUEST VALUES
	(1013, 106, 2);
INSERT INTO REQUEST VALUES
	(1013, 209, 1);
INSERT INTO REQUEST VALUES
	(1014, 101, 1);
INSERT INTO REQUEST VALUES
	(1015, 102, 1);
INSERT INTO REQUEST VALUES
	(1016, 103, 1);
INSERT INTO REQUEST VALUES
	(1017, 104, 2);
COMMIT;

-- display tables

SELECT * FROM CUSTOMER;
SELECT * FROM PRODUCT;
SELECT * FROM FULLORDER;
SELECT * FROM REQUEST