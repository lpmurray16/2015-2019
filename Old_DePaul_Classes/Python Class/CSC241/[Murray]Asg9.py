#
# Assignment 9
#
# Logan Murray
#
# Name(s) of collaborators if any
#
#

def letter2number(s):
    """This function takes a letter grade as an input, and using a dictionary
    returns the corresponding GPA as a number value."""
    gradeDict={'A':4, 'A-':3.7,'B+':3.3,'B':3,'B-':2.7,'C+':2.3,'C':2,'C-':1.7,'D+':1.3,'D':1,'D-':0.7,'F+':0.3,'F':0}
    s=s.upper()
    if s in gradeDict:
        print(gradeDict[s])
    else:
        print('unknown grade')


def translate(d):
    """This program takes a dictionary as its parameter. Using this dictionary,
    the user inputs a word which is a key in the dict and therefore prints the
    translation. If the word they enter is not a key it prints blanks for a
    translation."""
    done=False
    print("***Welcome to the WordsRUs translation service.***")
    while not done:
        userWord=input("Please enter a word: ")
        if userWord in d:
            print("{} means {}.".format(userWord, d[userWord]))
        elif userWord=='Quit'or userWord=='quit'or userWord=='QUIT':
            done=True
        else:
            blanks='_'*len(userWord)
            print("{} means {}".format(userWord, blanks))
    print("Thanks for using our translation service")
            


def vote(lst):
    """This program takes a list of candidates. The user enters the name of the
    candidate in order to cast a vote. If the candidate they enter doesn't exist
    then they are created and a vote is implemented."""
    done=False
    voteDict={}
    for name in lst:
        voteDict[name]=0
    while not done:
        vote=input("Please enter a vote: ")
        vote=vote.title()
        if vote in voteDict:
            voteDict[vote]=voteDict[vote]+1
        elif vote=='':
            for i in voteDict:
                print("There were {} votes for {}.".format(voteDict[i],i))
            done=True
        else:
            voteDict.update({vote:1})
                
        
        
