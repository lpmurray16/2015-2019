#pragma once
//TV.h
//Logan Murray
//April 20th, 2016

#include<iostream>
#include<string>
using namespace std;

class TV {
private:
	int channel;
	int volume;
	bool on;
	int maxChannel;
	int maxVolume;
public:
	TV();
	int getChannel();
	int getVolume();
	bool isOn();
	int getMaxChannel();
	int getMaxVolume();
	void setChannel(int someChannel);
	void setVolume(int someVolume);
	void setMaxChannel(int maxC);
	void setMaxVolume(int maxV);

	void turnOn();
	void turnOff();
	void channelUp();
	void channelDown();
	void volumeUp();
	void volumeDown();
	void displayTVinfo();
};

TV::TV() {
	channel = 1;
	volume = 1;
	on = false;
	maxChannel = 1;
	maxVolume = 1;
}

int TV::getChannel() {
	return channel;
}

int TV::getVolume() {
	return volume;
}

bool TV::isOn() {
	return on;
}

int TV::getMaxChannel() {
	return maxChannel;
}

int TV::getMaxVolume() {
	return maxVolume;
}

void TV::setChannel(int someChannel) {
	if (on) {
		if (someChannel >= 1 && someChannel <= maxChannel) {
			channel = someChannel;
		}
	}
}

void TV::setVolume(int someVolume) {
	if (on) {
		if (someVolume >= 0 && someVolume <= maxVolume) {
			volume = someVolume;
		}
	}
}

void TV::setMaxChannel(int maxC) {
	maxChannel = maxC;
}

void TV::setMaxVolume(int maxV) {
	maxVolume = maxV;
}

void TV::turnOn() {
	on = true;
}

void TV::turnOff() {
	on = false;
}

void TV::channelUp() {
	if (on) {
		channel++;
			if (channel > maxChannel) {
				channel = 1;
			}
	}
}

void TV::channelDown() {
	if (on) {
		channel--;
		if (channel < 1) {
			channel = maxChannel;
		}
	}
}

void TV::volumeUp() {
	if (on&&volume<maxVolume) {
		volume++;
		
	}
}

void TV::volumeDown() {
	if (on&&volume > 0) {
		volume--;
	}
}

void TV::displayTVinfo() {
	cout << "\n\tChannel: " << channel;
	cout << "\n\tVolume: " << volume;
	cout << "\n\tOn: " << on;
	cout << "\n\tMaxChannel: " << maxChannel;
	cout << "\n\tMaxVolume: " << maxVolume << endl;
}

