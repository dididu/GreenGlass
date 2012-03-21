import processing.core.*;
//import processing.serial.*;

import cc.arduino.*;

public class ArduinoInterface extends PApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GreenGUI gui;
	Arduino arduino;
	int ledPin = 13;
	public int light = Arduino.LOW;
	
	public boolean ready = false;

	public void setup()
	{
		size(500, 500);
		arduino = new Arduino(this, Arduino.list()[0], 57600);
		arduino.pinMode(ledPin, Arduino.OUTPUT);
		
		// prevent thread from starving everything else
		noLoop();
		ready = true;
	}
	
	public void ledOn() {
		arduino.digitalWrite(ledPin, Arduino.HIGH);
	}
	
	public void ledOff() {
		arduino.digitalWrite(ledPin, Arduino.LOW);		
	}
	
	public int analogRead(int pin) {
		if (arduino != null)
			return arduino.analogRead(pin);
		else return -1;
	}

	public void draw()
	{
	}
	
}
