/*
Program Name: Cyborg.cpp
Author: Logan Murray
Date Written: Jan 31st, 2016
Class : CSC100AA or CIS162AB
Brief Description: Determines the amount of memory (number of bytes) used by certain
data types and displays them on the screen.
*/

#include <iostream>

using namespace std;

int main()
{
	cout << "  The Cyborg Computer Statistics\n\n";
	
	cout << "The size of a char is\t" << sizeof(char)<<" byte.\n";
	cout << "The size of an int is\t" << sizeof(int) << " bytes.\n";
	cout << "The size of a float is\t" << sizeof(float) << " bytes.\n";
	cout << "The size of a double is\t" << sizeof(double) << " bytes.\n";

	cout << "\nAnd just for grins...\n";
	cout << "The size of a short is  \t" << sizeof(short) << " bytes.\n";
	cout << "The size of a long integer is\t" << sizeof(long) << " bytes.\n";
	cout << "The size of a long double is\t" << sizeof(_LONGDOUBLE) << " bytes.\n" << endl;
	
	return 0;
}

/* OUTPUT
The Cyborg Computer Statistics

The size of a char is   1 byte.
The size of an int is   4 bytes.
The size of a float is  4 bytes.
The size of a double is 8 bytes.

And just for grins...
The size of a short is          2 bytes.
The size of a long integer is   4 bytes.
The size of a long double is    8 bytes.

Press any key to continue . . .

*/