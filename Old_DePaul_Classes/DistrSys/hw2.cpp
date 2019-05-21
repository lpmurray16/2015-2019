// webpageImageDownloader.c (based upon getinmemory.c)
/***************************************************************************
 *                                  _   _ ____  _
 *  Project                     ___| | | |  _ \| |
 *                             / __| | | | |_) | |
 *                            | (__| |_| |  _ <| |___
 *                             \___|\___/|_| \_\_____|
 *
 * Copyright (C) 1998 - 2018, Daniel Stenberg, <daniel@haxx.se>, et al.
 *
 * This software is licensed as described in the file COPYING, which
 * you should have received as part of this distribution. The terms
 * are also available at https://curl.haxx.se/docs/copyright.html.
 *
 * You may opt to use, copy, modify, merge, publish, distribute and/or sell
 * copies of the Software, and permit persons to whom the Software is
 * furnished to do so, under the terms of the COPYING file.
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY
 * KIND, either express or implied.
 *
 ***************************************************************************/
/* <DESC>
 * Shows how the write callback function can be used to download data into a
 * chunk of memory instead of storing it in a file.
 * </DESC>
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <curl/curl.h>
#include <list>
#include <string>
#include <algorithm>

//	 ----	----	----	 ----	----	----	 ----	----	//
//									//
//			    Definition of constants:			//
//									//
//	 ----	----	----	 ----	----	----	 ----	----	//

//  PURPOSE:  To tell a first possible beginning to the image tag.
#define		BEGIN_IMAGE_TAG0	"<img"

//  PURPOSE:  To tell a second possible beginning to the image tag.
#define		BEGIN_IMAGE_TAG1	"<image"

//  PURPOSE:  To tell the attribute for filenames in image tags.
#define		IMAGE_ATTR		"src"

//  PURPOSE:  To tell a first possible beginning to the link tag.
#define		BEGIN_LINK_TAG0		"<a"

//  PURPOSE:  To tell a second possible beginning to the link tag.
#define		BEGIN_LINK_TAG1		"<a"

//  PURPOSE:  To tell the attribute for filenames in link tags.
#define		LINK_ATTR		"href"

//  PURPOSE:  To tell the end tags.
#define		END_TAG			">"

//  PURPOSE:  To tell the length buffers.
const int	BUFFER_LEN		= 4096;

//  PURPOSE:  To the
const char	QUOTE_CHAR		= 0x22;

//  PURPOSE:  To tell a first beginning external links.
#define		EXTERN_LINK_BEGIN0	"http://"

//  PURPOSE:  To tell a second beginning external links.
#define		EXTERN_LINK_BEGIN1	"https://"

//  PURPOSE:  To tell a purposefully bad link.
#define		BAD_PATH		"/dev/null"


//	 ----	----	----	 ----	----	----	 ----	----	//
//									//
//			Definition of data-structures:			//
//									//
//	 ----	----	----	 ----	----	----	 ----	----	//

//  PURPOSE:  To hold the data read from the HTTP server.
struct		MemoryStruct
{
  char*			memory;
  size_t		size;
};


//  PURPOSE:  To hold filename and how many remaining jumps maybe done from
//		that file.
struct		FileListNode
{
  //  PURPOSE:  To file name.
  std::string		nameStr_;

  //  PURPOSE:  To tell the remaining number of jumps to do from this file.
  int			numRemainingLinks_;

  //  PURPOSE:  To initialize '*this' to have 'newNameCPtr' to be the name.
  FileListNode		(const char*	newNameCPtr,
			 int		newRemainingLinks
			) :
			nameStr_(newNameCPtr),
			numRemainingLinks_(newRemainingLinks)
			{ }

  //  PURPOSE:  To return the filename as a C-string.
  const char*	getNameCPtr	()
  				const
				{ return(nameStr_.c_str()); }
};


//  PURPOSE:  To return 'true' if 'lhs' is equivalent to 'rhs', or 'false'
//  		otherwise.
bool		operator==	(const FileListNode&	lhs,
				 const FileListNode&	rhs
				)
{
  return(lhs.nameStr_ == rhs.nameStr_);
}


//  PURPOSE:  To return 'false' if 'lhs' is equivalent to 'rhs', or 'true'
//  		otherwise.
bool		operator!=	(const FileListNode&	lhs,
				 const FileListNode&	rhs
				)
{
  return( !(lhs == rhs) );
}


//  PURPOSE:  To free() the 'MemoryStruct' pointed to by 'memPtr'.  No return
//		value.
void		freeMemoryStruct	(struct MemoryStruct*	memPtr
					)
{
  if  (memPtr == NULL)
    return;

  if  (memPtr->memory != NULL)
    free(memPtr->memory);

  free(memPtr);
}


//  PURPOSE:  To delete() the memory of 'list'.  No return value.
void		freeFileList		(std::list<FileListNode*>	list
					)
{
  std::list<FileListNode*>::iterator	iter	= list.begin();
  std::list<FileListNode*>::iterator	end	= list.end();

  for  ( ;  iter != end;  iter++)
  {
    delete(*iter);
  }

}


//  PURPOSE:  To be the function called by the CURL library when it reads a
//		file from the web.  'nmemb' tells how many objects were
//		read, each of size 'size' bytes.  'userp' points to the data-
//		structure to receive the memory (in this case a MemoryStruct)
//		instance.  'contents' points to the actual data that was read.
//		Returns the number of bytes that were read: 'size' * 'nmemb'.
static size_t
WriteMemoryCallback(void *contents, size_t size, size_t nmemb, void *userp)
{
  size_t realsize = size * nmemb;
  struct MemoryStruct *mem = (struct MemoryStruct *)userp;

  char *ptr = (char*)realloc(mem->memory, mem->size + realsize + 1);
  if(ptr == NULL) {
    /* out of memory! */
    printf("not enough memory (realloc returned NULL)\n");
    return 0;
  }

  mem->memory = ptr;
  memcpy(&(mem->memory[mem->size]), contents, realsize);
  mem->size += realsize;
  mem->memory[mem->size] = 0;

  return realsize;
}


//  PURPOSE:  To return a pointer to a 'malloc()'-ed 'MemoryStruct' resulting
//		from reading page 'urlCPtr'.  'curl_handle' tells the CURL
//		handle to use, and should be pre-initialized with
//		'CURLOPT_WRITEFUNCTION' and 'CURLOPT_USERAGENT' already set.
//		Returns 'NULL' on error.
struct MemoryStruct*
		getPage		(CURL*		curl_handle,
				 const char*	urlCPtr
				)
{
  struct MemoryStruct*	chunkPtr;
  CURLcode		res;

  chunkPtr	= (struct MemoryStruct*)malloc(sizeof(struct MemoryStruct));
  chunkPtr->memory
		= (char*)malloc(1);
			// will be grown as needed by the realloc above
  chunkPtr->size= 0;	// no data at this point

  /* specify URL to get */
  curl_easy_setopt(curl_handle, CURLOPT_URL, urlCPtr);

  /* we pass '*chunkPtr' struct to the callback function */
  curl_easy_setopt(curl_handle, CURLOPT_WRITEDATA, (void *)chunkPtr);

  /* get it! */
  res = curl_easy_perform(curl_handle);

  /* check for errors */
  if(res != CURLE_OK)
  {
    fprintf(stderr, "curl_easy_perform() failed: %s\n",curl_easy_strerror(res));
    freeMemoryStruct(chunkPtr);
    return(NULL);
  }

  chunkPtr->memory[chunkPtr->size]	= '\0';
  return(chunkPtr);
}


//  PURPOSE:  To which ever of 'run0' and 'run1' comes earlier.
const char*	firstCPtr	(const char*	run0,
      				 const char*	run1
				)
{
  if  (run0 == NULL)
    return(run1);

  if  (run1 == NULL)
    return(run0);

  return( (run0 < run1) ? run0 : run1 );
}


//  PURPOSE:  To return a C++ list of FileListNode addresses of attribute
//	values read obtained from tags parsed from '*pagePtr'.  The tags to
//	look for have forms 'beginTagName0Ptr' and 'beginTagName1Ptr'.  The
//	attribute of those tags whose values are to be listed is
//	'attrNameCPtr'.  'numRemainingLinks' tells the number of jumps value
//	that instances of FileListNode should be given.
std::list<FileListNode*>
		getFileList	(struct MemoryStruct*	pagePtr,
				 const char*		beginTagName0Ptr,
				 const char*		beginTagName1Ptr,
				 const char*		attrNameCPtr,
				 int			numRemainingLinks
				)
{
  std::list<FileListNode*>	list;

  if  ( (pagePtr	 == NULL)  ||
	(pagePtr->memory == NULL)  ||
	(pagePtr->size   == 0)
      )
    return(list);

  const char*	run;
  size_t	tag0Len	= strlen(beginTagName0Ptr);
  size_t	tag1Len	= strlen(beginTagName1Ptr);

  for  ( run  = firstCPtr
			(strcasestr(pagePtr->memory,beginTagName0Ptr),
			 strcasestr(pagePtr->memory,beginTagName1Ptr)
			);

	(run != NULL) && (*run != '\0');

	 run  = firstCPtr
			(strcasestr(run,beginTagName0Ptr),
			 strcasestr(run,beginTagName1Ptr)
			)
       )
  {
    if  (strncasecmp(run,beginTagName0Ptr,tag0Len) == 0)
      run += tag0Len;
    else
      run += tag1Len;

    run = firstCPtr(strcasestr(run,attrNameCPtr),strcasestr(run,END_TAG));

    if  (strncasecmp(run,attrNameCPtr,strlen(attrNameCPtr)) == 0)
    {
      run += strlen(attrNameCPtr);

      for  ( ;  isspace(*run);  run++);

      if  (*run == '=')
      {
	for  (run++;  isspace(*run);  run++);

	if  (*run == QUOTE_CHAR)
	{
	  char	filename[BUFFER_LEN];
	  char*	bufRun;

	  for  (run++, bufRun = filename;  *run != QUOTE_CHAR;  run++, bufRun++)
	  {
	    *bufRun = *run;
	  }

	  *bufRun	= '\0';
	  list.push_back(new FileListNode(filename,numRemainingLinks));
	}
      }

    }
    else
    {
      run += (sizeof(END_TAG) - 1);
    }
  }

  return(list);
}


//  PURPOSE:  To return path composed of 'urlCPtr' followed by 'filePathCPtr'.
const char*	buildPath	(const char*  urlCPtr, const char*  filePathCPtr)
{
  static char	buffer[BUFFER_LEN];
  int		goUpCount		= 0;
  const char*	effectiveBeginUrlCPtr	= strstr(urlCPtr,"://");

  if  (effectiveBeginUrlCPtr == NULL)
    effectiveBeginUrlCPtr	 = urlCPtr;
  else
    effectiveBeginUrlCPtr	+= 3;

  while  (true)
  {
    if  (strncmp(filePathCPtr,"../",3) == 0)
    {
      filePathCPtr += 3;
      goUpCount++;
      continue;
    }

    if  (strncmp(filePathCPtr,"./",2) == 0)
    {
      filePathCPtr += 2;
      continue;
    }

    break;
  }

  if  (*effectiveBeginUrlCPtr == '\0')
  {
    return( (goUpCount > 0) ? BAD_PATH : filePathCPtr );
  }

  const char* endSlashPtr	= strrchr(effectiveBeginUrlCPtr,'/');
  size_t      numBytes;

  if  (endSlashPtr == NULL)
  {
    if  (goUpCount > 0)
    {
      return(BAD_PATH);
    }

    snprintf(buffer,BUFFER_LEN,"%s/%s",urlCPtr,filePathCPtr);
  }
  else
  {
    const char*	endPtr		= effectiveBeginUrlCPtr
    	  			  + strlen(effectiveBeginUrlCPtr)
				  - 1;
    const char*	periodPtr	= strchr(endSlashPtr+1,'.');

    if  (periodPtr != NULL)
    {
      endPtr	= endSlashPtr;
    }

    if  (*endPtr == '/')
    {
      endPtr--;
    }

    if  (endPtr < effectiveBeginUrlCPtr)
    {
      return(BAD_PATH);
    }

    for  (int i = 0;  i < goUpCount;  i++)
    {
      for  (endPtr--;  *endPtr != '/';  endPtr--)
      {
	if  (endPtr < effectiveBeginUrlCPtr)
	{
	  return(BAD_PATH);
	}
      }
    }

    numBytes	= endPtr-urlCPtr+1;
    memcpy(buffer,urlCPtr,numBytes);

    if  (*endPtr == '/')
      strcpy(buffer+numBytes,filePathCPtr);
    else
    {
      buffer[numBytes] = '/';
      strcpy(buffer+numBytes+1,filePathCPtr);
    }
  }

//printf("Combining %s + %s = %s\n",urlCPtr,filePathCPtr,buffer);
  return(buffer);
}


//  PURPOSE:  To return a form of the path 'remoteFilepathCPtr' suitable for
//	use as a local filename.
const char*	localFilepath	(const char*		remoteFilepathCPtr
				)
{
  static char	buffer[BUFFER_LEN];
  const char*	sourceCPtr;
  char*		destCPtr;

  for  ( sourceCPtr  = remoteFilepathCPtr, destCPtr = buffer;
        *sourceCPtr != '\0';
	 sourceCPtr++, destCPtr++
       )
  {
    switch  (*sourceCPtr)
    {
    case '/' :
      *destCPtr = '_';
      destCPtr++;
      *destCPtr = '_';
      break;
    case ':' :
      *destCPtr = '_';
      break;
    default :
      *destCPtr = *sourceCPtr;
      break;
    }
  }

  *destCPtr	= '\0';
  return(buffer);
}


//  PURPOSE:  To assume that
const char*	addEndingSlashIfAppearsToBeDir
				(const char*	pathCPtr
				)
{
  const char*	endingSlashCPtr	= strrchr(pathCPtr,'/');

  if  ( (endingSlashCPtr == NULL)  ||  (endingSlashCPtr[1] == '\0') )
  {
    return(pathCPtr);
  }

  const char*	periodCPtr	= strchr(endingSlashCPtr,'.');

  if  (periodCPtr != NULL)
  {
    return(pathCPtr);
  }

  static char buffer[BUFFER_LEN];

  snprintf(buffer,BUFFER_LEN,"%s/",pathCPtr);
  return(buffer);
}


//  PURPOSE:  To use CURL handle 'curl_handle' to download the files in 'list'.
//	No return value.
void	downloadImages	(CURL*	curl_handle, std::list<FileListNode*>&	list)
{
  std::list<FileListNode*>::iterator	iter	= list.begin();
  std::list<FileListNode*>::iterator	end	= list.end();

  for  ( ;  iter != end;  iter++)
  {
    FileListNode*	nodePtr  = *iter;
    MemoryStruct*	pageCPtr = getPage
					(curl_handle,
					 nodePtr->getNameCPtr()
					);
    const char*		localName = localFilepath(nodePtr->getNameCPtr());
    int			fileFd	  = creat(localName,0644);

    printf("Writing %s\n", localName);

    if  (fileFd >= 0)
    {
      write(fileFd,pageCPtr->memory,pageCPtr->size);
      close(fileFd);
    }
    else
    {
      perror("creat()");
    }

    freeMemoryStruct(pageCPtr);
  }

}


//  PURPOSE:  To show the user how to use 'this' program, named 'progNameCPtr'.
//	Output to 'output'.  No return value.
void		showUsage	(FILE*		output,
				 const char*	progNameCPtr
				)
{
  fprintf(stderr,
	  "Usage:\t%s <startUrl> <numLinks>\n"
	  "  where:\n"
	  "    <startUrl>:\tWeb page to start image crawling\n"
	  "\t\t(e.g. http://facweb.cs.depaul.edu/jphillips/)\n"
	  "    <numLinks>:\tMaximum number of links to follow from "
	  "<startUrl>\n"
	  "\t\t(must be a non-negative integer)\n",
	  progNameCPtr
	 );
}


//  PURPOSE:  To return 'true' if an instance equivalent to '*nodePtr' is
//	present in 'list', or 'false' otherwise.
bool isEquivNodeInList(const std::list<FileListNode*>&  list, FileListNode*	nodePtr)
{
  std::list<FileListNode*>::const_iterator	run	= list.begin();
  std::list<FileListNode*>::const_iterator	end	= list.end();

  for  ( ;  run != end;  run++)
  {
    if  (**run == *nodePtr)
    {
      return(true);
    }
  }

  return(false);
}


//  PURPOSE:  To return 'true' if an instance with name 'nameCPtr' is present
//	in 'list', or 'false' otherwise.
bool isNameInList	(const std::list<FileListNode*>&  list, const char*	nameCPtr)
{
  std::list<FileListNode*>::const_iterator	run	= list.begin(); // this code is a good example of how to traverse a list
  std::list<FileListNode*>::const_iterator	end	= list.end(); // do not have to say const_iterator, just iterator

  for  ( ;  run != end;  run++) // run until it is not the end.
  {
    if  (strcmp((*run)->getNameCPtr(),nameCPtr) == 0) // *run gets the actual object that is in the list
    {
      return(true);
    }
  }

  return(false);
}


//  PURPOSE:  To crawl starting at URL 'url', and following up to 'maxNumLinks'
//	links, to find image URLs.  'handle' tells the CURL handle to use.
//	Returns a C++ list of image URLs.
std::list<FileListNode*> crawlForImages	(CURL*	handle, const char*	url, int maxNumLinks)
{
  std::list<FileListNode*>	toVisitList; // list of links to visit
  std::list<FileListNode*>	haveVisitedList; // list of links that have been visited
  std::list<FileListNode*>	toDownloadList; // list of images to download from links
  size_t			urlLen	= strlen(url);

  toVisitList.push_back(new FileListNode(url,maxNumLinks));

  while  ( !toVisitList.empty() )
  {
    FileListNode*		nodePtr	  = toVisitList.front();
    const char*			pathPtr	  = addEndingSlashIfAppearsToBeDir(  nodePtr->getNameCPtr()  );
    
	printf("Considering %s\n", pathPtr);
    
	struct MemoryStruct*	pagePtr	  = getPage(handle, pathPtr);
    int				numLinks  = nodePtr->numRemainingLinks_ - 1;
    std::list<FileListNode*>	imageList = getFileList
						(pagePtr,
						 BEGIN_IMAGE_TAG0,
						 BEGIN_IMAGE_TAG1,
						 IMAGE_ATTR,
						 numLinks
						);

    toVisitList.pop_front();
    haveVisitedList.push_back(nodePtr);

    std::list<FileListNode*>::iterator	run	= imageList.begin(); // the first item in the list
    std::list<FileListNode*>::iterator	end	= imageList.end(); // just beyond the last item
    std::list<FileListNode*>::iterator	next;
    FileListNode*			newNodePtr;
    const char*				filenameCPtr;
    const char*				fullPathPtr;

    //  YOUR CODE HERE
    //  Iterate over items in 'imageList'. **Using the function 'isNameInList()'
    //  Put them in 'toDownloadList' only if:
    //  (1) the name in the list begins with neither EXTERN_LINK_BEGIN0 nor
    //      EXTERN_LINK_BEGIN1
    //  (2) the built name does not start with 'url'
    //      (use 'pathPtr' as the starting point)
    //  (3) the built name is not already in 'toDownloadList'
	
	for (; run != end; run++) {
		
		filenameCPtr = (*run)->getNameCPtr();
		
		// filenameCPtr is a C string, this checks for substrings using strstr() method
		if (strstr(filenameCPtr, EXTERN_LINK_BEGIN0) == NULL && strstr(filenameCPtr, EXTERN_LINK_BEGIN1)==NULL) {
			// name in node does not contain external link tags, create fullPathPtr using buildPath()
			fullPathPtr = buildPath(pathPtr, filenameCPtr);
		}

		// create a new instance of the fully built path and numLinks from above
		newNodePtr = new FileListNode(fullPathPtr, numLinks);

		// check to see if the full path name doesn't contain "url"
		if (strstr(fullPathPtr, url) != NULL) {

			// if it doesn't contain "url" then check to see if the full path name is in
			// toDownloadList, and if it's not then put it in there! *as a FileListNode*
			if (!(isNameInList(toDownloadList, fullPathPtr))) {
				toDownloadList.push_back(newNodePtr);
			}
		}

	}


    freeFileList(imageList);


    if  (numLinks >= 0)
    {
      std::list<FileListNode*>	linkList	= getFileList
							(pagePtr,
							 BEGIN_LINK_TAG0,
							 BEGIN_LINK_TAG1,
							 LINK_ATTR,
							 numLinks
							);

      run	= linkList.begin();
      end	= linkList.end();

      //  YOUR CODE HERE
      //  Iterate over items in 'linkList'. ** Using the function 'isNameInList()'
      //  Put them in 'toVisitList' only if:
      //  (1) the name in the list begins with neither EXTERN_LINK_BEGIN0 nor
      //      EXTERN_LINK_BEGIN1
      //  (2) the built name does not start with 'url'
      //      (use 'url' as the starting point)
      //  (3) the built name is in neither 'toVisitList' nor 'haveVisitedList'

	  for (; run != end; run++) {

		  int remLinks = (*run)->numRemainingLinks_; // get the numRemainingLinks_ value from current node
		  filenameCPtr = (*run)->getNameCPtr(); // get the path as a C string
		  
		  // filenameCPtr is a C string, this checks for substrings using strstr() method
		  if (strstr(filenameCPtr, EXTERN_LINK_BEGIN0) == NULL && strstr(filenameCPtr, EXTERN_LINK_BEGIN1) == NULL) {
			  // name in node does not contain external link tags, create fullPathPtr using buildPath()
			  fullPathPtr = buildPath(pathPtr, filenameCPtr);
		  

		  // check to see if the full path name doesn't contain "url"
		  if (strstr(fullPathPtr, url) != NULL) {

			  // if it doesn't contain "url" then check to see if the full path name is in
			  // toDownloadList, and if it's not then put it in there! *as a FileListNode*
			  if (!(isNameInList(toVisitList, fullPathPtr)) && !(isNameInList(haveVisitedList, fullPathPtr))) {
			    toVisitList.push_back(new FileListNode(fullPathPtr, remLinks));
			  }
		  }
		  }

	  

	  }
      freeFileList(linkList);
    }

    freeMemoryStruct(pagePtr);
  }

  freeFileList(haveVisitedList);
  return(toDownloadList);
}


int		main		(int		argc,
				 char*		argv[]
				)
{

  if  (argc < 3)
  {
    showUsage(stderr,argv[0]);
    exit(EXIT_FAILURE);
  }

  char*		endPtr;
  const char*	urlCPtr		= argv[1];
  int		maxNumLinks	= strtol(argv[2],&endPtr,0);

  if  ( (*endPtr != '\0')  ||  (maxNumLinks < 0) )
  {
    showUsage(stderr,argv[0]);
    exit(EXIT_FAILURE);
  }


  curl_global_init(CURL_GLOBAL_ALL);

  /* init the curl session */
  CURL*		curl_handle	= curl_easy_init();

  /* send all data to this function  */
  curl_easy_setopt(curl_handle, CURLOPT_WRITEFUNCTION, WriteMemoryCallback);

  /* some servers don't like requests that are made without a user-agent
     field, so we provide one */
  curl_easy_setopt(curl_handle, CURLOPT_USERAGENT, "libcurl-agent/1.0");

  struct MemoryStruct*	pageCPtr	= getPage(curl_handle,urlCPtr);

  if  (pageCPtr != NULL)
  {
    std::list<FileListNode*>	list = crawlForImages
					(curl_handle,
					 urlCPtr,
					 maxNumLinks
					);

    downloadImages(curl_handle,list);
    freeFileList(list);
  }

  /* cleanup curl stuff */
  curl_easy_cleanup(curl_handle);

  /* we're done with libcurl, so clean it up */
  curl_global_cleanup();

  return EXIT_SUCCESS;
}
