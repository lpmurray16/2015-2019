
###############################################################
# CSC 242 Section 504L Winter 2017
# Lab 2:  Review of Nested Loops
# Logan Murray
# Jan 11th, 2016
###############################################################
#
# In this lab, you will practice writing nested loops.
# Please upload your solutions for this lab into the
# Lab2 dropbox folder by the end of the lab session.
# You are strongly encouraged to work in groups of 2 or 3
# for all labs.  Please place a comment at the top of your
# .py file which includes your name, and the names of any
# students you worked with.  Each student should upload
# solutions to the D2L dropbox, even if you worked in a group.
#
###############################################################
#
# The lab is worth 2% of your overall grade; therefore it
# will be graded on a scale of 0-2.
#
# Your task is to complete the 4 functions below.  Each
# problem is worth .5 points.  Partial credit may be
# awarded if your function returns the correct answer in
# at least 2 of the cases I have provided in the comments before
# each function template.

# 1. Write a function called sums.  The function is
# passed 2 lists of integers, and should return a list
# of the sums of each pair of integers from the 2 parameter
# lists.  Note that if the first list contains m items, and
# the second list contains n items, then the length of
# the return list should be m*n.
#
# For example:
#
# >>> sums([5, 10], [1])
# [6, 11]
# >>> sums([1, 2, 3], [3, 4])
# [4, 5, 5, 6, 6, 7]
# >>> sums([3, 6, 2], [6, 1, 0, 6])
# [9, 4, 3, 9, 12, 7, 6, 12, 8, 3, 2, 8]
# >>> sums([1, 2, 3], [ ])
# [ ]
#
# You should write your solution so that the order of the
# numbers in the return list is the same as the examples above.

def sums(list1, list2):
    answer = [ ]
    for i in list1:
        for j in list2:
            sol=i+j
            answer.append(sol)



    return answer

# 2.  Write a function called pairs.  It is passed a string,
# and should return a list of strings.  The length of
# each string should be 2, and the letters in each
# of them should consist of all possible permutations of
# 2 letters from the parameter string.  For example,
#
# >>> pairs('')
# [ ]
# >>> pairs ('a')
# [ ]
# >>> pairs('ab')
# ['ab', 'ba']
# >>> pairs('abc')
# ['ab', 'ac', 'ba', 'bc', 'ca', 'cb']
#
# The ordering of the strings in the return list is unimportant.

def pairs(string):
    answer = [ ]
    for i in string:
        for j in string:
            if i!=j:
                answer.append(i+j)



    return answer

# 3. Write a function called substrings.  It is passed a string,
# and should return a list of all of the substrings in the string.
# For example:
#
# >>> substrings('')
# []
# >>> substrings('a')
# ['a']
# >>> substrings('ab')
# ['a', 'ab', 'b']
# >>> substrings('abc')
# ['a', 'ab', 'abc', 'b', 'bc', 'c']
# >>> substrings('abcd')
# ['a', 'ab', 'abc', 'abcd', 'b', 'bc', 'bcd', 'c', 'cd', 'd']

def substrings(string):
    answer = [ ]
    """Not exactly sure how this one is done.
       Will wait for extra help, or solution"""
            
           
            



    return answer

# The ordering of the strings in the return list is unimportant.

# 4.  Write a function called largest_prime.  It is passed an integer n,
# and produces the largest prime number that is less than or equal to n.
# For example:
#
# >>> largest_prime(5)
# 5
# >>> largest_prime(10)
# 7
# >>> largest_prime(25)
# 23
# >>> largest_prime(10000)
# 9973

def largest_prime(n):
    """I took a swing at this one but couldn't get it. Will wait for help"""
        
        
        

