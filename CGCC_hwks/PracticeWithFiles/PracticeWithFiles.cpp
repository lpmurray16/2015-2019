#include <iostream>
#include<fstream>
#include<string>
#include<iomanip>
using namespace std;
int main()
{
	string fName, lName;
	double score1,score2,score3,score4,score5,average;
	ifstream inFile;
	inFile.open("scores.txt");
	cout << "Computer Scientist Exam Report\n";
	cout << "--------------------------------\n\n";
	if (inFile)
	{
		
		while (inFile >> fName>> lName >> score1 >> score2 >> score3 >> score4 >> score5) {
			cout << setprecision(2) << fixed;
			
			
			cout << fName << lName<< "\t" << score1 <<", "<< score2 <<", "<< score3 <<", "<< score4 <<", "<< score5 << endl;
			average = (score1 + score2 + score3 + score4 + score5) / 5;
			cout << "\nThe average for " << fName << " " << lName << " is: " << average << endl << endl;;
			
			
		}
		inFile.close();
	}
	else
	{
		cout << "Error opening file." << endl;
	}//end of else
	return 0;
}