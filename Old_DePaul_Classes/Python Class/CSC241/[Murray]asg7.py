#
# Logan Murray
# October 28th, 2016
# CSC241
#




def unique(lst):
    """This program should take a list of list.
    From the lists it finds and counts unique numbers
    and returns the amount of them"""
    rtnLst=[]
    for i in lst:
        for j in i:
            if j not in rtnLst:
                rtnLst.append(j)
            
    return len(rtnLst)
                
            
    
            
            
            
        

def vote(votelst,namelst):
    """This program takes two lists,
    then it determines the winner of a vote and returns said winner"""
    tot=0
    winner=''
    winVote=0
    for name in namelst:
        for 
            
            
            
            
                
        
    
    
        
            
           
    #print('The winner is {} with {} votes.'.format(winner,winVote))
    
        
            


if __name__ == "__main__":
    def check(output, expected):
        if output != expected:
            return "FAILED!"
        else:
            return "PASSED!"
    print("RUNNING CHECK ...")
    print('unique([[0,1,1,0],[1,1,0],[0,0,1,0]]): ' + check(unique([[0,1,1,0],[1,1,0],[0,0,1,0]]),2))
    print('unique([[1,2,3,4],[5,6],[7,8,9,10,11,12]]): ' + check(unique([[1,2,3,4],[5,6],[7,8,9,10,11,12]]),12))
    print('unique([[1,2,3,1,5],[2,1,3],[5,5,2,1,3]]): ' + check(unique([[1,2,3,1,5],[2,1,3],[5,5,2,1,3]]),4))    
    print()
    print("vote([[1,0],[0,0],[0,0]],['Smith','Jones']): " + check(vote([[1,0],[0,0],[0,0]],['Smith','Jones']),'The winner is Smith with 1 votes.'))
    print("vote([[1,0],[0,100],[0,0]],['Smith','Jones']): " + check(vote([[1,0],[0,100],[0,0]],['Smith','Jones']),'The winner is Jones with 100 votes.'))          
    print("vote([[1,0,3],[0,10,1],[0,0,16]],['Smith','Jones','Williams']): " + check(vote([[1,0,3],[0,10,1],[0,0,16]],['Smith','Jones','Williams']),'The winner is Williams with 20 votes.')) 
    print()
    
