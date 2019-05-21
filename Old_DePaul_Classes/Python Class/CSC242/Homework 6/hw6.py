###############################################################
# CSC 242 Section 402 Homework Assignment 6
# 8-puzzle
# Logan Murray
###############################################################
#
# Your task is to build an 8-puzzle game, as specified in the
# write-up for this homework.  When the game begins, the user
# is asked if they want to play an easly, medium, or hard game.
#
# Based on the response, a board is displayed which
# is easy, medium, or difficult to solve.  Degree of
# difficulty is measured by how many moves it takes to
# solve the puzzle.

# To play the game, the user clicks on a tile to move it.
# A tile must be adjacent to the empty position on the board
# in order for it to be moved.  If the user clicks on a tile
# that is not adjacent to the empty position,
# your program should do nothing.

# If the user solves the puzzle, then your program
# should display a message as such, and then ask if
# the user wishes to play another game.
###############################################################

from tkinter.ttk import *
from tkinter import *
from tkinter.font import *
from random import shuffle
from random import randint

###############################################################
# I have provided the Board class.  NOTE: THE BOARD CLASS DOES
# NOT DISPLAY A GUI.  Rather, it represents a state of an
# 8-puzzle board.  The instance variable "self.positions" is a
# list which keeps track of the position of the blank spot,
# and each tile.  The position of the empty spot is first,
# and then the positions of the numbered tiles (1-8).  Each
# position is represented as a list of length 2, [ r, c ]
# where r is the row of a tile (or the blank spot) and c is
# the column.  For example, if self.positions[2] is [1, 1],
# then tile 2 is in the center of the board;  if self.positions[0]
# is [2, 2] then the empty spot is in the lower right spot on
# the board

# The class has a constructor, which creates a board in which
# all of the tiles are in their correct positions.  It also
# has a goal method, which determines if a board is in the
# winning state.  Finally, the class has a move method.  It is
# passed a tile number, and if possible, the tile is moved (it
# must be adjacent to the blank position on the board).  The
# move method return True if it has made a move, or False
# otherwise.
###############################################################
class Board:
    def __init__(self):
        self.positions = [[2,2], [0,0], [0,1], [0,2], [1,0], [1,1],
                          [1,2], [2,0], [2,1]]
        self.win = self.positions.copy()
        
    # return True if the Board is the winning position     
    def goal(self):
        if self.positions == self.win:
            return True
        else:
            return False

    # If possible, move a tile into the blank spot.  The tile must be
    # adjacent to the blank in order to be moved there.  Return True
    # if the move took place, or False otherwise
    def move(self, tile):
        blank_loc = self.positions[0]
        tile_loc = self.positions[tile]
        if self.adjacent(tile_loc, blank_loc):
            tmp = tile_loc
            self.positions[tile] = self.positions[0] # the blank
            self.positions[0] = tmp
            return True
        else:
            return False

    # This method determines if two locations are adjacent.
    # loc1 and loc2 are both lists of length 2, of the form [ r, c ]
    # r = a rwo (between 0 and 2) and c = a column
    def adjacent(self, loc1, loc2):
        if loc1[0] == loc2[0] and abs(loc1[1] - loc2[1]) == 1:
            return True
        elif loc1[1] == loc2[1] and abs(loc1[0] - loc2[0]) == 1:
            return True
        else:
            return False

    # This method returns a list of the tiles which currently can
    # be moved; i.e., those tiles which are adjacent to the blank.
    # For example
    #
    #############
    # 1 # 3 # 6 #
    #############
    # 2 # 5 #   #
    #############
    # 7 # 8 # 4 #
    #############
    #
    # The function should return [4, 5, 6] (although the ordering
    # does not matter).

    def movable_tiles(self):
        ans = [ ]
        for i in range(1,9):
            if self.adjacent(self.positions[i], self.positions[0]):
                ans.append(i)
        return ans
    
###############################################################
# The EightPuzzle class is intended to be the GUI portion of this
# program.  THIS IS WHAT YOU MUST COMPLETE FOR THE ASSIGNMENT.
# The class renders the 8-puzzle board as represented by a Board
# object (see above).
#
# Before the game begins, the constructor displays an initial
# window which asks the user to pick a skill level (easy,
# medium, or hard), and configures a puzzle according to the
# skill level.  You do not need to modify this code unless you
# want to.  However, you will have to write the event handling
# code which responds to the user's interaction with the
# initial window
###############################################################
class EightPuzzle:
    def __init__(self):
        self.window = Tk()
        self.f = Font(family='Times', size=32) 
        self.board = Board()
        self.buttons = { }
        l = Label(self.window, text='Welcome to 8-puzzle.  Select from the', font=self.f)
        l.grid(row=0,column=0, sticky=W)
        l = Label(self.window, text='following to determine the level of', font=self.f)
        l.grid(row=1, column=0, sticky=W)
        l = Label(self.window, text='difficulty of your game.', font=self.f)
        l.grid(row=2, column=0, sticky=W)
        bottom_frame = Frame(self.window)
        bottom_frame.grid(row=3,column=0)
        radio_frame = Frame(bottom_frame)
        radio_frame.grid(row=0,column=0)
        self.i = IntVar()
        self.easy = Radiobutton(radio_frame,text='Easy',variable=self.i,value=5,font=self.f)
        self.medium = Radiobutton(radio_frame,text='Medium',variable=self.i,value=15,font=self.f) 
        self.hard = Radiobutton(radio_frame,text='Hard',variable=self.i,value=50,font=self.f) 
        self.easy.grid(row=0,column=0,sticky=W)
        self.medium.grid(row=1,column=0,sticky=W)
        self.hard.grid(row=2,column=0, sticky=W)
        b = Button(bottom_frame, text='Ready to play', font=self.f)
        b.bind('<Button-1>', self.initialize_board)
        b.grid(row=3,column=1,sticky=E)
        self.easy.select()
        self.hard.deselect()
        self.medium.deselect()

    # The initialize_board method is worth 1 point.  It
    # initializes the board in such a way that it is "easy",
    # "medium", or "hard" to solve.  The difficulty of a
    # board reflects the number of moves the player
    # needs to move in order to solve it.
    
    #
    # The instance variable "self.i" tells you which level the
    # user has selected, where 0 means "easy", 1 means "medium"
    # and 2 means "hard".
    def initialize_board(self, event):
        # The Board constructor creates a board in the winning state.
        self.board = Board()
        # Make enough moves away from this state so as to make
        # the puzzle easy to solve, medium hard, or hard.
        easy_board = [[0,0], [1, 0], [0, 1], [0, 2],
                      [2, 0], [1, 2], [2, 2], [2, 1], [1, 1]]

        medium_board = [[1, 1], [1, 0], [0, 0], [1, 2],
                        [2, 0], [0, 2], [0, 1], [2, 1], [2, 2]]


        hard_board = [[2, 1], [2, 0], [1, 0], [1, 1],
                        [2, 2], [0, 2], [0, 0], [0, 1], [1, 2]]

        how_hard = self.i   # a number between 0 and 2
        if self.i==0:
            # call easy_board
            self.board = easy_board
        elif self.i==1:
            # call medium_board
            self.board = medium_board
        elif self.i==2:
            # call hard_board
            self.board = hard_board
            
            
                
                
                
                    
                
        


    # The display method is worth 1 point.  It should render the
    # state of the 8-puzzle as reflected by the Board object that
    # your code must create.  As you create Buttons to be displayed
    # on the window (each button represents a tile), you should
    # bind the button to the "move" event handler method below,
    # so that when the user clicks one of tiles the program will
    # move it (if it is adjecent to the empty space)
    def display(self):
        window = Tk()
        self.font = Font(window, family='Times', size=32)
        # display each tile
        for i in range(1,9):
            b = Button(window, text=str(i), font=self.font)    
            # now place the Button in the correct spot on the GUI
            # and bind it to the "move" event handler in the
            # proper way.

 
    # The move method is worth 1 point.  It is the event-handler
    # which responds to the user clicking a tile.
    # The method should move the tile if it is next to
    # the blank spot, and also update the Board object to
    # reflect this move.  The GUI must be updated as well.  Finally,
    # for 1 point of extra credit, if this move has left the Board
    # in the winning state, your program should display a message,
    # stop the program, and ask if the user wants to play again.
    def move(self, event):
        tile = self.buttons[event.widget] # tile is a number between 1 and 8
        if self.board.move(tile):
            pass
            
