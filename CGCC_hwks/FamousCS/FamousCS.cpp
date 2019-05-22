#include<iostream>
#include<fstream>
#include<string>

using namespace std;
int main()
{
	//declare variables needed
	ifstream inFile;
	string fName;
	
	inFile.open("scores.txt");

	inFile >> fName;
	cout << fName << endl;
	
	/*if (successfully opened file)
	{
		// using a while loop read in and display the data
		// close the data file
	}
	else
	{
		cout << "Error opening file." << endl;
	}//end of else*/
	
	return 0;
}