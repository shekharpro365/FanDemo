package org.fans;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fans.command.ChangeDirectionCommand;
import org.fans.command.ChangeSpeedCommand;

/**
 * 
 * This class can be used main entry point to access the control of the Fan. 
 * This application uses Command Design Pattern.
 * FanController object represent a controller with two cords. Each cord represents a Command.
 * Controller is initialized with fan object it needs to control.
 * When any of the Command is called, the Fan executes that command.
 *
 */
public class FanCommander {
	private static final Logger log = LogManager.getLogger(FanCommander.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		log.info("FanCommander::main");

		Fan fan = new Fan();

		ChangeSpeedCommand speedCord = new ChangeSpeedCommand(fan);
		ChangeDirectionCommand directionCord = new ChangeDirectionCommand(fan);
		FanController fanController = new FanController(speedCord, directionCord);

		//Pull Speed cord to change speed
		fanController.pullChangeSpeedCord();
		fanController.pullChangeSpeedCord();
		fanController.pullChangeSpeedCord();
		fanController.pullChangeSpeedCord();

		//Pull Direction cord to reverse the direction
		fanController.pullChangeDirectionCord();
		fanController.pullChangeSpeedCord();

	}

}
