//class TestTV.cpp
//CSC100AA and CIS162AB
//written by : PBaker/DHaleem
//description : Test our TV class.  Creates 4 objects and tests behavior of all member functions

#include "TV.h"
#include <iostream>
#include <string>
using namespace std;


int main()
{
	TV tv1;  //invokes the default constructor and initializes all the privat
			 // member variables of TV class.
			 // channel = 1, volume = 1 , on = false  ,maxChannel = 1 , maxVolume = 1;

	tv1.turnOn();  //private variable on = true now
	tv1.setChannel(30);
	tv1.setVolume(3);

	cout << "tv1:" << endl;
	cout << "\tchannel:  " << tv1.getChannel() << endl;
	cout << "\tvolume:   " << tv1.getVolume() << endl;

	TV tv2;
	tv2.setMaxChannel(120);
	tv2.setMaxVolume(7);
	tv2.turnOn();
	tv2.channelUp(); // channel = 2 now
	tv2.channelUp(); // channel = 3 now
	tv2.volumeUp();  // volume = 2  now
	cout << "tv2 State of: \n";
	tv2.displayTVinfo();

	TV tv3;
	tv3.setMaxChannel(3);
	tv3.turnOn();
	tv3.channelUp(); //2
	tv3.channelUp(); //3
	tv3.channelUp(); //rolls to 1
	tv3.channelUp(); //2
	cout << "tv3:" << endl;
	cout << "\tchannel:  " << tv3.getChannel() << endl;

	TV tv4;
	tv4.setVolume(5); //no effect - tv off
	tv4.turnOn();
	tv4.volumeDown();
	tv4.volumeDown();
	cout << "tv4:" << endl;
	cout << "\tvolume:  " << tv4.getVolume() << endl;
	cout << "\ton: " << tv4.isOn() << endl << endl;  //returns 1 or 0
													 //cout <<"\ton: "<< ((tv4.isOn()!= 0)? "true" : "false") << endl << endl ; //this returns true or false  
	return (0);

}




/*Expected output

tv1:
channel:  1
volume:   1
tv2 State of:
channel: 3
volume: 2
on: 1
maxChannel: 120
maxVolume: 7
tv3:
channel:  2
tv4:
volume:  0
on: 1


*/