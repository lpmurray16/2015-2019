//Program Name: TwoNumbers.cpp
//Author: Logan Murray
//Date Written: Jan 27, 2016
//Class : CSC100AA or CIS162AB
//Brief Description: Calculates and displays the sum, difference, product, and quotient of two number variables

#include <iostream>

using namespace std;

int main()
{
	double num1 = 25; //first number as variable num1
	double num2 = 75; //second number as variable num2

	double sum = num1 + num2; //sum, as variable for the sum
	double dif = num2 - num1; //dif, variable for the difference
	double prod = num1*num2; //prod, variable for the product
	double quo = num2 / num1; //quo, variable for the quotient

	cout << "The variables are:\t" << num1 << " and " << num2<<"\n\n";
	
	cout << "\tSum:\t        " << sum << "\n";
	cout << "\tDifference:\t" << dif << "\n";
	cout << "\tProduct:\t" << prod << "\n";
	cout << "\tQuotient:\t" << quo << "\n";


	cout << endl;
	return 0;
}

/* OUTPUT

The variables are:      25 and 75

Sum:            100
Difference:     50
Product:        1875
Quotient:       3

Press any key to continue . . .

*/