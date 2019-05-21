####################################################
# CSC 242 Section 504 Winter 2017
# Homework Assignment 5:  Recursion
# Due:  As specified on D2L
#
#    Logan Murray
#
# Your task is to complete each function below.  The
# assignment will be graded on a scale of 0 to 4.
# There are 8 functions for you to complete, each
# worth .5 points.
#
# As with all assignment in this class, you must
# work by yourself, and all answers must be your own.
#
# All solutions must be recursive.  You are not
# allowed to use loops, or use the Python "in"
# operator.
#
# I will provide code which tests your solutions
# shortly.
####################################################

####################################################
# Problem 1
#
# Write a function which returns the sum of squares
# of the integers 1 to n.  For example, the sum of
# the squares from 1 to 4 is 1 + 4 + 9 + 16, or 30.
# You may choose what should be returned if n == 0.
#
# You may not use the built-in Python sum function.
#
# >>> sum_of_squares(1)
# 1
# >>> sum_of_squares(4)
# 30
# >>> sum_of_squares(8) # 64 + 49 + 36 + ... + 4 + 1
# 17650828
""" The above solution for (8) is wrong """
###############################################

def sum_of_squares(n):
    if n==0:
        return 0
    elif n==1:
        return 1
    else:
        return n**2 + sum_of_squares(n-1) # replace this

####################################################
# Problem 2
#
# Write a function called power.  It is passed
# 2 parameters, x and y, and returns x to power
# of y.  You may not use **, and you may not import
# the math module or any of the names (functions)
# in the math module.
#
# For example:
#
# >>> power(2,3)
# 8
# >>> power(5,2)
# 25
# >>> power(3,0)
# 1
#
####################################################
def powers(x, y):
    if y==0:
        return 1
    elif x==1:
        return 1
    else:
        return x*powers(x, y-1)     # replace this
    
####################################################
# Problem 3
#
# Write a function which is passed a list, and
# returns a list whose elements are in the
# reverse order of the original list.  You may
# not use the built-in Python reverse method.
#
# For example:
#
# >>> reverse([1, 2, 3])
# [3, 2, 1]
#
####################################################
def reverse(lst):
    if lst==list():
        return lst()
    elif len(lst)==1:
        return lst
    else:
        return reverse(lst[1:]) + [lst[0]]# replace this

####################################################
# Problem 4
#
# Write a function which is passed a list of numbers
# and returns the minimum number in the list.
# You are not allowed to use the built-in Python
# min function.  You may assume that there is at
# least one item in the list.
# If x is a list, you may assume that it is not empty.
#
# For example:
#
# >>> min([3, 6, 2, 6, 1, 4, 5])
# 1
# >>> min([2, 4, 6, 8, -8, -6, -4, -2])
# -8
#
""" Had to change the name of the function to work """
####################################################
def minimum(lst):
    if len(lst) <= 1:
        return lst[0]
    else:
        m = minimum(lst[1:])
        if m < lst[0]:
            return m
        else:
            return lst[0]
    
####################################################
# Problem 5
#
# Write a function which is passed 3 parameters,
# all of which are strings.  The function
# returns a copy of the string s with all occurrences
# of old_c replaced by new_c.  You are not allowed
# to use the built-in Python replace method.
# You may assume that old_c and new_c are both
# strings of length 1.
#
# For example:
#
# >>> replace('science', 'c', 't')
# 'stiente'
# >>> replace('python', 's', 't')
# 'python'
# >>> replace('rocker', 'r', 'd')
# 'docked'
###################################################
def replace(s, old_c, new_c):
    if s == '':
        return ''
    if s[0] == old_c:
        return new_c + replace(s[1:], old_c, new_c)
    return s[0] + replace(s[1:], old_c, new_c)

###################################################
# The remaining problems involve lists that possibly
# contain embedded lists.  We will discuss this
# on Monday 2/13.
###################################################

###################################################
# Problem 6
#
# Write a function called depth.  It is passed an
# object x, that may or may not be a list.  If x
# is a list, some of the items in x may themselves be
# lists, which also may or may not contain additional
# embedded lists.  The function returns the maximum
# depth of the embedded lists.  For example:
#
# >>> depth(10)
# 0
# >>> depth([1,2,3])
# 1
# >>> depth([1,[2,3],4])
# 2
# >>> depth([1,[3,1,2],[[3,6,2],[6,1,0,6]]])
# 3
# etc.
###################################################
def depth(x):
    if isinstance(x, list):
        return 1
    if isinstance(x, int):
        return 0
    else:
        return depth(x[0]) + depth(x[0][0:]) 

    # additional base cases may be required, and
    # then one or more recursive cases should follow
    
             # replace this

###################################################
# Problem 7
#
# Write a function called number_of_lists.  It
# is passed a parameter x, that may or may not
# be a list.  As in problem 6, if is x is a list
# it may contain other lists.  The function
# should return the total number of lists in x.
# For example:
#
# >>> number_of_lists('abc')
# 0
# >>> number_of_lists([ ])
# 1
# >>> number_of_lists([[1, 2, 3]])
# 2
# >>> number_of_lists([1,[3,1,2],[[3,6,2],[6,1,0,6]]])
# 5
#
###################################################
def number_of_lists(x):
    return 0               # replace this

###################################################
# Problem 8
#
# Write a function called first.  Just as in problems
# 6 and 7, it is passed a parameter x, that may or may not
# be a list; if is x is a list it may contain other
# lists.  The function should return the first non-list
# object in x.  In other words, first should return
# x in some cases, or x[0], x[0][0], x[0][0][0], etc.
#
# For example:
#
# >>> first(1)
# 1
# >>> first([2,1])
# 2
# >>> first([[3, 1], 2])
# 3
# >>> first([[[[[[[4]]]]]], 1, 2, 3])
# 4
#
###################################################
def first(x):
    pass                   # replace this
