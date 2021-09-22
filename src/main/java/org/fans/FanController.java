package org.fans;

import org.fans.command.Command;

/**
 * 
 * FanController object represent a controller with two cords. Each cord represents a Command.
 * This controller is called with two Command objects, which are associated with a Fan object:
 * 1. ChangeSpeedCommand
 * 2. ChangeDirectionCommand
 * When any of the Command is called, the FanController executes that command on the Fan.
 *
 */
public class FanController {
	private final Command speedCord;
	private final Command directionCord;

	/**
	 * @param speed
	 * @param direction
	 * Constructor to initialize controller with commands it can operate.
	 */
	public FanController(Command speed, Command direction) {
		this.speedCord = speed;
		this.directionCord = direction;
	}

	/**
	 * Executes command to increase speed on the fan.
	 */
	public void pullChangeSpeedCord() {
		speedCord.execute();
	}

	/**
	 * Executes command to change direction of the fan.
	 */
	public void pullChangeDirectionCord() {
		directionCord.execute();
	}

}
