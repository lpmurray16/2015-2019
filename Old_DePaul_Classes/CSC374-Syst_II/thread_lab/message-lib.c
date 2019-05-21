/*
 * message-lib.c
 *   Defines methods for sending messages using UDS
 */
 

#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <string.h>
#include <sys/un.h>
#include <unistd.h>
#include "message-lib.h"

int accept_next_connection( int listener ){
	int clientfd= accept( listener, NULL, NULL );
	if ( clientfd == -1 )
		perror( "accept" );
	char buffer[9];
	char stop_msg[]= "--STOP--";
	int number= read_msg( clientfd, buffer, 8 );
	if ( strlen( stop_msg ) < number )
		number= strlen( stop_msg );
	if ( number > 0 ){
		if ( strncmp( buffer, stop_msg, number ) == 0 ){
			close( clientfd );
			return -1;
		}
	}
	return clientfd;
}

void close_connection( int connection ){
	close( connection );
}

void close_listener( int listener ){
	close( listener );
}

int permit_connections(char UDS_name[] ){
	int listenfd= socket( AF_UNIX, SOCK_STREAM, 0 );
	if ( listenfd == -1 ){
		perror( "socket failed" );
		return -1;
	}
	struct sockaddr_un addr;
	memset( &addr, 0, sizeof(addr) );
	addr.sun_family= AF_UNIX;
	strncpy( addr.sun_path, UDS_name, sizeof(addr.sun_path) - 1 );
	//printf( "Unlinking %s...\n", addr.sun_path );
	unlink( addr.sun_path );
	if ( bind( listenfd, (struct sockaddr *)&addr, sizeof(addr) ) == -1 ){
		perror( "bind failed" );
		close( listenfd );
		return -1;
	}
	// listen
	if ( listen( listenfd, SOMAXCONN ) == -1 ){
		perror( "listen failed" );
		close( listenfd );
		return -1;
	}
	return listenfd;
}

int read_msg( int connection, char buffer[], int buffer_size ){
	int number_bytes_received= recv( connection, buffer, buffer_size, 0 );
	if ( number_bytes_received == -1 )
		perror( "recv" );
	return number_bytes_received;
}

int request_connection( char UDS_name[] ){
	int clientfd= socket( AF_UNIX, SOCK_STREAM, 0 );
	if ( clientfd == -1 ){
		perror( "socket failed" );
		return -1;
	}
		
	struct sockaddr_un addr;
	memset( &addr, 0, sizeof(addr) );
	addr.sun_family= AF_UNIX;
	strncpy( addr.sun_path, UDS_name, sizeof(addr.sun_path) - 1 );
	//printf( "Connecting to uds:%s...\n", addr.sun_path );
	if ( connect( clientfd, (struct sockaddr *)&addr, sizeof(addr) ) == -1 ){
		perror( "connected failed" );
		return -1;
	}
	//write_msg( clientfd, "new" );
	char new_msg[]= "--NEW --";
	send( clientfd, new_msg, strlen(new_msg), 0 );
	return clientfd;
}

int write_msg( int connection, char msg[] ){
	return send( connection, msg, strlen(msg), 0 );	
}
