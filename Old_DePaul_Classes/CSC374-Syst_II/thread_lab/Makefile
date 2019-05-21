CC = gcc
CFLAGS = -Wall
LIBS = -pthread

all: myloggerd

myloggerd: myloggerd.c message-lib.o
	$(CC) $(CFLAGS) -o myloggerd myloggerd.c message-lib.o $(LIBS)

message-lib.o: message-lib.c
	$(CC) $(CFLAGS) -c message-lib.c

clean:
	rm -f *.o myloggerd
