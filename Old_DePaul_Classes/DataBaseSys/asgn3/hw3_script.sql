/*
Logan Murray
CSC 355 - 502
02-04-2019
Assignment 3
*/

-- Query 1
SELECT Name FROM CUSTOMER
    ORDER BY Name;

-- Query 2
SELECT City, State, Zip FROM CUSTOMER
    WHERE State = 'AZ' OR State = 'CA' OR State = 'FL';

-- Query 3
SELECT Material, ProductID, Price FROM PRODUCT 
    WHERE DESCRIPTION = 'Wardrobe' ORDER BY MATERIAL; 
/*
One 'order by' is needed because by default the 
Oak wardrobes are ascending by price
*/

-- Query 4
SELECT Name, Zip FROM CUSTOMER
    WHERE Name LIKE '%Home%';

-- Query 5
SELECT DISTINCT STATE, COUNT(STATE) AS "COUNT" FROM CUSTOMER 
    GROUP BY STATE ORDER BY STATE;

-- Query 6
SELECT OrderDate, MAX(OrderID) FROM FULLORDER
    GROUP BY OrderDate ORDER BY ORDERDATE DESC;

-- Query 7
SELECT Price, Description FROM PRODUCT 
    WHERE Price > 400 ORDER BY Price DESC;

-- Query 8
SELECT DISTINCT CustomerID, MIN(OrderDate) FROM FULLORDER 
    GROUP BY CustomerID ORDER BY CUSTOMERID;

-- Query 9
SELECT DISTINCT OrderID, SUM(QUANTITY) AS "TOTAL_ITEMS" FROM REQUEST 
    GROUP BY ORDERID ORDER BY TOTAL_ITEMS DESC;

-- Query 10
SELECT ProductID, COUNT(DISTINCT OrderID) AS "UNIQUE_ORDERS" FROM REQUEST 
    GROUP BY ProductID ORDER BY UNIQUE_ORDERS;
