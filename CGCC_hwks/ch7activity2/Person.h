//Program ID:  Person.h  ****Starting File with Questions at the end****
//Author: PBaker
//Date : 
//Brief Description:
//       This is declaration and implementation of the Person class

#include <iostream>
#include <cmath>
#include <iomanip>
#include <string>

using namespace std;


//Person class definition
class Person
{
private:
	string name;
	int birthYear;

public:
	Person();
	Person(string, int);
	string getName();
	int getBirthYear();
	void setName(string);
	void setBirthYear(int);
	int calculateAge(int);
	void displayData(int);

};

/***member function implementation section***/

//implement default constructor
Person::Person(){
	name = "unknown";
	birthYear = 0;
}

//overloaded constructor - done
Person::Person(string n, int yr)
{
	name = n;
	birthYear = yr;
}

//implement getName, getBirthYear, setName, and setBirthYear methods
string Person::getName(){
	return name;
}

int Person::getBirthYear(){
	return birthYear;
}

void Person::setName(string n){
	name = n;
}

void Person::setBirthYear(int yr){
	birthYear = yr;
}

//implement calculateAge.
int Person::calculateAge(int currentYr)
{

	return  (currentYr - birthYear);
}


//implement displayData
void Person::displayData(int currentYr)
{
	cout << "Name: " << name << endl;
	cout << "Birth Year: " << birthYear << endl;
	cout << "Age: " << calculateAge(currentYr) << endl << endl;

}


/*****When the Person class is complete and tested, answer the following questions about Person.h and PersonTester.cpp

1.  List the instance variables for the Person class .

2.  What is the name of the constructor method in this class?

3.  What is the task of a constructor?

4.  List the 2 accessor methods in the Person class.  These methods return/get the value of an instance variable.

5.  List the 2 mutator methods in the Person class.  These methods set the instance variables to a new value.

6.  What does the following statement do and where would this statement be found?
Person worker1;

7.  What is the state of the worker1 object after the above statement is executed?

8.  The following statement is executed.  What is the state of the worker1 object now?
worker1.setName("Bart");
worker1.setBirthYear(2000);

9.  The following statement is executed.  What is displayed ?
cout << worker1.getName() << " is " << worker1.calculateAge(2014) << "." << endl;

10.  The following statement is executed.  What is happens?  Why?
worker1.calculateGrossPay(40, 18.50);
*/