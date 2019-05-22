#include<iostream>
#include<cstdlib>
#include<string>
#include<cmath>
#include<iomanip>

using namespace std;

double calculatePay(double, double);


int main() {
	char doAgain;
	
	cout << "*Paycheck Calc*\n----------------\n";
	do {
		double rateOfPay = 0;
		double hoursWorked = 0;
		cout << setprecision(2) << fixed;
		cout << "Please enter your rate of pay: ";
		cin >> rateOfPay;
		while (rateOfPay < 0) {
			cout << "Number must be greater than 0: ";
			cin >> rateOfPay;
		}
		cout << "\nNow please enter how many hours you worked: ";
		cin >> hoursWorked;
		while (hoursWorked < 0) {
			cout << "Number must be greater than 0: ";
			cin >> hoursWorked;
		}
		double grossPay = calculatePay(rateOfPay, hoursWorked);
		cout << "\nYou should recieve: $" << grossPay << endl;


		


      cout << "Would you like to use it again? Y or N: ";
		cin >> doAgain;

	} while (doAgain == 'Y' || doAgain == 'y');

	cout << "\nThanks for using the Pay Check Calculator!\n GoodBye!"<<endl;
	cin.get();
  return (0);
}

//Calculates gross pay, before taxes.
double calculatePay(double rate, double hours) {
	double grossPay;
	grossPay = rate * hours;
	return grossPay;
}



