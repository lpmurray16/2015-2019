//Ch 3 Activity 4
//Program ID:  MilesPerGallonEnhanced
//Author:  Logan Murray
//Date Written:  Feb 10, 2016
//Class : CSC100AA or CIS162AB
//Brief Description:
//			This program calculates how many miles per gallon a vehicle gets.
//
//			Uses string, rand, formatting

#include <iostream>    //must include if you want to use cout
#include <string>      //needed for string datatype
#include <cstdlib>     //needed for rand
#include <ctime>       //needed for time function
#include <iomanip>     //needed for formatting
using namespace std;

int main()
{
	//define your variables: gallons, miles and milesPerGallon, lname


	double gallons;         // gas tank capacity in gallons
	double miles;	         // miles driven on one tank. 
	double milesPerGallon;   // miles per gallon. 
	string lname;			  // last name
	unsigned seed;

	//prompt the user for the driver's last name and read in the value
	cout << "Please enter your last name:\n";
	getline(cin, lname);
	cout << "Hello " << lname<<".\n";



	//prompt the user for the gas tank capacity and read in the value
	cout << "Enter gas tank capacity in gallons:\n ";
	cin >> gallons;

	//Randomly generate the miles driven.  Must be a number between 100 - 200;
	//rand() % n returns 0 - (n-1)
	seed = time(0);
	srand(seed);
	miles = 100 + rand() % 101;


	//Now calculate milesPerGallon
	milesPerGallon = miles / gallons;


	//These statements will display your results. 
	//Display milesPerGallon with exactly 2 decimal places

	cout << endl << lname << " drove " << miles << " miles on "<< gallons << " gallons of gas.\n";

	cout << "The car got " << milesPerGallon << " miles per gallon.\n\n";

	system("Pause");
	return 0;
}

/*Test Output

Please enter your last name:
murray
Hello murray.
Enter gas tank capacity in gallons:
13

murray drove 199 miles on 13 gallons of gas.
The car got 15.3077 miles per gallon.

Press any key to continue . . .




*/