#
# Your name
# Final exam CSC241
# 

def buildDict(k1,k2,v2):
    keyList=[]
    returnDict={}
    if k1==[] or k2==[] or v2==[]:
        return [-1]
    else:
        for i in range(len(k1)):
            temp=(k1[i],k2[i])
            keyList.append(temp)
        for i in range(len(keyList)):
            returnDict[keyList[i]]=v2[i]
        return returnDict
    
        
        

# 

def useD(lst1,lst2):
    Dict={'0':'zero','1':'one','2':'two','3':'three','4':'four','5':'five','6':'six','7':'seven','8':'eight','9':'nine'}
    returnLst=[]
    for num in lst1:
        if num in Dict:
            num=Dict[num]
            returnLst.append(num)
        else:
            returnLst.append(num)
    for num in lst2:
        if num in Dict:
            num=Dict[num]
            returnLst.append(num)
        else:
            returnLst.append(num)
    return sorted(returnLst)
            
    
    

# 

def sWork(ifile):
    returnLst=set()
    infile=open(ifile,'r')
    content=infile.read()
    content=content.lower()
    content=content.replace('.','')
    content=content.replace(',','')
    content=content.replace('-',' ')
    content=content.replace('--',' ')
    content=content.replace('"','')
    wordLst=content.split()
    for i in wordLst:
        count=wordLst.count(i)
        word=i
        temp=(count,i)
        returnLst.add(temp)
    return sorted(returnLst)



def jump(lst,stpt):
    returnLst=[]
    count=0
    usedVal=[]
    done=False
    try:
        while not done:
            if stpt>0 and stpt<len(lst):
                if stpt not in usedVal:
                    usedVal.append(stpt)
                    returnLst.append(lst[stpt][0])
                    stpt=lst[stpt][1]
                else:
                    done=True
            else:
                returnLst.clear()
                raise IndexError
        returnLst.append(len(returnLst))
        raise IndexError
    except IndexError:
        return returnLst
        
        
        
        

def milestopencils(ifile):
    infile=open(ifile,'r')
    returnLst=[]
    newValues=[]
    firstCity=[]
    secondCity=[]
    content=infile.read()
    content=content.replace('\n',';')
    workLst=content.split(';')
    for i in range(2,len(workLst),3):
        workLst[i] = float(workLst[i])
        conValue= 7920 * workLst[i]
        conValue=round(conValue)
        conValue="{:,}".format(conValue)
        newValues.append(conValue)
        
    for i in range(0,len(workLst),3):
        firstCity.append(workLst[i])
    
    for i in range(1,len(workLst),3):
        secondCity.append(workLst[i])
        
    for i in range(len(newValues)):
        tup=(firstCity[i],secondCity[i],"{} pencils".format(newValues[i]))
        returnLst.append(tup)
    return returnLst
        
    
    
    
# 
def milestostrides(ifile):
    infile=open(ifile,'r')
    returnLst=[]
    oldValue=[]
    newValue=[]
    firstCity=[]
    secondCity=[]
    content=infile.read()
    content=content.replace('\n',';')
    workLst=content.split(';')
    #print(workLst)
    for i in range(0,len(workLst),3):
        firstCity.append(workLst[i])
    #print(firstCity)
    for i in range(1,len(workLst),3):
        secondCity.append(workLst[i])
    #print(secondCity)
    for i in range(2,len(workLst),3):
        oldValue.append(workLst[i])
    #print(oldValue)
    for i in range(0,len(firstCity)):
        tup=(firstCity[i],secondCity[i],oldValue[i])
        returnLst.append(tup)
    #print(returnLst)
    
    try:
        for i in range(len(returnLst)):
            if returnLst[i][2]!='' and float(returnLst[i][2]) >= 0.0:
                newNumber=float(returnLst[i][2])
                #print(newNumber)
            else:
                raise ValueError
    except ValueError:
        returnLst[i]="ERROR: Invalid input found in this line: {}".format(returnLst[i])
        print(returnLst)

    
                
            
                
            
#returnLst.replace(i,"ERROR!: Invalid input found in this line: {}".format(i))
    
#i[2]=2*(63360/53*float(i[2]))
    
    
    
    
    
        
        
#     

def addstring(s,n):
    countLst=[]
    newNumber=-1
    try:
        if s=='' or n > len(s):
            raise ValueError
        else:
            for i in range(n,len(s)):
                if s[i] =='0' or s[i]=='1' or s[i]== '2' or s[i]== '3' or s[i]== '4' or s[i]== '5' or s[i]== '6' or s[i]== '7' or s[i]== '8' or s[i]== '9':
                    newNumber=int(s[i])
                    countLst.append(newNumber)
                elif s[i] =='*':
                    raise ValueError
            raise ValueError
    except ValueError:
        if sum(countLst)==0:
            return -1
        else:
            return sum(countLst)
            
    
    
    
    
            
            
            
            

#

def changestring(s,s1,s2):
    newStr=''
    firstPart=s.split('*')
    if s=='' or s1=='' or s2=='':
        print('')
    else:
        
        try:
            if s1 in firstPart[0]:
                s=s.replace(s1,s2)
                s=s.replace('*','')
            else:
                raise ValueError
            return s
        except ValueError:
            print("{} is not present in {}".format(s1,s))
        
        
    


if __name__ == "__main__":
    def check(output, expected):
        if output != expected:
            return "FAILED!"
        else:
            return "PASSED!"
    print("RUNNING CHECK ...")
    print()
    print("PROBLEM 1")
    print("buildDict(['Chicago','Detroit','New York','Seattle'],['IL','MI','NY','WA'],['a102','a44','b33','c3']): "+ check(buildDict(['Chicago','Detroit','New York','Seattle'],['IL','MI','NY','WA'],['a102','a44','b33','c3']),{('New York', 'NY'): 'b33', ('Detroit', 'MI'): 'a44', ('Seattle', 'WA'): 'c3', ('Chicago', 'IL'): 'a102'}))
    d=(buildDict(['Chicago','Detroit','New York','Seattle'],['IL','MI','NY','WA'],['a102','a44','b33','c3']))
# uncomment these when your dictionary is working. Otherwise it will bomb.
    #print("d[('Seattle','WA')]: "+check(d[('Seattle','WA')],'c3'))
    #print("d[('Chicago','IL')]: "+check(d[('Chicago','IL')],'a102'))
    print()
    print("PROBLEM 2")
    print("useD(['one','two','three','4','5','6','7'],['0','zero']): "+check(useD(['one','two','three','4','5','6','7'],['0','zero']),['five', 'four', 'one', 'seven', 'six', 'three', 'two', 'zero', 'zero']))
    print("useD(['two','three','4','five','6','3'],['0','one','four']): "+check(useD(['two','three','4','five','6','3'],['0','one','four']),['five', 'four', 'four', 'one', 'six', 'three', 'three', 'two', 'zero']))
    print("useD(['two','three','4','five','6','3'],[]): "+check(useD(['two','three','4','five','6','3'],[]),['five', 'four', 'six', 'three', 'three', 'two']))
    print("useD([],['1']): "+check(useD([],['1']),['one']))
    print("useD([],[]): "+check(useD([],[]),[]))
    print()
    print("PROBLEM 3")
    print("sWork('stvdp.txt'): "+check(sWork('stvdp.txt'),[(1, '15'), (1, '1581'), (1, 'age'), (1, 'an'), (1, 'avoid'), (1, 'been'), (1, 'believed'), (1, 'bernard'), (1, 'bertrande'), (1, 'birth'), (1, 'born'), (1, 'brothers'), (1, 'by'), (1, 'child'), (1, 'childhood'), (1, 'claudine'), (1, 'correspondents'), (1, 'depaul'), (1, 'derivation'), (1, 'did'), (1, 'during'), (1, 'early'), (1, 'family'), (1, "family's"), (1, 'family’s'), (1, 'farmers'), (1, 'france'), (1, 'gayon'), (1, 'guyenne'), (1, 'had'), (1, 'have'), (1, 'herder'), (1, 'him'), (1, 'inference'), (1, 'is'), (1, 'kingdom'), (1, 'livestock'), (1, 'managing'), (1, 'might'), (1, 'moras'), (1, 'mother'), (1, 'named'), (1, 'noble'), (1, 'none'), (1, 'one'), (1, 'oxen'), (1, 'pay'), (1, 'peasant'), (1, 'possibly'), (1, 'pouy'), (1, 'province'), (1, 'reading'), (1, 'selling'), (1, 'seminary'), (1, 'sent'), (1, 'showed'), (1, 'sisters'), (1, 'so'), (1, 'stream'), (1, 'talent'), (1, 'there'), (1, 'third'), (1, 'this'), (1, 'three'), (1, 'two'), (1, 'vicinity'), (1, 'village'), (1, 'vincent'), (1, 'word'), (1, 'work'), (1, 'writing'), (1, 'wrote'), (2, 'as'), (2, 'at'), (2, 'but'), (2, 'de'), (2, 'father'), (2, 'for'), (2, 'gascony'), (2, 'it'), (2, 'jean'), (2, 'marie'), (2, 'name'), (2, 'paul'), (2, 'that'), (3, 'a'), (3, '–'), (4, 'to'), (5, 'he'), (5, 'his'), (5, 'in'), (5, 'was'), (7, 'and'), (7, 'of'), (11, 'the')]))
    print("sWork('stvdp2.txt'): "+check(sWork('stvdp2.txt'),[(1, '1605'), (1, 'administer'), (1, 'alchemist'), (1, 'an'), (1, 'arts'), (1, 'as'), (1, 'auctioned'), (1, 'back'), (1, 'barbary'), (1, 'became'), (1, 'bidder'), (1, 'bondage'), (1, 'brought'), (1, 'but'), (1, 'captive'), (1, 'castres'), (1, 'de'), (1, 'due'), (1, 'fascinated'), (1, 'first'), (1, 'fisherman'), (1, 'for'), (1, 'gone'), (1, 'highest'), (1, 'him'), (1, 'how'), (1, 'inheritance'), (1, 'inventor'), (1, 'line'), (1, 'marseilles'), (1, "master's"), (1, 'next'), (1, 'of'), (1, 'off'), (1, 'on'), (1, 'patron'), (1, 'paul'), (1, 'physician'), (1, 'pirates'), (1, 'prepare'), (1, 'property'), (1, 'received'), (1, 'remedies'), (1, 'sailed'), (1, 'sea'), (1, 'sell'), (1, 'sickness'), (1, 'slave'), (1, 'sold'), (1, 'some'), (1, 'soon'), (1, 'spagyric'), (1, 'spagyrical'), (1, 'spent'), (1, 'taken'), (1, 'taught'), (1, 'the'), (1, 'this'), (1, 'toulouse'), (1, 'tunis'), (1, 'two'), (1, 'unsuitable'), (1, 'way'), (1, 'wealthy'), (1, 'where'), (1, 'who'), (1, 'work'), (1, 'years'), (2, 'by'), (2, 'had'), (2, 'master'), (2, 'vincent'), (3, 'from'), (3, 'he'), (4, 'a'), (4, 'in'), (5, 'his'), (5, 'to'), (6, 'and'), (7, 'was')]))
    print()
    print("PROBLEM 4")
    lst=[['a',8],['b',2],['c',7],['d',1],['e',5],['f',0],['g',5],['h',8],['i',1]]
    print("jump(lst,2): "+check(jump(lst,2),['c','h','i','b',4]))
    print("jump(lst,11): "+check(jump(lst,11),[]))
    print("jump(lst,-1): "+check(jump(lst,-1),[]))
    print("jump(lst,8): "+check(jump(lst,8),['i','b','c','h',4]))
    print("jump(lst,3): "+check(jump(lst,3),['d','b','c','h','i',5]))
    print()
    print("PROBLEM 5")
    print("milestopencils('mileage.txt'): "+check(milestopencils('mileage.txt'),[('Chicago', 'Washington D.C', '4,705,985 pencils'), ('Chicago', 'Milwaukee', '645,638 pencils'), ('Chicago', 'San Diego', '13,729,320 pencils')]))
    print()
    print("PROBLEM 6")
    print("milestostrides('mileage1.txt'): "+check(milestostrides('mileage1.txt'),['ERROR: Invalid input found in this line: Chicago;Austin;0',['Chicago', 'Washington D.C', '1,420,675 strides'], ['Chicago', 'Milwaukee', '194,910 strides'], 'ERROR: Invalid input found in this line: Chicago;;99', 'ERROR: Invalid input found in this line: Chicago;Detroit;ttt', 'ERROR: Invalid input found in this line: Chicago;;', 'ERROR: Invalid input found in this line: ;;', 'ERROR: Invalid input found in this line: Chicago;Richmond;-9', ['Chicago', 'San Diego', '4,144,700 strides']]))
    print("milestostrides('mileage.txt'): "+check(milestostrides('mileage.txt'),[['Chicago', 'Washington D.C', '1,420,675 strides'], ['Chicago', 'Milwaukee', '194,910 strides'], ['Chicago', 'San Diego', '4,144,700 strides']]))
    print()
    print("PROBLEM 7")
    print("addstring('abcdefg',3): "+check(addstring('abcdefg',3),-1))
    print("addstring('1abcd1efg',3): "+check(addstring('1abcd1efg',3),1))
    print("addstring('1abcd*1efg',0): "+check(addstring('1abcd*1efg',0),1))
    print("addstring('1abcd1efg*',0): "+check(addstring('1abcd1efg*',0),2))
    print("addstring('',0): "+check(addstring('',0),-1))
    print("addstring('',55): "+check(addstring('',55),-1))
    print("addstring('12345*6789',0): "+check(addstring('12345*6789',0),15))
    print("addstring('12345*6789',6): "+check(addstring('12345*6789',6),30))
    print()
    print("PROBLEM 8")
    print("changestring('abc123def456abc','abc','xxx'): "+check(changestring('abc123def456abc','abc','xxx'),'xxx123def456xxx'))
    print("changestring('abc123def456abc*','abc','xxx'): "+check(changestring('abc123def456abc*','abc','xxx'),'xxx123def456xxx'))
    print("changestring('ab*c123def456abc','abc','xxx'): "+check(changestring('ab*c123def456abc','abc','xxx'),'abc not present in ab*c123def456abc'))
    print("changestring('abc*','abc','xxx'): "+check(changestring('abc*','abc','xxx'),'xxx'))
    print("changestring('abcdefgh*','','xxx'): "+check(changestring('abcdefgh*','','xxx'),''))
    print("changestring('','abc','xxx'): "+check(changestring('','abc','xxx'),''))
