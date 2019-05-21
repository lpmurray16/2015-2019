// mycopy.c

/* mycopy utility
 * makes a copy of a file and assigns the same file
 * permissions to the copy
 * Usage:
 *   ./mycopy <name of original file> <name of copy>
 * If the original file does not exist or the user
 * lacks permission to read it, mycopy emits an error.
 * Also, if a file or directory exists with the name
 * proposed for the copy, mycopy emits an error and
 * terminates.
 */

#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int error( char * msg )
{
	perror( msg );
	return 2;
}

int usage( char * name )
{
	printf( "Usage: %s <file to copy> <name of copy>\n", name );
	return 1;
}
	
int main( int argc, char * argv[] )
{
	if ( argc != 3 )
		return usage( argv[0] );

	// open files
	
	// read bytes from original file and
	// write to copy

	// close files
	
	return 0;
}
