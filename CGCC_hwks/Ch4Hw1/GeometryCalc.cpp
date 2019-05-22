/*
GeometryCalc.cpp
Logan Murray
CSC 100AA
Feb. 22, 2016
Calculates the area of a circle, rectangle, and triangle
*/

#include<iostream>
#include<iomanip>
#include<string>
#include<cstdlib>
#include<ctime>
#include<cmath>

using namespace std;

int main() {

	int menu;
		
	const double PI = 3.141592;

	cout << "****Geometry Calculator****\n\n";
	cout << "1. Calculate the area of a Circle.\n";
	cout << "2. Calculate the area of a Rectangle.\n";
	cout << "3. Calculate the area of a Triangle.\n";
	cout << "4. Quit program\n";
	cout<< "\nEnter your choice (1-4) ";

	cin >> menu;

	switch (menu)
	{
	    double radius,
		length,
		width,
		base,
		height,
		Area;
	    
	
	
	   case 1: cout << "\nPlease enter the radius of the circle:\n";
		   cin >> radius;
           
		   Area = PI * pow(radius, 2);

		   cout << "\nThe area of your circle is " << Area <<endl;
		   break;
		
	   case 2: cout << "\nPlease enter the length of rectangle:\n";
		   cin >> length;
		       cout << "Now enter the width of rectangle:\n";
		   cin >> width;

		   Area = length*width;

		   cout << "\nThe area of your rectangle is " << Area << endl;
		   break;
		   

	   case 3: cout << "\nPlease enter the base of your triangle:\n";
		   cin >> base;
		   cout << "Now enter the height of the triangle:\n";
		   cin >> height;

		   Area = 0.5 * (base * height);

		   cout << "\nThe area of the triangle is " << Area << endl;
		   break;

	   case 4: cout << "\nYou chose to quit";
		   break;
	   default: cout << "\nYou may only input options 1-4.\n";


	}

	cout << "\nThank you for using the Geometry Calculator!\n\n";


	return(0);
}

/*
****Geometry Calculator****

1. Calculate the area of a Circle.
2. Calculate the area of a Rectangle.
3. Calculate the area of a Triangle.
4. Quit program

Enter your choice (1-4) 1

Please enter the radius of the circle:
12

The area of your circle is 452.389

Thank you for using the Geometry Calculator!

Press any key to continue . . .


****Geometry Calculator****

1. Calculate the area of a Circle.
2. Calculate the area of a Rectangle.
3. Calculate the area of a Triangle.
4. Quit program

Enter your choice (1-4) 2

Please enter the length of rectangle:
5
Now enter the width of rectangle:
5

The area of your rectangle is 25

Thank you for using the Geometry Calculator!

Press any key to continue . . .


****Geometry Calculator****

1. Calculate the area of a Circle.
2. Calculate the area of a Rectangle.
3. Calculate the area of a Triangle.
4. Quit program

Enter your choice (1-4) 3

Please enter the base of your triangle:
10
Now enter the height of the triangle:
6

The area of the triangle is 30

Thank you for using the Geometry Calculator!

Press any key to continue . . .

****Geometry Calculator****

1. Calculate the area of a Circle.
2. Calculate the area of a Rectangle.
3. Calculate the area of a Triangle.
4. Quit program

Enter your choice (1-4) 4

You chose to quit
Thank you for using the Geometry Calculator!

Press any key to continue . . .

****Geometry Calculator****

1. Calculate the area of a Circle.
2. Calculate the area of a Rectangle.
3. Calculate the area of a Triangle.
4. Quit program

Enter your choice (1-4) 9

You may only input options 1-4.

Thank you for using the Geometry Calculator!

Press any key to continue . . .*/


