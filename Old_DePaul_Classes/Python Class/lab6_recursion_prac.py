###############################################################
# CSC 242 Section 504 Winter 2017
# Lab 6:  More Recursion
# February 15, 2017

#   Logan Murray
###############################################################
#
# Please upload your solutions for this lab onto D2L by the
# date and time specified on the D2L Lab 6 dropbox folder.
# You are strongly encouraged to work in groups of 2 or 3
# for all labs.  Please place a comment at the top of your .py 
# file which includes your name, and the names of any students 
# you worked with.  Each student should upload solutions to the 
# D2L dropbox, even if you worked in a group.
#
###############################################################
# Your task is to complete the first 4 functions below.
# Each function is passed a parameter with embedded structures,
# such as embedded lists.  Each function can be completed in
# 5-10 lines of code or less.
#
# For this lab, you must write each function RECURSIVELY.
# I have provided a template for each problem; however if
# you find a different solution for any problem, you can delete
# my code and rewrite it in whatever way you'd like, except
# NO LOOPS ARE ALLOWED.
#
# You may test your code by running it with the file lab6_test.py
# In order to do so, hit F5 on the window displaying lab6_test.py
# and it will load lab6.py through the import statement
# at the top.
#
# The lab is worth a total of 2 points.  Each correct solution
# for problems 1-4 is worth .5 points.  Partial credit will be
# given for functions which do not have syntax errors, and which
# work correctly on one or more of the test cases I am
# providing.
#
# Note that there is also a 5th problem below.  This is an
# extra credit problem, worth .5 points.  The function must
# work correctly on my test examples in order for you to receive
# extra credit.  NO PARTIAL CREDIT WILL BE GIVEN.
###############################################################
# Problem 1
#
# Write a function which counts the number of times that an
# item appears in x.  x may be list (possibly containing
# embedded lists), or it may be a non-list such as an integer.
# Your solution must be recursive, have no loops, and must
# not use the Python "in" operator.
#
# For example:
#
# >>> count(1,2)
# 0
# >>> count(1,1)
# 1
# >>> count(2, [2, [1, 3], [[2, 4], 2], 1])
# 3
###############################################################

# count the number of times item appears in x
def count(item, x):
    
    if not isinstance(x, list):
        if item==x:
            return 1
        else:
            return 0
    elif x == [ ]:
        return 0
    else:
        return count(item, x[0]) + count(item, x[1:])       


###############################################################
# Problem 2
#
# Write a function called flatten.  The function is passed a parameter
# x, which may be a list (possibly containing embedded lists), or
# a non-list such as an integer.  The function should
# return a list containing no embedded lists, and containing the
# items in x in the same order in which they appear in x.
# Your solution must be recursive and have no loops.
# For example:
#
# >>> flatten(1)
# [1]
# >>> flatten([1,2,3])
# [1, 2, 3]
# >>> flatten([[3, 1, 2], [[3, 6, 2], [6 2 0 6]]]])
# [3, 1, 2, 3, 6, 2, 6, 1, 0, 6]
# >>> flatten([[[[[[[[1]]]], 2]]]])
# [1, 2]
###############################################################

def flatten(x):
    if not isinstance(x, list):
        return [x]
    elif x==[]:
        return []
    else:
        return flatten(x[0]) + flatten(x[1:]) # replace

###############################################################
# Problem 3
#
# Write a function called deep_copy_242.  It is passed a parameter
# x, which may be a list (possibly containing embedded lists), or
# a non-list such as an integer.  The function should return a
# "deep copy" of x, as described during Monday's lecture.  Your solution
# must be recursive and have no loops.  You may
# NOT use the built-in Python deepcopy function.  Here
# some examples of proper behavior of deepcopy_242.
#
# >>> a = 1
# >>> deepcopy_242(a)
# 1
# >>> x = [1, [2, 3], 4]
# >>> y = deepcopy_242(x)
# >>> y
# [1, [2, 3], 4]
# >>> x is y
# False
# >>> x == y
# True
# >>> x[0] = 10
# >>> x
# [10, [2, 3], 4]
# >>> y
# [1, [2, 3], 4]
# >>> x == y
# False
# >>> x[1][0] = 0
# >>> x[1]
# [0, 3]
# >>> y[1]
# [2, 3]
###############################################################

def deepcopy_242(x):
    if not isinstance(x, list):
        return x
    elif x==[]:
        return list()
    else:
        return [deepcopy_242(x[0])] + deepcopy_242(x[1:])

###############################################################
# Problem 4
#
# Write a function called strings.   It is passed a parameter
# x, which may be a list (possibly containing embedded lists), or
# a non-list such as an integer or a string.  Note that in this
# problem, list can contain other types of data than jst numbers
# The strings function returns the number of strings in x.
#
# For example:
# >>> strings('abc')
# ['abc']
# >>> strings(0)
# []
# >>> strings([0, 'defgh'])
# ['defgh']
# >>> strings([['csc', 242], ['intro', 'to', ['python', 2]]])
# ['csc', 'intro', 'to', 'python']
###############################################################

def strings(x):
    if isinstance(x, str):
        return [x]
    elif x==[]:
        return []
    elif isinstance(x, list):
        return strings(x[0]) + strings(x[1:])
    else:
        return []
    
    

###############################################################
# Problem 5:  extra credit
#
# Other types of Python container objects may have embedded data.
# For example, we could represent an appointment calendar as a set
# of dictionaries.  Each item in the set represents a day of the
# week, and each dictionary object represents the appointments
# scheduled for that day.  Here is an example:
#
monday_appts = {'1:30' : 'Office hours', '3:10' : 'CSC 242 lecture'}
wednesday_appts = {'11:50': 'CSC 242 lab', '3:10' : 'CSC 242 lecture'}
thursday_appts = {'1:30' : 'Advising hours', '3:45' : 'Office hours', '5:45' : 'CSC 406 lecture'}
calendar  = { 'monday': monday_appts, 'wednesday' : wednesday_appts, 'thursday' : thursday_appts }

# Write a function called activities.  It is passed a dictionary x,
# whose structure is similar to the variable "calendar" above.  Your
# function should be written recursively, so that x may
# contain any number of embeddeded dictionaries, at any level
# of embedding.  The function should return a ***set*** of
# (non-dictionary) values stored in x.  Although your solution must
# be recursive, it may also contain loops.
#
# Given the above value for the variable calendar, here is an example
# call to values242:
#
# >>> values242(calendar)
#{'Office hours', 'CSC 242 lecture', 'CSC 242 lab', 'Advising hours','CSC 406 lecture'}
#
# As is always the case with sets, the ordering of the items in the set is
# unimportant; in fact, you have no control of its ordering.
###############################################################
def activities(x):
    return set()           # replace
        
