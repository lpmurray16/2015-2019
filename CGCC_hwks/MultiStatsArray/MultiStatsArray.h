#pragma once
// Program Id: MultiStatsArray.h   SKELETON CODE.
// Written By:  Patricia Baker and Logan Murray
// Date: May 3rd, 2016
// Description:
//			This program uses a MultiStatsArray class to keep exam grades and report statistics
// 

#include <iostream>
#include <iomanip>
#include <cstdlib>          // Needed to use rand() and srand()
#include <time.h>		    // Needed for time functions
using namespace std;

const int ROWSIZE = 10;     // Number of rows in the array 
const int COLSIZE = 5;      // Numbe of columns in each row of the array

class MultiStatsArray
{
private:
	int data[ROWSIZE][COLSIZE];    // 2DArray holding ROWSIZE x COLSIZE int values

public:
	MultiStatsArray();               // Constructor.  Initialize all elements to 0


	void   randomFill();
	int    getRowSize();
	int    getColSize();
	int    getTotal();
	int    getRowTotal(int);
	double getAvg();
	double getRowAvg(int);
	int    getLargest();
	int    getSmallest();
	int    countValues(int, int);
	bool   isNumberFound(int);
	void   display();

};

/************************************************************
*                  MultiStatsArray constructor             *
*                       fill array with 0
************************************************************/
MultiStatsArray::MultiStatsArray()
{
	for (int r = 0; r < ROWSIZE; r++)
		for (int c = 0; c < COLSIZE; c++)
			data[r][c] = 0;
}

//Continue to implement the other functions here
void MultiStatsArray::randomFill()
{
	//seed the random number generator
	srand(time(0));
	
	//your code goes here to fill the array with 
	//random numbers from 0 - 100. Use a nested for loop! 
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++)
			data[r][c] = 0 + rand() % 101;
	}
}

int MultiStatsArray::getRowSize()
{
	return ROWSIZE;
}


int MultiStatsArray::getColSize()
{
	return COLSIZE;
}

void MultiStatsArray::display()
{
	//your code here
	for (int row = 0; row < ROWSIZE; row++)
		cout << "[" << row << "]\t";
		for (int r = 0; r < ROWSIZE; r++) {
			for (int c = 0; c < COLSIZE; c++) {
				cout << data[r][c] << "\t";
			}
		}
		
	
	

	
}

//still more methods to implement
int MultiStatsArray::getTotal() {
	int sum = 0;
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++) {
			sum += data[r][c];
		}
	}
	return sum;
}

int MultiStatsArray::getRowTotal(int r) {
	int sum = 0;
	for (int c = 0; c < COLSIZE; c++)
		sum += data[r][c];
	return sum;
}

double MultiStatsArray::getAvg() {
	double avg = 0.0;
	double sum = 0.0;
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++) {
			sum += data[r][c];
			avg = sum / (ROWSIZE*COLSIZE);
		}
	}

	return avg;
}

double MultiStatsArray::getRowAvg(int r) {
	double sum = 0.0;
	double avg = 0.0;
	for (int c = 0; c < COLSIZE; c++) {
		sum += data[r][c];
		avg = sum / (COLSIZE);
	}
	return avg;
}

int MultiStatsArray::getLargest() {
	int max = data[0][0];
	
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++) {
			if (data[r][c] > max)
				max = data[r][c];
		}
	}
	return max;
}

int MultiStatsArray::getSmallest() {
	int min = data[0][0];
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++) {
			if (data[r][c] < min)
				min = data[r][c];
		}
	}
	return min;
}

int MultiStatsArray::countValues(int lowRange, int highRange) {
	int count = 0;
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++) {
			if (data[r][c] >= lowRange&&data[r][c] <= highRange) {
				count++;
			}
		}
	}
	return count;
}

bool MultiStatsArray::isNumberFound(int someNumber) {
	for (int r = 0; r < ROWSIZE; r++) {
		for (int c = 0; c < COLSIZE; c++) {
			if (data[r][c] == someNumber) {
				return true;
			}else {return false;}
		}
         
	}
}



