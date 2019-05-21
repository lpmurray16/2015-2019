#
#
# Assignment 3
#
#
# Logan Murray, I worked alone and played every role...
#
# This file MUST BE NAMED [your last name]Asg3.ps
#
#


def calcDist(dinfo):
    rtnLst=[]
    if dinfo==[]:
        return [0, 0]
    else:
        totDist=0
        numCit=[]
        for i in range(1,len(dinfo),2):
            totDist=dinfo[i]+totDist
        rtnLst.append(totDist)
        for i in range(0,len(dinfo),2):
            numCit.append(dinfo[i])
        if numCit[0]==numCit[-1]:
            numCit.remove(numCit[-1])
        
        rtnLst.append(len(numCit))
            
        return rtnLst
            
            
        

def uniqueLasts(s):
    namelist=s.split(sep=", ")
    newlist=[]
    for i in range(0,len(namelist)):
        namelist[i]=namelist[i].title()
    
    for i in range(0,len(namelist)):
        if namelist[i] not in newlist:
            newlist.append(namelist[i])
    newlist.sort()
        
        
    return newlist
        
        
        
    
     
        
    


def triangleTypes(s):
    if s =="":
        return "No values were given"

    s=s.split(sep=";")
    
    for i in range(0,3):
        s[i]=int(s[i])
    if max(s)==90:
        result='a right triangle'
    elif max(s)>90:
        result='obtuse'
    elif max(s)<90:
        result='acute'
    
            
    return '''The triangle with angles {}, {}, and {} is {}'''.format(s[0],s[1],s[2],result)
    
    



if __name__ == "__main__":
    def check(output, expected):
        if output != expected:
            return "FAILED!"
        else:
            return "PASSED!"
    print("RUNNING CHECK ...")
    print('calcDist(citydist): ' + check(calcDist(["Chicago",90,"Milwaukee",436,"Cleveland",168,"Detroit",614,"New York City"]),[1308,5]))
    print('calcDist(citydist): ' + check(calcDist([]),[0,0]))
    print('calcDist(citydist): ' + check(calcDist(["Chicago",90,"Milwaukee",436,"Cleveland",168,"Detroit",614,"New York City",789,"Chicago"]),[2097,5]))
    print()
    print('uniqueLasts(names): ' + check(uniqueLasts("Domel, domel, SMITH, smitH, PATel, GoMez, gomez, JONAS, JONNAS"),['Domel','Gomez','Jonas','Jonnas','Patel','Smith']))
    print('uniqueLasts(names): ' + check(uniqueLasts(""),[]))
    print('uniqueLasts(names): ' + check(uniqueLasts("SMITH, SMITH, SMITH, smith, smith, smith, smith, SMith"),['Smith']))
    print()
    print('triangleTypes(s): ' + check(triangleTypes("10;70;100"),'The triangle with angles 10, 70, and 100 is obtuse.'))
    print('triangleTypes(s): ' + check(triangleTypes(""),'No angles were given.'))
    print('triangleTypes(s): ' + check(triangleTypes("60;60;60"),'The triangle with angles 60, 60, and 60 is equiangular.'))
    print('triangleTypes(s): ' + check(triangleTypes("90;45;45"),'The triangle with angles 90, 45, and 45 is right.'))
    print('triangleTypes(s): ' + check(triangleTypes("55;55;70"),'The triangle with angles 55, 55, and 70 is acute.'))
