#pragma once
//BankAccount.h
//Logan Murray
//April 12, 2016
//Creates a class called BankAccount

#include<iostream>
#include<iomanip>
#include<string>

using namespace std;

class BankAccount {
private:
	int acctNumber;
	string name;
	double balance;
public:
	BankAccount();
	BankAccount(int aNum, string aName, double amount);

	void setAcctNumber(int aNum);
	void setName(string aName);
	int getAcctNumber();
	string getName();
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
	void displayData();
};

//default constructor
BankAccount::BankAccount() {
	acctNumber = 0;
	name = "unknown";
	balance = 0.0;
}

//overloaded constructor
BankAccount::BankAccount(int aNum, string aName, double amount) {
	acctNumber = aNum;
	name = aName;
	balance = amount;
}

//sets instance variable acctNumber
void BankAccount::setAcctNumber(int aNum) {
	acctNumber = aNum;
}

//sets instance variable name
void BankAccount::setName(string aName) {
	name = aName;
}

//returns the value of instance variable acctNumber
int BankAccount::getAcctNumber() {
	return acctNumber;
}

//returns the variable name
string BankAccount::getName() {
	return name;
}

//returns the variable balance
double BankAccount::getBalance() {
	return balance;
}

//adds amount to the balance
void BankAccount::deposit(double amount) {
	balance = amount + balance;
}

//subtracts amount from the balance
void BankAccount::withdraw(double amount) {
	balance = balance - amount;
}

//displays the current values of all instance variables
void BankAccount::displayData() {
	cout << "Account Information\n";
	cout << "----------------------\n";
	cout << "Number:\t" << acctNumber<<endl;
	cout << "Name:\t" << name << endl;
	cout << "Balance:\t" << balance << endl;
}