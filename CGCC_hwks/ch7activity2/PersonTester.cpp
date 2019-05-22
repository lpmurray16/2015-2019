//Program ID:  PersonTester.cpp
//Author : Pbaker
//Date : April 8th, 2016 
//
//Brief Description:
//         Tester program for creating Person objects
//         Person class definition can be found in Person.h

#include <iostream>
#include <cmath>
#include <iomanip>
#include <string>

#include "Person.h"   //Person class definition

using namespace std;


//main that creates Person objects

int main()
{
	string pName;
	int pBirthYear;
	int pAge;
	int currentYear;
	string doAgain = "n";
	int count = 1;



	cout << "Creating Person objects" << endl;
	cout << "-----------------------" << endl;

	cout << "Enter the current year: ";
	cin >> currentYear;
	cin.ignore(); //reads the dangling newline 

	do
	{
		cout << "\nPerson #" << count << endl;
		cout << "Enter a name please: ";
		getline(cin, pName); //allows you to enter multiple words 
		cout << "Enter a birth year : ";
		cin >> pBirthYear;

		Person teacher(pName, pBirthYear); //create a Person object
		cout << "\nThe Person data is:" << endl;
		teacher.displayData(currentYear);
		cout << endl;

		cin.ignore(); //reads the dangling newline 
		cout << "Try again? (Y/N)";
		getline(cin, doAgain);
		count++;

	} while (doAgain == "y" || doAgain == "Y");


}

/* sample output

Creating Person objects
-----------------------
Enter the current year: 2014

Person #1
Enter a name please: Minnie Mouse
Enter an birth year: 1928

The Person data is:
Name: Minnie Mouse
Birth Year: 1928
Age: 86

Try again? (Y/N)y

Person #2
Enter a name please: Donald Duck
Enter an birth year: 1934

The Person data is:
Name: Donald Duck
Birth Year: 1934
Age: 80

Try again? (Y/N)n

*/