/*
 * message-lib.h
 *   Declares methods for sending messages using UDS
 */
 

#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <string.h>
#include <sys/un.h>
#include <unistd.h>

int accept_next_connection( int listener );
void close_connection( int connection );
void close_listener( int listener );
int permit_connections( char UDS_name[] );
int read_msg( int connection, char buffer[], int buffer_size );
int request_connection( char UDS_name[] );
int write_msg( int connection, char msg[] );
