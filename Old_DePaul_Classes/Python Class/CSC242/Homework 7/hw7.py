####################################
# CSC 242 Section 504 Winter 2017
# Homework 7
# Logan Murray
####################################
# Please refer to the lab write-up
# for a descripion of the goal of
# this lab
####################################

from urllib.request import *
from urllib.error import *
from html.parser import *
from urllib.parse import urljoin

class Headlines(HTMLParser):

    def __init__(self, url):
        HTMLParser.__init__(self)
        self.url = url
        self.tag = None
        self.f = open('headlines.html','w')
        
    def handle_starttag(self, tag, attrs):
        if tag in ['h1', 'h2', 'h3']:
            self.tag = True
                
    def handle_data(self, data):
        if self.tag != None:
            print(str(data))
            
            
            

    def handle_endtag(self, tag):
        if tag in ['h1', 'h2', 'h3']:
            self.tag = False

    def headlines(self):
        contents = urlopen(self.url).read().decode()
        self.feed(contents)
        self.f.close()
