/* CSC 373 Sections 601, 610 Spring 2018
   Implement each of the 5 functions below (1.5 each).
   They should all be in 1 file, called hw3.c -- there
   should NOT be a main function in your submission.

   Also submit the written portion of the assignment (2.5 points).
*/


// LOGAN MURRAY
// CSC 373 Tues/Thurs

//Problem 1
//Compares two strings, returns difference in ASCII between unequal char
int strcmp373(char str1[], char str2[]) {
  int c = 0;
  int result = 0;
 
  while(str1[c]==str2[c]){
  	
  	if(str1[c] == '\0' && str2[c] == '\0'){
  		return 0;
        }
  	c++;
  }
  
  result = str1[c]-str2[c];
  return result;
	
	
}
//Problem 2
//concatenates source into destination (changes destination)
char *strcat373(char dest[], char src[]) {
  
  char *dcurr = dest;
  char *scurr = src;
  
  while(*dcurr!='\0'){
  	dcurr++;
  }
  
  while(*scurr!='\0'){
  	*dcurr = *scurr;
  	scurr++;
  	dcurr++;
  }
  
  return dest; 
}
//Problem 3
//Finds char in string and returns the rest
char *strchr373(char str[], char c) {
  char *strPtr = str;
  
  while(*strPtr!=c){
  	strPtr++;
  	if(*strPtr=='\0') break;
  }
  
  
  return strPtr; 
}
//Problem 4
//copies char from src into dest by alloted n
char *strncpy373(char dest[], char src[], int n) {
  
  char *dcurr = dest;
  char *scurr = src;
  int end = 0;
  
  while(end!=n){
  	*dcurr = *scurr;
  	dcurr++;
  	scurr++;
  	end++;
  }

 
  return dest;
}
//Problem 5
//Pretty much what strcat373 did but checks space?
char *strncat373(char dest[], char src[], int n) {
  
  char *dcurr = dest;
  char *scurr = src;
  int end = 0;
  
  while(*dcurr!='\0'){
  	dcurr++;
  }
  
  while(end!=n){
  	*dcurr = *scurr;
  	dcurr++;
  	scurr++;
  	end++;
  }
  
  
  
  return dest;  // replace this
} 

/*


	DECIMAL	BINARY		HEX
	-25	    11100111	0xe7
	-55		11001001	0xc9
	125		01111101	0x7d
	41		00101001	0x29
	-13		11110011	0xf3
	
	






*/
