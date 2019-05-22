// Program Id: MultiArrayTester.cpp  SKELETON CODE.  
// Written By:  Patricia Baker and Logan Murray
// Date: May 3rd, 2016
// Description:
//			This program uses a MultiStatsArray class to keep exam grades and report statistics
// 

#include <iostream>
#include <iomanip>

#include "MultiStatsArray.h"    //class declaration and implementation

using namespace std;

//function prototypes
bool tryAgain();


int main()
{
	MultiStatsArray examData; // Create an instance of the MultiStatsArray class
							  // to manage exam data.  10 rows, 5 columns


	do
	{
		//fill array with random exam scores	  
		examData.randomFill();

		cout << "Exam Scores" << endl;
		cout << "-----------" << endl;

		//display array and row total and row average
		examData.display();

		//display additional array statistics such as maximum, minimum, array total,
		//array average, number of A's, perfect score
		cout << endl;
		cout << "The minimum value is:\t" << examData.getSmallest() << endl;
		cout << "The maximum value:\t" << examData.getLargest() << endl;
		cout << "The total is:\t" << examData.getTotal() << endl;
		cout << "The average is:\t" << examData.getAvg() << endl;
		cout << "Number of A's:\t" << examData.countValues(90, 100) << endl;





	} while (tryAgain());

	system("pause");
	return 0;
}

//function implementation
bool tryAgain()
{
	bool flag = false;
	char again = 'Y';
	cout << "\nDo you want to try again?  (Y or N) ";
	cin >> again;
	cout << endl;
	if (toupper(again) == 'Y')
		flag = true;

	return flag;
}
