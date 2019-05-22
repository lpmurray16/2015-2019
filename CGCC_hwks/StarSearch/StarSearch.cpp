//StarSearch.cpp
//Logan Murray
//CSCA100
//March 28th. 2016
//This program takes scores from judges and drops the lowest and the highest
//then finds the average. Using functions.

#include<iostream>
#include<string>
#include<iomanip>
using namespace std;

void getJudgeData(double &score);
void calcScore(double, double, double, double, double);
double findLowest(double, double, double, double, double);
double findHighest(double, double, double, double, double);


int main() {
	
	char again;
	
	do {
		
		double score1, score2, score3, score4, score5;
		int contestantNum = 1;
		cout << setprecision(2) << fixed;
		cout << "     Welcome     \n";
		cout << "-----------------\n";
		cout << "***Contestant " << contestantNum << "***" << endl;
		getJudgeData(score1);
		getJudgeData(score2);
		getJudgeData(score3);
		getJudgeData(score4);
		getJudgeData(score5);

		calcScore(score1, score2, score3, score4, score5);

		cout << "Would you like to try again? (Y or N) ";
		cin >> again;

	} while (again == 'Y' || again == 'y');

	cout << "Goodbye!\n";


	return(0);

}


//allows user to input judges scores in multiple variables
void getJudgeData(double &score) {

	cout << "Enter a score between 1 and 10: ";
	cin >> score;
	while (score < 1 || score>10) {
		cout << "Score must be between 1-10: ";
		cin >> score;
	}
}
//finds lowest score and returns it
double findLowest(double s1, double s2, double s3, double s4, double s5) {
	double lowestVal;
	if (s1<s2 && s1<s3 && s1<s4 && s1<s5) {
		lowestVal = s1;
	}
	else if (s2<s1 && s2<s3 && s2<s4 && s2<s5) {
		lowestVal = s2;
	}
	else if (s3 < s1 && s3 < s2 && s3 < s4 && s3 < s5) {
		lowestVal = s3;
	}
	else if (s4 < s1 && s4 < s2 && s4 < s3 && s4 < s5) {
		lowestVal = s4;
	}
	else if (s5 < s1 && s5 < s2 && s5 < s3 && s5 < s4) {
		lowestVal = s5;
	}

	return lowestVal;
}
//finds highest score and returns it
double findHighest(double s1, double s2, double s3, double s4, double s5) {
	double highestVal;
	if (s1>s2 && s1>s3 && s1>s4 && s1>s5) {
		highestVal = s1;
	}
	else if (s2>s1 && s2>s3 && s2>s4 && s2>s5) {
		highestVal = s2;
	}
	else if (s3 > s1 && s3 > s2 && s3 > s4 && s3 > s5) {
		highestVal = s3;
	}
	else if (s4 > s1 && s4 > s2 && s4 > s3 && s4 > s5) {
		highestVal = s4;
	}
	else if (s5 > s1 && s5 > s2 && s5 > s3 && s5 > s4) {
		highestVal = s5;
	}

	return highestVal;
}
//calculates final score and returns it
void calcScore(double s1, double s2, double s3, double s4, double s5) {
	double middle;
	double finalScore;
	double lowest;
	double highest;
	lowest = findLowest(s1, s2, s3, s4, s5);
	highest = findHighest(s1, s2, s3, s4, s5);
	
	middle = s1 + s2 + s3 + s4 + s5 - lowest - highest;
	finalScore = middle / 3.0;
	cout << "Lowest score = " << lowest << ", Highest score = " << highest << ", Final score = " << finalScore << endl;
}

/* tested output
Welcome
-----------------
***Contestant 1***
Enter a score between 1 and 10: 8.1
Enter a score between 1 and 10: 7.5
Enter a score between 1 and 10: 7
Enter a score between 1 and 10: -3
Score must be between 1-10: 6
Enter a score between 1 and 10: 7.2
Lowest score = 6.00, Highest score = 8.10, Final score = 7.23
Would you like to try again? (Y or N) y
Welcome
-----------------
***Contestant 1***
Enter a score between 1 and 10: 4.2
Enter a score between 1 and 10: 12
Score must be between 1-10: 2
Enter a score between 1 and 10: 3.8
Enter a score between 1 and 10: 2.6
Enter a score between 1 and 10: 1.9
Lowest score = 1.90, Highest score = 4.20, Final score = 2.80
Would you like to try again? (Y or N) n
Goodbye!
Press any key to continue . . .*/

