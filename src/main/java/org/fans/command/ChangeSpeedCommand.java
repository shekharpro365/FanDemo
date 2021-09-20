package org.fans.command;

import org.fans.Fan;

public class ChangeSpeedCommand implements Command {

	private Fan fancom;
	
	public ChangeSpeedCommand(Fan fan){
		this.fancom = fan;
	}
	
	
	@Override
	public void execute() {
		fancom.changeSpeed();
	}

}
