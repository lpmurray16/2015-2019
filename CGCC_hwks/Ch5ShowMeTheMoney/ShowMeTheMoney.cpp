/*
ShowMeTheMoney.cpp
Logan Murray
March 7, 2016
CSC100AA
This program calculates and displays daily and monthly pay using
multiple loops
*/



#include<iostream>


using namespace std;

int main() {
          
	char userResponse;
	
	do {

		int daysWorked;
		double dailyPay = 0.01;
		
		

		cout << "How many days did the employee work this month? ";
		cin >> daysWorked;

		while (daysWorked < 1 || daysWorked > 31) {
			cout << "\nPlease enter a number between 1 and 31 ";
				cin >> daysWorked;
		}

		cout << "Day\t Pay\n";
		cout << "--------------\n";
		double monthlyPay = 0;
		for (int day = 1; day <= daysWorked; day++) {
			cout << day << "\t" << dailyPay << "\n";
			dailyPay = dailyPay * 2;
			monthlyPay = monthlyPay + dailyPay;
			}
		
		cout << "--------------\n";
		cout << "Total: $   "<<monthlyPay<<endl ;















	
		cout << "Would you like to try again? <Y or N> ";
		cin >> userResponse;
	
	
	} while (userResponse == 'Y' || userResponse == 'y');



	cout << "Goodbye!\n";



   return(0);
}

/*
How many days did the employee work this month? 3
Day      Pay
--------------
1       0.01
2       0.02
3       0.04
--------------
Total: $   0.14
Would you like to try again? <Y or N> y
How many days did the employee work this month? 45

Please enter a number between 1 and 31 -2

Please enter a number between 1 and 31 7
Day      Pay
--------------
1       0.01
2       0.02
3       0.04
4       0.08
5       0.16
6       0.32
7       0.64
--------------
Total: $   2.54
Would you like to try again? <Y or N> n
Goodbye!
Press any key to continue . . .*/