import urllib.parse
import urllib.request
import json
import pytumblr
from crawler_abst_api import CrawlerAbstractAPI


class MyAPI (CrawlerAbstractAPI):
    """
    Encapsulates the interactions for the API used in lab.
    There are people and tags. Person is bipartite 0. Tags bipartite 1.

    Variables
    _baseUrl -- This is the URL that access the API interface
    _delay -- Number of seconds to wait between API calls
    """

    # pytumblr client object
    client = pytumblr.TumblrRestClient(
  'SlMoQdUvgKOJtsoumKr51KScsNUkVjatzyV4HlWcTWtO717pSW',
  'ZVcBFRgkcHz90E6Os42QCYflWSGUkoCkbD7ZhPz4K3eeV1Z8fZ',
  'oXTln8YlElNpomHDweJkOqPykPNoWMh712Nb4lDWcs9AWk5qSy',
  'uJJQkZCMlqENhfnrnrKMuE4xVInO3hXTMSaAfYvM0Qzh6i779q')
    
    #_nameQuery = "get-users.py?q={}"
    #_tagQuery = "get-tags.py?q={}"
    #_nameErrorTest = "get-users.py?q={}&ErrRate=100"
    lotrDict = {}

    #overwrite the delay
    def __init__(self):
        super().__init__()
        self._delay = 1

    def initial_nodes(self):
        ## Starting tag for Lord of the Rings = "#lord of the rings"
        ## Starting tag for Star Trek = "#star trek"
        initial_tag = 'lord of the rings'

        # You might have make a query to get the attribute here.
        return [(initial_tag, self.make_node_tag(initial_tag, 0))]

    def make_node_blog(self, blog,total_posts, timestamp, depth):
        """
        Makes a node representing a tumblr blog

        Arguments
        id -- the node id (converted to a string)
        name -- user name
        totposts -- the number of posts in this blog
        depth -- depth of the search to this point
        graph -- Graph object to add the node to
        """
        nid = self.make_node(0, blog, depth)
      #  self._graph.nodes[nid]

        #WITH A NODE ATTRIBUTE
        self._graph.nodes[nid]['total_posts']=total_posts
        self._graph.nodes[nid]['timestamp']=timestamp

        return nid

    def make_node_tag(self, tag, depth):
        """
        Makes a node representing a tumblr tag

        Arguments
        id -- the node id (converted to a string)
        tag -- the tag string
        depth -- depth of the search to this point
        graph -- Graph object to add the node to
        """
        nid = super().make_node(1, tag, depth)
        return nid

		
		
    def execute_blogs_query(self, tag):
        """
        Executes the tumblr blogs query and parses the results.

        Arguments
        tag -- a tag

        Returns
        (success flag, data) -- tuple
        success flag -- true if the values were successfully parsed (no errors)
        data -- a list of (name, planet) pairs that resulted from the query
        """
        lotrBlogs = []
		
		#our network obtains nodes that have posted with this tag about a year ago
        lotr = self.client.tagged(tag,before=1506844606,limit=6)
		
		#recieving all the information right away/ filtering
        for post in lotr:
            #Is this user still active? if they have not been active a month ago, filter them - lotrfashion is for the win here
            timestamp = post['blog']['updated']
            if timestamp < 1538380606:
                continue
            blog_name = post['blog_name']
            blog_info = self.client.blog_info(blog_name + '.tumblr.com')
            total_posts = blog_info['blog']['total_posts']	
            tags_list = post['tags']
            self.lotrDict[blog_name] = tags_list
            lotrBlogs.append((blog_name,total_posts, timestamp))
        try:
            data = self.lotrDict
            if data == {}:
                return self._ERROR_RESULT
            #return (True, lotrBlogs)
			#THIS IS WITH A NODE ATTRIBUTE
            return (True, lotrBlogs)
							
        except ValueError as e:
            # Usually this means that the API call has failed
            print(e)
            return self._ERROR_RESULT
        except TypeError as e:
            print(e)
            return self._ERROR_RESULT

    def execute_tags_query(self, blog):
        """
        Executes the tags query and parses the results -> gets the tags from the blog post.

        Arguments
        blog -- a tumblr blog

        Returns
        (success flag, data) -- tuple
        success flag -- true if the values were successfully parsed (no errors)
        data -- a list of tags that resulted from the query
        """
        nextTag = self.lotrDict[blog]
        try:
            data = self.lotrDict[blog]
            if data == {}:
                return self._ERROR_RESULT
            return (True, nextTag)
        except ValueError as e:
            # Usually this means that the API call has failed
            print(e)
            return self._ERROR_RESULT
        except TypeError as e:
            print(e)
            return self._ERROR_RESULT

    # These are tumblr blogs bipartite 0
    def get_child0(self, node, graph, state):
        blog = graph.nodes[node]['label']
        success, data = self.execute_tags_query(blog)
        if success:
            # Distinguish nodes previously seen from new nodes
            old_tags = [tag for tag in data if state.is_visited(1, tag)]
            new_tags = [tag for tag in data if not (state.is_visited(1, tag))]

            # Get the existing nodes
            old_nodes = [state.visited_node(1, tag) for tag in old_tags]

            # Create the new nodes
            new_depth = graph.nodes[node]['_depth'] + 1
            new_nodes = [self.make_node_tag(tag, new_depth)
                         for tag in new_tags]
            # Return the dict with the info
            return {'success': True, 'new': new_nodes, 'old': old_nodes}
        else:
            return {'success': False}

    # These are tumblr tags bipartite 1
    def get_child1(self, node, graph, state):
        tag = graph.nodes[node]['label']
        success, data = self.execute_blogs_query(tag)
        if success:
            # Distinguish nodes previously seen from new nodes
            old_blogs = [blog for blog, total_posts,timestamp in data if state.is_visited(0, blog)]
            new_blogs = [(blog, total_posts, timestamp) for blog,total_posts,timestamp in data if not (state.is_visited(0, blog))]
            old_nodes = [state.visited_node(0, blog) for blog in old_blogs]
			#NOTE: changed node to nodes
            new_depth = graph.nodes[node]['_depth'] + 1
            new_nodes = [self.make_node_blog(blog, total_posts, timestamp, new_depth)
                         for blog,total_posts,timestamp in new_blogs]
            return {'success': True, 'new': new_nodes, 'old': old_nodes}
        else:
             return {'success': False}
        """
        tag = graph.nodes[node]['label']
        success, data = self.execute_blogs_query(tag)
        if success:
            # Distinguish nodes previously seen from new nodes
            old_blogs = [blog for blog in data if state.is_visited(0, blog)]
            new_blogs = [blog for blog in data if not (state.is_visited(0, blog))]
            old_nodes = [state.visited_node(0, blog) for blog in old_blogs]
			#NOTE: changed node to nodes
            new_depth = graph.nodes[node]['_depth'] + 1
            new_nodes = [self.make_node_blog(blog,new_depth)
                         for blog in new_blogs]
            return {'success': True, 'new': new_nodes, 'old': old_nodes}
        else:
            return {'success': False}
        """
