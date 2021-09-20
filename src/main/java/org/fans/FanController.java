package org.fans;

import org.fans.command.Command;

public class FanController {
	private Command speedCord;
	private Command directionCord;
	
	public FanController(Command speed, Command direction) {
	this.speedCord = speed;
	this.directionCord = direction;
	
}
	public void pullChangeSpeedCord()
    {
        speedCord.execute();
    }

	public void pullChangeDirectionCord()
    {
        directionCord.execute();
    }
	
}
