package org.fans;

import org.fans.command.ChangeDirectionCommand;
import org.fans.command.ChangeSpeedCommand;

public class FanCommander {

	
	public static void main(String[] args) {
		
	Fan fan = new Fan();

	ChangeSpeedCommand speedCord = new ChangeSpeedCommand(fan);
	ChangeDirectionCommand directionCord = new ChangeDirectionCommand(fan);
	FanController fanController = new FanController(speedCord, directionCord);
	
	System.out.println(fan.getCurrentSpeed());
	System.out.println(fan.getCurrentDirection());
	
	//Pull Speed cord to change speed
	fanController.pullChangeSpeedCord();
	System.out.println(fan.getCurrentSpeed());
	System.out.println(fan.getCurrentDirection());
	
	//Pull Direction cord to reverse the direction
	fanController.pullChangeDirectionCord();
	System.out.println(fan.getCurrentSpeed());
	System.out.println(fan.getCurrentDirection());
	
	}
	

}
