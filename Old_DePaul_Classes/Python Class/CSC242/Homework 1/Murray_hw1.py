###################################
# CSC 242 Section 504 Winter 2017
# Homework assignment 1
# Logan Murray
# January 9th, 2016
###################################
#
# Your assignment is to complete the 4 functions
# below.
#
# 1.  Complete factors(x) to return a list of the factors of x;
#     that is, a list of positive integers which divide evenly into x.

def factors(x):
     factor=[]
     for i in range(1, x+1):
          if x%i==0:
               factor.append(i)
     return factor

# 2.  Complete factors_set(x) to return the factors of x as a set rather
#     than a list.

def factors_set(x):
     answer = set()
     for i in range(1, x+1):
          if x%i==0:
               answer.add(i)
     return answer

# 3.  Complete read_wiktionary() to return a Python dictionary whose
#     keys are English words, and whose values reflect the frequency
#     with which those words are used.  The data should be read
#     from the wiktionary.txt file which you can find on D2L.

def read_wiktionary():
     answer = dict()
     f = open('wiktionary.txt')
     for line in f:
          newline=line.split()
          answer.update({newline[0]:float(newline[1])})
     return answer

# 4. Complete count_words(file) below.  This function
#    is passed the name of a file, and should return a Python
#    dictionary whose keys are words in that file
#    and whose values are the number of times each word
#    appears in the file.

def count_words(file):
     answer = dict() # keys in this dictionary will be words
     f=open(file,'r')
     words = f.read().split() # split the line into words
     wordset=set()
     for word in words:
          wordset.add(word)
     for word in wordset:
          answer[word]=words.count(word)
     return answer
