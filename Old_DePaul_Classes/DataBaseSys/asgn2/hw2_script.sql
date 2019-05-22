/*
    Logan Murray
    CSC 355 - 502 Database Systems
    Assignment 2
    January 24, 2019
*/

DROP TABLE LISTING;
DROP TABLE AGENT;
DROP TABLE BUILDING;


CREATE TABLE AGENT 
(
    AID     CHAR(3), 
    Last    VARCHAR(20), 
    First   VARCHAR(20), 
    Phone   CHAR(10),

    PRIMARY KEY (AID)
);

CREATE TABLE BUILDING
(
    BID         CHAR(4), 
    Address     VARCHAR(25), 
    Zip         CHAR(5), 
    AskingPrice NUMBER(8,2)
                CHECK(0 <= AskingPrice),
    
    PRIMARY KEY (BID)
);

CREATE TABLE LISTING
(
    AgentID         CHAR(3),
    BuildingID      CHAR(4),
    StartingDate    DATE,
    EndingDate      DATE,

    PRIMARY KEY (StartingDate),
    FOREIGN KEY (AgentID) REFERENCES AGENT(AID),
    FOREIGN KEY (BuildingID) REFERENCES BUILDING(BID)
    
);

INSERT INTO BUILDING VALUES(1452, '421 Bristol Way', 60013, 450000.00);
INSERT INTO BUILDING VALUES(2563, '355 Motors Ave', 60010, 350750.00);
INSERT INTO BUILDING VALUES(4785, '1201 Glenview Court', 60014, 760500.00);
INSERT INTO BUILDING VALUES(5896, '655 Harvest Dr', 60013, 999999.00);

INSERT INTO AGENT VALUES(741, 'Murray', 'Logan', 8155271977);
INSERT INTO AGENT VALUES(852, 'Wise', 'Daniel', 8476398595);
INSERT INTO AGENT VALUES(963, 'McGurn', 'Jim', 2245161964);

INSERT INTO LISTING VALUES(741, 1452, DATE '2015-01-02', DATE '2015-08-15');
INSERT INTO LISTING VALUES(852, 2563, DATE '2015-02-22', DATE '2015-12-16');
INSERT INTO LISTING VALUES(963, 4785, DATE '2016-11-24', DATE '2017-05-04');
INSERT INTO LISTING VALUES(741, 5896, DATE '2017-09-13', DATE '2018-04-20');

INSERT INTO LISTING VALUES(852, 1452, DATE '2015-08-22', DATE '2016-03-16');
INSERT INTO LISTING VALUES(963, 2563, DATE '2016-01-02', DATE '2016-12-10');

SELECT * FROM AGENT;
SELECT * FROM BUILDING;
SELECT * FROM LISTING;

commit;






