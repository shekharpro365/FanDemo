package org.fans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fans.common.enums.Direction;

/**
 * Fan class represents a fan, whose speed and direction of rotation can be controlled by two cords.
 * 1. One cord increases the speed each time it is pulled.  There are 3 speed settings, and an “off” (speed 0) setting.  
		§  If the cord is pulled on speed 3, the fan returns to the “off” setting.
 * 2. One cord reverses the direction of the fan at the current speed setting.
		§  Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
 **/
public class Fan {
	private static final Logger log = LogManager.getLogger(Fan.class);
	private Direction fanDirection  = Direction.FORWARD;
	final int OFF = 0;
	private int fanSpeed = OFF;
	
	/**
	 * Changes the speed of the fan rotation. 
	 * Each time this method is called, it increases the speed by one level.
	 * Once max level 3 is reached, calling this method again changes speed of fan to OFF.
	 */
	public void changeSpeed() {
		if (fanSpeed < 3) 
			fanSpeed++;
		 else  
			fanSpeed = OFF;
		
		log.info("Changing Speed , Current Speed is :"+ fanSpeed);
	}
	
	/**
	 * Changes the direction of the fan rotation. 
	 * Each time this method is called, it reverses previous direction.
	 */
	public void changeDirection() {
		if(fanDirection == Direction.FORWARD) 
			fanDirection = Direction.BACKWARD;
		else
			fanDirection =  Direction.FORWARD;
		log.info("Changing direction of fan , current direction is :"+ fanDirection);
		log.info("After changing direction, current speed is :"+ fanSpeed);
	}
	
	/**
	 * @return Direction
	 * Returns current direction of fan.
	 */
	protected Direction getCurrentDirection() {
		return fanDirection;
	}
	
	/**
	 * @return int
	 * Returns current speed of fan.
	 */
	protected int getCurrentSpeed() {
		return fanSpeed;
	}
	

}



