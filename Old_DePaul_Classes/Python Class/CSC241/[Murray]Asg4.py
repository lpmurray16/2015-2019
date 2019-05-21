
def countMembers(ifile):
    infile=open(ifile,'r')
    
    content=infile.read()
    newlist=[]
    listBreak=content.split("\n")
    count=0
    
            
    
        
        
        
            
            
    


    print(newlist)

def sumWords(ifile,lcount):
   infile=open(ifile,'r')
   content=infile.readlines()
   if len(content)>lcount:
       return -1
   for i in range(0,lcount):
       len(content[i])
        
    
   
        
        

def countWord(ifile,s):
    infile=open(ifile,'r')
    content=infile.read()
    returnList=[]

    
        
        
            
if __name__ == "__main__":
    def check(output, expected):
        if output != expected:
            return "FAILED!"
        else:
            return "PASSED!"
        
    print('countMembers("namenum.txt"): ' + check(countMembers("namenum.txt"),['60', 2, '78', 2, '81', 3]))
    print('countMembers("namenum2.txt"): ' + check(countMembers("namenum2.txt"),['60', 3, '78', 3, '81', 6]))
    print('sumWords("namenum.txt",3)' + check(sumWords("namenum.txt",3),6))
    print('sumWords("namenum.txt",10)' + check(sumWords("namenum.txt",10),-1))
    print('sumWords("gettysburg.txt",5)' + check(sumWords("gettysburg.txt",5),44))
    print('sumWords("gettysburg.txt",25)' + check(sumWords("gettysburg.txt",25),-1))
    print('sumWords("gettysburg.txt",24)' + check(sumWords("gettysburg.txt",24),267))
    print('countWord("namenum2.txt","smith")' + check(countWord("namenum2.txt","smith"),['Line 0', 1, 'Line 1', 0, 'Line 2', 0, 'Line 3', 0, 'Line 4', 0, 'Line 5', 0, 'Line 6', 0, 'Line 7', 0, 'Line 8', 0, 'Line 9', 0, 'Line 10', 0, 'Line 11', 0]))
    print('countWord("namenum.txt","smith")' + check(countWord("namenum.txt","smith"),['Line 0', 1, 'Line 1', 0, 'Line 2', 0, 'Line 3', 0, 'Line 4', 0, 'Line 5', 0, 'Line 6', 0]))
    print('countWord("gettysburg.txt","this")' + check(countWord("gettysburg.txt","this"),['Line 0', 1, 'Line 1', 0, 'Line 2', 0, 'Line 3', 0, 'Line 4', 0, 'Line 5', 0, 'Line 6', 0, 'Line 7', 0, 'Line 8', 0, 'Line 9', 1, 'Line 10', 0, 'Line 11', 0, 'Line 12', 1, 'Line 13', 0, 'Line 14', 0, 'Line 15', 0, 'Line 16', 0, 'Line 17', 0, 'Line 18', 0, 'Line 19', 0, 'Line 20', 0, 'Line 21', 1, 'Line 22', 0, 'Line 23', 0]))
