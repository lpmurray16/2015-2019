#pragma once
//Program Id:	BankAccount.h  Student Starting File
//		BankAccount class declaration and implementation
//				Separate Files
//Author:		Patricia Baker and Logan Murray
//Chapter 7:	Writing Classes
//Description:
//				Basic bank account assignment.  
//      
//				Concepts covered:
//					protected member variables
//					public member functions - accesssor/get and mutator/set 
//					default constructors


#include <iostream>
#include <iomanip>
#include <string>
using namespace std;


//BankAccount class declaration
class BankAccount
{
protected:
	int acctNumber;
	string name;
	double balance;

public:
	BankAccount();
	BankAccount(int aNum, string aName, double amount);
	void setAcctNumber(int aNum);
	void setName(string aName);
	void setBalance(double amount);
	int getAcctNumber();
	string getName();
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
	void displayData();

};//End of BankAccount class declaration


  //Member function implementation section

  // Constructor function. Initializes acctNumber to 0, name to “Unknown” and 
  // balance to 0.0.
BankAccount::BankAccount()
{
	acctNumber = 0;
	name = "Unknown";
	balance = 0.0;
}

//Overloaded constructor. overloaded constructor function. 
//Initializes acctNumber to aNum, name to aName and balance to amount.  
BankAccount::BankAccount(int aNum, string aName, double amount)
{
	acctNumber = aNum;
	name = aName;
	balance = amount;
}

//This function copies the argument passed into the parameter to 
//the private member variable acctNumber.
void BankAccount::setAcctNumber(int aNum)
{
	acctNumber = aNum;
}

//This function copies the argument passed into the parameter to 
//the private member variable name.
void BankAccount::setName(string aName)
{
	name = aName;
}

//This function copies the argument passed into the parameter to 
//the private member variable balance.
void BankAccount::setBalance(double amount)
{
	balance = amount;
}

//This function returns the value of the private member variable acctNumber.
int BankAccount::getAcctNumber()
{
	return acctNumber;
}

//This function returns the value of the private member variable name.
string BankAccount::getName()
{
	return name;
}

//This function returns the value of the private member variable balance.
double BankAccount::getBalance()
{
	return balance;
}

//This function adds the amount passed in to the balance.
void BankAccount::deposit(double amount)
{
	balance = balance + amount;
}

//this function subtracts the amount passed in from the balance.
void BankAccount::withdraw(double amount)
{
	balance = balance - amount;
}

// Displays the data of a bank account
void BankAccount::displayData()
{
	cout << "   Account Information   " << endl;
	cout << "-------------------------" << endl;
	cout << "         Number:" << setw(15) << acctNumber << endl;
	cout << "           Name:" << setw(15) << name << endl;
	cout << fixed << showpoint << setprecision(2);
	cout << "        Balance:" << setw(15) << balance << endl;

}