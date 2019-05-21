/* get-messages.c
 * Demonstrates use of message-lib API
 */

#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <string.h>
#include <sys/un.h>
#include <unistd.h>
#include "message-lib.h"

int error_msg( char * msg )
{
	printf( "%s\n", msg );
	return -1;
}

int usage( char name[] )
{
	printf( "Usage:\n" );
	printf( "\t%s <UDS name>\n", name );
	return -1;
}
	
int main( int argc, char * argv[] )
{
	if ( argc != 2 )
		return usage( argv[0] );
		
	// permit message connections
	int listener= permit_connections( argv[1] );
	if ( listener == -1 )
		return -1;
	
	// accept message connection
	int connection= accept_next_connection( listener );
	if ( connection == -1 )
		return -1;
		
	// read message
	char buffer[256];
	int number_bytes_read= read_msg( connection, buffer, 256 );
	
	if ( number_bytes_read == -1 ){
		printf( "(error reading msg)\n" );
		return -1;
	}
	printf( "msg: %s\n", buffer );
	
	// close message connection
	close_connection( connection );
	
	// close the listener
	close_listener( listener );

	return 0;
}
