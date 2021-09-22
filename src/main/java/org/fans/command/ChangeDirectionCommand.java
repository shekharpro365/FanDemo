package org.fans.command;

import org.fans.Fan;

/**
 * Command class to change direction of the Fan.
 *
 */
public class ChangeDirectionCommand implements Command {
	private Fan fancom;
	
	public ChangeDirectionCommand(Fan fan){
		this.fancom = fan;
	}
	
	/**
	 * Calling execute() changes the direction of fan as per implementation.
	 */
	public void execute() {
		fancom.changeDirection();
	}


}
