import hw2

def test_hw2():
    test_problem1()
    test_problem2()
    test_problem3()
    test_problem4()
    test_problem5()
    
def test_problem1():
    errors = 0
    params = (1, 2.5)
    answers = (3.141592653589793, 19.634954084936208)
    for i in range(len(params)):
        answer = hw2.circle_area(params[i])
        if answer != answers[i]:
            errors += 1
    print('circle_area: {} errors out of 2 function calls'.format(errors))
    

def test_problem2():
    errors = 0
    params = [1, 2.5]
    answers = [6.283185307179586, 15.707963267948966]
    for i in range(len(params)):
        answer = hw2.circle_circumference(params[i])
        if answer != answers[i]:
            errors += 1
    print('circle_circumference: {} errors out of 2 function calls'.format(errors))

def test_problem3():
    errors = 0
    params = (((1,1), (4,5)), ((0,1),(1,0)), ((3,-1), (4,2)))
    answers = (5.0, 1.4142135623730951, 3.1622776601683795)
    for i in range(len(params)):
        answer = eval('hw2.line_length{}'.format(params[i]))
        if answer != answers[i]:
            errors += 1
    print('line_length: {} errors out of 3 function calls'.format(errors))

def test_problem4():
    errors = 0
    params = (((1, 1),(1, 2),(2, 1)), ((0,0), (3, 4), (3,0)))  
    answers = (3.414213562373095, 12.0)
    for i in range(len(params)):
        answer = eval('hw2.triangle_perimeter{}'.format(params[i]))
        if answer != answers[i]:
            errors += 1
    print('triangle_perimeter: {} errors out of 2 function calls'.format(errors))

def test_problem5():
    errors = 0
    if hw2.truncate(hw2.line_length((0,1), (1,0)), 3) != 1.414:
        errors += 1
    if hw2.truncate(hw2.circle_circumference(1), 1) != 6.2:
        errors += 1
    if hw2.truncate(hw2.circle_area(1), 4) != 3.1415:
        errors += 1
    print('truncate: {} errors out of 3 function calls'.format(errors))

test_hw2()
