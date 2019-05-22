//Exam.cpp
//Logan Murray
//CSC100AA
//Feb 10, 2016
//This program calculates the average of three exam scores and displays it

#include<iostream>
#include<iomanip>


using namespace std;

int main() {

	int exam1,
		exam2,
		exam3;
	double average;

	cout << "Please enter the three exam scores separated by a space:\n";
	cin >> exam1 >> exam2 >> exam3;
	
	cout << fixed << showpoint << setprecision(1);

	average = static_cast<double>(exam1 + exam2 + exam3) / 3;
	
	cout << "\n\nYour average test score is:  " << average << endl;

	return(0);
}

/*

Please enter the three exam scores separated by a space:
90 91 100


Your average test score is:  93.7
Press any key to continue . . .


*/