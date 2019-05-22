//Program Name:  Bank.cpp Student Starting File
//Author:  Patricia Baker and Logan Murray
//		   parts from Gaddis
//
//
//Brief Description:  This is the tester/driver application
// for the BankAccount  and CheckingAccount classes.
//


#include <iostream>
#include <iomanip>
#include <string>

#include "BankAccount.h"  
#include "CheckingAccount.h"
//the class definition
using namespace std;

void displayMenu();
double getValidData();


//***************************************************
//                main
//***************************************************
int main()
{
	CheckingAccount studentAccount;  //declare and create with constructor
	int choice = 0;
	int iValue = 0;
	double tFee = 0.0;
	string name = "unknown";

	do {
		displayMenu();
		cin >> choice;
		cout << endl;
		switch (choice)
		{
		case 1: cout << "Deposit amount. ";
			studentAccount.deposit(getValidData());
			break;
		case 2: cout << "Withdraw amount. ";
			studentAccount.withdraw(getValidData());
			break;
		case 3: cout << "Enter the name: ";
			cin.ignore();  //skips the newline char
			getline(cin, name);  //reads an entire line
			studentAccount.setName(name);
			break;
		case 4: cout << "Account number. ";
			studentAccount.setAcctNumber(static_cast<int>(getValidData()));
			break;
		case 5:   cout << "\nSet transaction fee: ";
			cin >> tFee;
			studentAccount.setTransactionFee(tFee);     
			break;
		case 6: studentAccount.displayData();//display all account data
			break;
		case 7: cout << "\nBank is closed.\n"; 
			break;
		default: cout << "Invalid entry.";
		}//switch

	} while (choice != 7);


	return 0;

}//end of main

 //This function displays the user's menu on the screen.
 //This is NOT a BankAccount member function
void displayMenu()
{
	cout << "\n         Welcome to your bank \n\n";
	cout << "1. Make a deposit\n";
	cout << "2. Make a withdrawal\n";
	cout << "3. Set the account name\n";
	cout << "4. Set the account number\n";
	cout << "5. Set transaction fee\n";
	cout << "6. Display account information\n";
	cout << "7. Exit\n\n";
	cout << "Please enter your choice: ";
}

//This function prompts the user for a number
//and checks to see if 0 or greater.  Returns 
//a valid number

double getValidData()
{
	double amount = 0;
	cout << "Enter value: ";  //deposit or withdraw amt or account number
	cin >> amount;
	while (amount < 0)
	{
		cout << "Enter value: (0 or greater): ";
		cin >> amount;
	}
	return amount;
}


/*Expected output

Welcome to your bank

1. Make a deposit
2. Make a withdrawal
3. Set the account name
4. Set the account number
5. Display account information
6. Exit

Please enter your choice: 1

Deposit amount. Enter value: -4
Enter value: (0 or greater): 10

Welcome to your bank

1. Make a deposit
2. Make a withdrawal
3. Set the account name
4. Set the account number
5. Display account information
6. Exit

Please enter your choice: 2

Withdraw amount. Enter value: -5
Enter value: (0 or greater): 5

Welcome to your bank

1. Make a deposit
2. Make a withdrawal
3. Set the account name
4. Set the account number
5. Display account information
6. Exit

Please enter your choice: 3

Enter the name: Bart Simpson

Welcome to your bank

1. Make a deposit
2. Make a withdrawal
3. Set the account name
4. Set the account number
5. Display account information
6. Exit

Please enter your choice: 4

Account number. Enter value: 2345

Welcome to your bank

1. Make a deposit
2. Make a withdrawal
3. Set the account name
4. Set the account number
5. Display account information
6. Exit

Please enter your choice: 5

Account Information
-------------------
Number:      2345
Name:Bart Simpson
Balance:      5.00

Welcome to your bank

1. Make a deposit
2. Make a withdrawal
3. Set the account name
4. Set the account number
5. Display account information
6. Exit

Please enter your choice:




*/