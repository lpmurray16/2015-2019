###########################################################
# CSC 242 Section 504 Winter 2017
# Homework assignment 2:  Writing your own Python module
###########################################################
#
# Logan Murray
# January 19th, 2017


import math

# 1.  (.5 points) This function should return the area of
# a circle.  It is passed the circle's radius.
# Remember that a circle's area is pi times
# the square of its radius.

def circle_area(r):
    area = (r**2)*(math.pi)
    return area   # replace this
     
# 2.  (.5 points) This function is should return the circumference
# of a circle.  It is passed the circle's radius.
# Remember that a circle's circumference is
# 2 * pi * r.

def circle_circumference(r):
    circ = 2 * math.pi * r
    return circ   # replace this
     
# 3.  (1 point) This function should return the length of the
# line segment that connects 2 points.  Each point
# is represented as a tuple of length 2.  The
# first item in the 2-tuple represents the point's
# x co-ordinate, and the second item represents
# its y co-ordinate.
def line_length(p1, p2):
    length = math.sqrt((p1[1]-p2[1])**2+(p1[0]-p2[0])**2)
    
    return length  # replace this
    
# 4.  (1 point) This function should return the perimeter of a triangle.
# It is passed 3 parameters, all of which are tuples of length 2.
# It returns the perimeter of the triangle defined by the 3 points
# represented by the 2-tuples.  

def triangle_perimeter(p1, p2, p3):
    side1 = math.sqrt((p1[1]-p2[1])**2+(p1[0]-p2[0])**2)
    side2 = math.sqrt((p1[1]-p3[1])**2+(p1[0]-p3[0])**2)
    side3 = math.sqrt((p3[1]-p2[1])**2+(p3[0]-p2[0])**2)
    perim = side1 + side2 + side3
    return perim  # replace this

# 5. (1 point) This function is passed 2 parameters:  a floating
# point number f and an integer d.  It should return the number f
# truncated (rounded down) to the specified number
# of digits d after the decimal point.
def truncate(f, d):
    truncNum = round(f, d)
    return truncNum  # replace this
# When you say rounded, your answers for the test are not. The round function
# rounds out the number to the digits d after the decminal place properly.
 
    
     
