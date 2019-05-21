def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

number_in_lottery = eval(input("Please enter the size of the lottery: "))
number_chosen = eval(input("Please enter the number chosen: "))

print(factorial(number_in_lottery))

odds = factorial(number_in_lottery)/(factorial(number_chosen)*factorial(number_in_lottery-number_chosen))

print(odds)

