//Currency.cpp
//Logan Murray
//CSC100AA
//Feb 10, 2016
//This program converts US dollars to Yen and Euros

#include<iostream>
#include<iomanip>

using namespace std;
 

int main() {

	double dollars,
		   yen,
		   euro;
	const double YEN_PER_DOL = 105.11;
	const double EURO_PER_DOL = 0.7721;

	cout << "Please enter a US dollar amount:  $";
	cin >> dollars;
	cout << endl;

	cout << fixed << setprecision(2);

	yen = YEN_PER_DOL * dollars;

	euro = EURO_PER_DOL * dollars;

	cout << "Given $" << dollars << " the conversion is as follows:\n\n";
	cout << "\tYen amount:\t" << yen <<" Yen" << endl;
	cout << "\tEuro amount:\t" << euro <<" Euros" << endl << endl;





	return(0);
}

/*

Please enter a US dollar amount:  $50

Given $50.00 the conversion is as follows:

Yen amount:     5255.50 Yen
Euro amount:    38.61 Euros

Press any key to continue . . .

*/