package view;

import model.Clock;

public class Main {	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		Clock clock = new Clock();
		DigitalClock digitaClock = new DigitalClock(clock);
		AnalogClock analogClock = new AnalogClock(clock);
	}
}