package org.fans.command;

import org.fans.Fan;

public class ChangeDirectionCommand implements Command {
	private Fan fancom;
	
	public ChangeDirectionCommand(Fan fan){
		this.fancom = fan;
	}
	
	@Override
	public void execute() {
		fancom.changeDirection();
	}


}
