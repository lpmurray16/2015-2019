// Program Id: StatsArrayTester.cpp SKELETON CODE
// Written By:  Patricia Baker and Super Smart Student
// Date: 
// Description:
//	 This program uses a StatsArray class to exam grades and reports statistics

#include <iostream>
#include <iomanip>
#include "StatsArray.h"    //StatsArray class declaration and implementation

using namespace std;

//function prototypes
bool tryAgain();


//*************************** tester program *****************************

int main()
{
	StatsArray examData;      // Create an instance of the StatsArray class
							  // to manage exam data 
	do
	{
		//fill array with random exam scores
		examData.randomFill();

		cout << "Exam Scores" << endl;
		cout << "-----------" << endl;
		//display array elements
		examData.display();

		//display additional array statistics such as maximum, minimum, total, average...



	} while (tryAgain());

	return 0;
}

//function implementation
bool tryAgain()
{
	char again = 'Y';
	bool flag = false;
	cout << "\nDo you want to try again?  (Y or N) ";
	cin >> again;

	if (toupper(again) == 'Y')
		flag = true;

	return flag;

}
