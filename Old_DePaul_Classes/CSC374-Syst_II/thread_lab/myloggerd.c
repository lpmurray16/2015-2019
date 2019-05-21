/* myloggerd.c
 * Source file for thread-lab
 * Creates a server to log messages sent from various connections
 * in real time.
 *
 * Student: 
 */
 
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <stdlib.h>
#include <pthread.h>
#include "message-lib.h"

// forward declarations
int usage( char name[] );
// a function to be executed by each thread
void * recv_log_msgs( void * arg );

// globals
int log_fd; // opened by main() but accessible by each thread

void * recv_log_msgs( void * arg ){
	
	// loops to receive messages from a connection;
	// when read_msg returns zero, terminate the loop
	// and close the connection

	return NULL;
}

int usage( char name[] ){
	printf( "Usage:\n" );
	printf( "\t%s <log-file-name> <UDS path>\n", name );
	return 1;
}

int main( int argc, char * argv[] )
{
	if ( argc != 3 )
		return usage( argv[0] );
		
	// open the log file for appending
	
	// permit message connections
			
	// loop to wait for connection requests;
	// as each connection is accepted,
	// launch a new thread that calls
	// recv_log_msgs(), which receives
	// messages and writes them to the log file			
	// when accept_next_connection returns -1, terminate the loop
	
	// close the listener
	
	// close the log file

	return 0;
}
