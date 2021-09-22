package org.fans.command;

import org.fans.Fan;

/**
 * Command class to change speed of the Fan.
 *
 */
public class ChangeSpeedCommand implements Command {

	private Fan fancom;
	
	/**
	 * @param fan
	 * Constructor to initialize command with a fan
	 */
	public ChangeSpeedCommand(Fan fan){
		this.fancom = fan;
	}

	/**
	 * Calling execute() changes the speed of fan as per implementation.
	 */
	public void execute() {
		fancom.changeSpeed();
	}
	


}
