/* send-messages.c
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
		
	int connection= request_connection( argv[1] );
	if ( connection == -1 )
		return -1;
	
	char buffer[256];
	printf( "Enter a message:\n" );
	fgets( buffer, 256, stdin ); 
	write_msg( connection, buffer );
	
	close_connection( connection );
	return 0;
}
