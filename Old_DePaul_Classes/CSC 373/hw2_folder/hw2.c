// copy & paste from Notepad++
// Logan Murray
// CSC 373 hw2.c 
// does not include main() function. Found in hw2main.c
// April 10, 2018



void add_index(int numbers[], int len) {
	
	int i;
	for(i=0; i < len; i++){
		numbers[i] = numbers[i] + i;	
	}


}

void min_and_max(int scores[], int len, int *minptr, int *maxptr) {
	int i;
	*minptr = scores[0];
	*maxptr = scores[0];
	for(i=1; i < len; i++){
		if(scores[i] < *minptr){
			*minptr = scores[i];
		}
		if(scores[i] > *maxptr){
			*maxptr = scores[i];
		}	
	}

}

void copy_array(int *dest, int* src, int len) {
	int i;
	for(i=0; i<len;i++){
		*(dest+i)=*(src+i);
	}
}

void reverse_array(int x[], int len) {
	int last = len-1;	
	int first = 0;
	int temp;
	while(first < last){
		temp = x[first];
		x[first] = x[last];
		x[last] = temp;
		first++;
		last--;
	}
}

void convert_temp(int deg, char scale, int *dptr, char *sptr) {

	if(scale=='C'){
		*dptr = deg + 32;
		*sptr = 'F';
	}
	else if(scale=='F'){
		*dptr = deg - 32;
		*sptr = 'C';
	}

}

