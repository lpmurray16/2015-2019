#pragma once
// Program Id: StatsArray.h  SKELETON CODE
// Written By:  Super Smart Student!
// Date:
// Brief Description:  

#include <iostream>
#include <iomanip>
#include <cstdlib>    // Needed to use rand() and srand()
#include <time.h>     // Needed for time functions
using namespace std;

const int SIZE = 10;  // Number of elements in the array

class StatsArray
{

private:
	int data[SIZE];    // array holding SIZE int values

public:
	StatsArray();      // Constructor.  Initialize all elements of data[] to 0

	void   randomFill();
	int    getSize();
	void   display();
	int    getTotal();
	double getAvg();
	int    getLargest();
	int    getSmallest();
	int    countValues(int, int);
	bool   isNumberFound(int);

};

//********************implement functions here*******************

//constructor.  fills data[] array with 0s
StatsArray::StatsArray()
{
	for (int i = 0; i < SIZE; i++)
		data[i] = 0;
}

//fill data[] array with random numbers (double) in the range 0 -100
void StatsArray::randomFill()
{
	//seed the random number generator
	srand(static_cast<unsigned int>(time(NULL)));

	//Your code goes here to fill the array with random 
	//numbers from 0 – 100. Use a for loop! 

}

int StatsArray::getSize()
{
	return SIZE;
}

//display the contents of the array with the index in [ ] brackets
void StatsArray::display()
{
	//your code goes here 


}


// continue to implement the other functions 
