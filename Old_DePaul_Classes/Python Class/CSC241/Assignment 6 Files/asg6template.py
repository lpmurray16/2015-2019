#
# Logan Murray
#
#

import os   # this is required to do the empty file check 

def showNames(ifile):
    infile=open(ifile,'r')
    for line in infile:
        line.split()
        
        print(line)

def calcAvg(ifile):
    pass

def studentAvg(ifile):
# this is the code for checking if a file is empty.
# Put this after your open
# Add try/except appropriately
# its been commented out to run the auto checks for the other functions

##        if os.stat(ifile).st_size == 0: # note: it uses the stat method from os
##            raise ValueError
    pass

if __name__ == "__main__":
    def check(output, expected):
        if output != expected:
            return "FAILED!"
        else:
            return "PASSED!"
    print("RUNNING CHECK ...")
    print('showNames(ifile): ' + check(showNames("nosuchfile.txt"),[-1]))
    print('showNames(ifile): ' + check(showNames("grades1.txt"),['Domel', 'Fischer', 'Hope', 'Patel']))
    print('showNames(ifile): ' + check(showNames("grades2.txt"),['Domel', 'Fischer']))
    print()
    print('calcAvg(ifile): ' + check(calcAvg("nosuchfile.txt"),'File not found.'))
    print('calcAvg(ifile): ' + check(calcAvg("grades1.txt"),'Non-numeric found. Total number of students: 3  Average score: 96'))
    print('calcAvg(ifile): ' + check(calcAvg("grades2.txt"),'Non-numeric found. Total number of students: 1  Average score: 90'))
    print()
    print('studentAvg(ifile): ' + check(studentAvg("nosuchfile.txt"),'File not found.'))
    print('studentAvg(ifile): ' + check(studentAvg("grades1.txt"),['Error! Non-numeric! Name: Domel Number of assignments: 7 Average score: 81.42857142857143', 'Name: Fischer Number of assignments: 8 Average score: 74.125', 'Name: Hope Number of assignments: 8 Average score: 100.0', 'Name: Patel Number of assignments: 8 Average score: 90.375']))
    print('studentAvg(ifile): ' + check(studentAvg("grades2.txt"),['Error! Non-numeric! Name: Domel Number of assignments: 7 Average score: 0.0', 'Name: Fischer Number of assignments: 8 Average score: 90.0']))
    print('studentAvg(ifile): ' + check(studentAvg("grades3.txt"),'File is empty.'))


            
