########################################################
# CSC 242 Section 504 Winter 2017
# Recursion exercises (Ch. 10)
########################################################

def factorial(n):
    'nonrecursive version of factorial'
    answer = 1
    for i in range(1,n+1):
        answer *= i
    return answer   

def factorial_r(n):
    'recursive version of factorial'
    #start with base case which we know the answer to without any calculation
    if n == 1:
        return 1
    else:
        return n * factorial(n-1)

# a utility function, meant to help visualize recursion
def print_with_space(var, level):
    if level == 0:
        print(var)
    else:
        print('   ', end='')
        print_with_space(var, level-1)

    
# so that we can see the levels of recursion
def factorial_print(n, level=0):
    print_with_space('factorial({})'.format(n), level)
    answer = 1
    if n > 1:
        answer = n * factorial_print(n-1, level+1)
    print_with_space(answer, level)
    return answer

def exp(x,y):
    'iterative version of computing x to the y power'
    answer = 1
    for i in range(1,y+1):
        answer *= x
    return answer

def exp_r(x, y):
    if y == 0:
        return 1
    return x * exp_r(x, y-1)

def exp_print(x,y,level=0):
    print_with_space('exp({},{})'.format(x,y), level)
    if y == 0:
        print_with_space(1, level)
        return 1
    answer = x * exp_print(x,y-1,level+1)
    print_with_space(answer, level)
    return answer

# greatest common divisor (iterative)
# if y divides into x evenly, then gcd(x,y) => y
# otherwise, it's gcd(y, x%y)
def gcd(x,y):
    while x % y != 0:
        temp = y
        y = x % y
        x = temp
    return y
        

# greatest common divisor (recursive)
# if y divides into x evenly, then gcd(x,y) => y
# otherwise, it's gcd(y, x%y)
def gcd_r(x,y):
#    print('gcd_r({},{})'.format(x,y))
    if x % y == 0:
        return y
    else:
        return gcd_r(y, x%y)

# Fibonacci sequence (recursive):  1, 1, 2, 3, 5, 8, 13, 21, 34...
# fib(6) should return 8
def fib(n):
    if n == 1 or n == 2:
        return 1
    else:
        return fib(n-1) + fib(n-2)

# Fibonacci sequence (recursive):  1, 1, 2, 3, 5, 8, 13, 21, 34...
# fib(6) should return 8
def fib_print(n, level=0):
    print_with_space('fib({})'.format(n), level)
    if n == 1 or n == 2:
        return 1
    else:
        return fib_print(n-1, level+1) + fib_print(n-2, level+1)
    
# iterative; without the "in" operator
# return True is item is in the list or string x
# or false otherwise.  Do not use the Python
# "in" operator in this problem
def occur(item, x):
    'determines if item is found in a list'
    i = 0
    while i < len(x):
        if i == item:
            return True
        i += 1
    return False
        
# recursive
def occur_r(item, x):
    if x == [ ]:
        return False
    elif x[0] == item:
        return True
    else:
        return occur_r(item, x[1:])

# examples that are relevant to many of the problems on the 5th lab

# return a ***list*** of the words which start with 'q'
# >>> qwords(['query', 'ask', 'question', 'inquire'])
# ['query', 'question']

def qwords(words):
    if words == [ ]:          # base case
        return list()         # [ ]
    elif words[0][0] == 'q':  # recursive case(s): first word starts with 'q'
        return [ words[0] ] + qwords(words[1:])
    else:               # recursive case(s): first word does not start with 'q'
        return qwords(words[1:])

# return True if sentence contains all of the letters in the alphabet,
# or False otherwise
def all_letters(sentence, missing = None):
    if missing == None:
        missing = set('abcdefghijklmnopqrstuvwxyz')
    if sentence == '':                 # base case
        return len(missing) == 0
    elif sentence[0] in missing:       # recursive case 1
        missing.remove(sentence[0])
        return all_letters(sentence[1:], missing)
    else:                              # recursive case 2
        return all_letters(sentence[1:], missing)

################################################################
# continue with exercises from notes
################################################################
# again, try to write this without using the Python "in" operator
def occurrences_r(item, x):
    'count number of times item is in x'
    if x == []:               # base case
        return 0
    elif item == x[0]:        # recursive case 1
        return occurrences_r(item, x[1:]) + 1
    else:
        return occurrences_r(item, x[1:])

#************************************************
#* We stopped here on 2/8
#************************************************

# iterative
def pal(word):
    'determines whether or not a word is a palindrome'
    # for example, 'noon', 'radar', but not 'moon', 'noun', 'runner'
    for i in range(len(word)):
        if word[i] != word[-(i+1)]:
            return False
    return True

def pal_r(word):
   if len(word)<=1:
       return True
   elif word=='':
       return True
   elif word[0]!= word[-1]:
       return False
   else:
       return pal_r(word[1:-1])

def one_to_n(n):
    if n==0:
        return [0]
    elif n==1:
        return [1]
    else:
        return one_to_n(n-1)+[n]

def modulus(x, y):
    if x==y:
        return 0
    elif x-y<y:
        return x-y
    else:
        return modulus(x-y, y)

# >>> lst1 = ['a', 'b']
# >>> lst2 = copy_r(lst1)
# >>> lst1[0] = 'x'
# >>> lst1
# ['x', 'b']
# >>> lst2
# ['a', 'b']

def copy(list):
    answer = [ ]
    for item in list:
        answer.append(item)
    return answer

# copy a list
def copy_r(lst):
    if lst==[]:
        return []
    else:
        return [lst[0]]+copy_r(lst[1:])

# return [1, 2, 4, 8, ..., x] recursively
# (x is largest power of 2 <= n)
def powers_of_2(n):
    return [ ]


# examples with lists of lists
#
# This function returns the number of items in the list x.  x may
# contain embedded lists.
def len_embed(x):
    if not isinstance(x, list):
        return 1
    elif x == [ ]:
        return 0
    else:
        return len_embed(x[0]) + len_embed(x[1:])

def len_embed_print(lst):
    print('elen({})'.format(lst))
    if not isinstance(lst, list):
        print('returns 1')
        return 1
    elif lst == [ ]:
        print('returns 0')
        return 0
    else:
        ret = elen(lst[0]) + elen(lst[1:])
        print('returns {}'.format(ret))
        return ret

# write a function which is passed 2 parameters: x (a list)
# and item.  It returns True if item appears in x, or False
# otherwise..
#
# for example:
#
# >>> contains_embed(3, [[[0, 1], 2], 1, [3, 1]])
# True
# >>> contains_embed(4, [[0, 1], [3], 2])
# False

# written such that x may or may not be a list
def contains_embed(item, x):
    if not isinstance(x, list):
        return item ==x
    elif x==[]:
        return False
    else:
        return contains_embed(item, x[0]) or contains_embed(item, x[1:])
    

# count the number of times that item is in x, where
# x may contain embedded lists
def count_embed(x, item):
    pass

# return the maximum item in x, where x may contain
# embedded lists
def max_embed(x):
    if not isinstance(x, list):
        return x
    elif x==[]:
        return None
    else:
        max0= max_embed(x[0])
        max1= max_embed(x[1:])
        if max0==None:
            return max1
        elif max1==None:
            return max0
        elif max0 >= max1:
            return max0
        else:
            return max1

# return the sum of the items in x, where x may contain
# embedded lists
def sum_embed(x):
    if not isinstance(x, list):
        return x
    elif x==[]:
        return 0
    else:
        return sum_embed(x[0]) + sum_embed(x[1:])

# try this
##>>> lst0 = [1,2]
##>>> lst1 = [3,4,5]
##>>> lst2 = [lst0, lst1]
##>>> lst2
##[[1, 2], [3, 4, 5]]
##>>> lst3 = copy_r(lst2)
##>>> lst3
##[[1, 2], [3, 4, 5]]
##>>> lst4 = deep_copy_r(lst2)
##>>> lst0[0] = 100
##>>> lst0
##[100, 2]
##>>> lst2
##[[100, 2], [3, 4, 5]]
##>>> lst3
##[[100, 2], [3, 4, 5]]
##>>> lst4
##[[1, 2], [3, 4, 5]]

# "deep" copy a list
def deep_copy_r(x):
    return x

def count_embed(item, x):
    try:
        return count_embed(item, x[0]) + count_embed(item, x[1:])
    except TypeError:   # x is not a list
        return item == x
    except IndexError:  # might be generated by x[1:] 
        return 0

def sum_embed(x):
    try:
        return sum_embed(x[0]) + sum_embed(x[1:])
    except TypeError:
        return x
    except IndexError:
        return 0

def max_try(x):
    max0=0
    max1=0
    try:
        max0=max_try(x[0])
    except TypeError:
        return max0
    try:
        max1=max_try(x[1:])
    except IndexError:
        return max0
    except TypeError:
        return max0
    if max0 >= max1:
        return max0
    else:
        return max1

def deep_copy_r(x):
    try:
        return [deep_copy_r(x[0])] + deep_copy_r(x[1:])
    except TypeError:
        return x
    except IndexError:
        return list()

def flatten(x):
    try:
        return flatten(x[0]) + flatten(x[1:])
    except TypeError:
        return [x]
    except IndexError:
        return []




