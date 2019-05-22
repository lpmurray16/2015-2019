#pragma once
//CheckingAccount.h
//Subclass of BankAccount.h
//Logan Murray
//May 4th, 2016

#include<iostream>
#include<string>
#include<iomanip>

using namespace std;

class CheckingAccount : public BankAccount {

protected:
	double transactionFee;


public:
	CheckingAccount();

	void setTransactionFee(double trFee);
	double getTransactionFee();
	void deposit(double amount);
	void withdraw(double amount);
	void displayData();



};

CheckingAccount::CheckingAccount():BankAccount() {
	
	transactionFee = 1.00;
}

void CheckingAccount::setTransactionFee(double trFee) {
	transactionFee = trFee;
}

double CheckingAccount::getTransactionFee() {
	return transactionFee;
}

void CheckingAccount::deposit(double amount) {
	balance = (amount + balance) - transactionFee;
	
}

void CheckingAccount::withdraw(double amount) {
	balance = (balance - amount) - transactionFee;
}

void CheckingAccount::displayData() {
	BankAccount::displayData();
	cout << fixed << showpoint << setprecision(2);
	cout << "Transaction Fee:" << setw(15) << transactionFee << endl;
}