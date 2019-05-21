############################################
# CSC 242 Section 504 Winter 2017          #
# Starter code for Homework assignment 3   #
# Logan Murray                             #
# January 29, 2017                         #
############################################
class Date:
    def __init__(self, m, d, y):
        
                #month
        if m > 0 and m < 13:
            self.month = m
                #day  
        if m in (1,3,5,7,8,10,12) and d>0 and d<32:
            self.day = d
        elif m in (4,6,9,11) and d>0 and d<31:
            self.day = d
        elif y%4==0 and d>0 and d<30:
            self.day = d
        elif y%100==0 and y%400!=0 and d>0 and d<29:
            self.day = d
                #year
        self.year = y
        
        

    def __str__(self):
        return '{}/{}/{}'.format(self.month, self.day, self.year)
        

    def __repr__(self):
        return 'Date({}, {}, {})'.format(self.month, self.day, self.year)
        

    def next_date(self):
        newMonth=0
        newDay=0
        newYear=0

        if self.month==12 and self.day==31:
            newYear = self.year + 1
            newDay = 1
            newMonth = 1
        elif self.month in (1,3,5,7,8,10) and self.day==31:
            newYear = self.year
            newMonth = self.month + 1
            newDay = 1
        elif self.month in (4,6,9,11) and self.day==30:
            newYear = self.year
            newMonth = self.month + 1
            newDay = 1
        elif self.month==2 and self.day==29 and self.year%4==0:
            newYear = self.year
            newMonth = self.month + 1
            newDay = 1
        elif self.month==2 and self.day==28 and self.year%100==0 and self.year%400!=0:
            newYear = self.year
            newMonth = self.month + 1
            newDay = 1
        else:
            newYear = self.year
            newMonth = self.month
            newDay = self.day + 1
        return Date(newMonth, newDay, newYear)

    def earlier_date(self, other):
        if self.year<other.year:
            return True
        elif self.year==other.year and self.month<other.month:
            return True
        elif self.year==other.year and self.month==other.month and self.day<other.day:
            return True
        elif self.year==other.year and self.month==other.month and self.day==other.day:
            print("Same dates")
        else:
            return False

        
