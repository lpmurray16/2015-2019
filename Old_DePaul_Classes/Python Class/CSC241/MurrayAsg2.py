#
#
# Assignment 2
#
#
# Logan Murray, I worked alone
#
# MurrayAsg2.ps
#
#
def checkID(id, validIDs):
    var = -1

    for i in range(0,len(validIDs)):
        if validIDs[i] == id.lower():
            var = i
    return var

            
        
def colorNumbers(l):
    newLst = []

    for i in range(0, len(l)):
        if l[i].lower()=="blue":
            newLst.append(0)
        elif l[i].lower()=="red":
            newLst.append(1)
        elif l[i].lower()=="yellow":
            newLst.append(2)
        else:
            newLst.append(3)
    newLst.append(-1)

    return newLst
            
            
            
def simpleSizeCheck(s,max):
    if len(s) > max:
        print('True')
    else:
        print('False')
    

if __name__ == "__main__":
    def check(output, expected):
        if output != expected:
            return "FAILED!"
        else:
            return "PASSED!"
        
    validIDs=['smith02','patel99','johnson75','philmore112','mcnaughton7']
    print('checkID("philMORE112",validIDs"): ' + check(checkID("philMORE112",validIDs),3))
    print('checkID("ferrell20",validIDs"): ' + check(checkID("farrell20",validIDs),-1))
    print('checkID("mCnaughTON7",validIDs"): ' + check(checkID("mCnaughTON7",validIDs),4))
    print('checkID("smith02",validIDs"): ' + check(checkID("smith02",validIDs),0))
    print('checkID("",validIDs"): ' + check(checkID("",validIDs),-1))
    l=["blue","red","Yellow","green","purple","BLUE","green"]
    print('colorNumbers(["blue","red","Yellow","green","purple","BLUE","green"]): ' + check(colorNumbers(l),[0, 1, 2, 3, 3, 0, 3, -1]))
    l=["green","GREEN"]
    print('colorNumbers(["green","GREEN"]): ' + check(colorNumbers(l),[ 3, 3, -1]))
    l=[]
    print('colorNumbers([]): ' + check(colorNumbers(l),[-1]))
    print('simpleSizeCheck("DPU",2): ' + check(simpleSizeCheck("DPU",2),True))
    print('simpleSizeCheck("Hello World!",7): ' + check(simpleSizeCheck("Hello World!",20),False))
    print('simpleSizeCheck("",0): ' + check(simpleSizeCheck("",0),False))
