/*
Factorial.cpp
Logan Murray
CSC100AA
March 1, 2016
This program calculates the factorial of a number
1-10 and exits on 0
*/

#include<iostream>

using namespace std;

int main() {

	int value;
	int answer =1;
	
	do {
		cout << "****Factorial Calculator****\n\n";
		cout << "Please enter a value 1-10 (0 = exit program): ";
		cin >> value;

		while (value < 0 ||value>10) {
			cout << "Invalid Number. Needs to be a number 1-10 (0 to exit): ";
			cin >> value;
		}

		if (value != 0) {
			
			for (int a = 1; a <= value; a++) {
				answer = answer * a;
				}
		}
			
		cout << value << "! = " << answer << endl << endl;
			
		

	
		
	
	
	
	} while (value != 0);

   

  cout << "goodbye!\n";



	return(0);
}

/*
Works for the first value, then not for the rest
*/