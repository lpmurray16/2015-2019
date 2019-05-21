from hw3_complete import *

mlk_day = Date(1, 16, 2017)
hw3_due = Date(1, 29, 2017)
revolution = Date(7, 4, 1776)
feb_29 = Date(2, 29, 2016)
ny_eve = Date(12, 31, 2016)

def test_str():
    errors = 0
    if '1/16/2017' != str(mlk_day):
        errors += 1
    if '1/29/2017' != str(hw3_due):
        errors += 1
    if '7/4/1776' != str(revolution):
        
        errors += 1
    if '2/29/2016' != str(feb_29):
        errors += 1
    print('str {} errors out of {}'.format(errors, 4))

def test_repr():
    errors = 0
    if 'Date(1,16,2017)' != repr(mlk_day):
        errors += 1
    if 'Date(1,29,2017)' != repr(hw3_due):
        errors += 1
    if 'Date(7,4,1776)' != repr(revolution):
        errors += 1
    if 'Date(2,29,2016)' != repr(feb_29):
        errors += 1
    print('repr {} errors out of {}'.format(errors, 4))
        
def test_next_date():
    errors = 0
    tuesday = mlk_day.next_date()
    if str(tuesday) != '1/17/2017':
        errors += 1
    late = hw3_due.next_date()
    if str(late) != '1/30/2017':
        errors += 1
    after_revolution = revolution.next_date()
    if str(after_revolution) != '7/5/1776':
        errors += 1
    march_1 = feb_29.next_date()
    if str(march_1) != '3/1/2016':
        errors += 1
    not_march_1 = Date(2,28,2016).next_date()
    if str(not_march_1) != '2/29/2016':
        errors += 1
    march_1 = Date(2,28,2017).next_date()
    if str(march_1) != '3/1/2017':
        errors += 1
    y2k = Date(12,31,1999).next_date()
    if str(y2k) != '1/1/2000':
        errors += 1
    print('next_date {} errors out of {}'.format(errors, 7))

def test_earlier_date():
    errors = 0
    today = Date(1,17,2017)
    y2k = Date(1,1,2000)
    mlk_day = Date(1,16,2017)
    feb_29 = Date(2,29,2016)
    march_1 = Date(3,1,2016)
    if y2k.earlier_date(today) == False:
        errors += 1
    if today.earlier_date(mlk_day):
        errors += 1
    if feb_29.earlier_date(march_1) == False:
        errors += 1
    print('earlier_date {} errors out of {}'.format(errors, 3))

def test_hw3():
    test_str()
    test_repr()
    test_next_date()
    test_earlier_date()

test_hw3()
