/*
Asterisks.cpp
Logan Murray
March 7, 2016
CSC100AA
Displays a pattern of asterisks dependent upon user input
*/




#include<iostream>

using namespace std;

int main() {
	int pattern;
	
	do {
		

		cout << "Enter the total amount of asteriks to display 1-10 (0 to quit): ";
		cin >> pattern;
		while (pattern < 0 || pattern>10) {
			cout << "Number has to be between 1 and 10 (0 to quit): ";
			cin >> pattern;
		}

		for (int row = 1; row <= pattern; row++) {
			for (int col = 1; col <= row; col++)
				cout << "*";
			cout << endl;
		}

		//for (int row = 10; row <= pattern; row++) {
			//for (int col = 10; col <= row; col++)
			//	cout << "*";
		//	cout << endl;
		//}

		




	} while (pattern != 0);
	
	cout << "Goodbye!\n";
		
		return(0);
}