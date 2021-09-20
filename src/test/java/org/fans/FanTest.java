package org.fans;

import static org.junit.Assert.assertEquals;

import org.fans.command.ChangeDirectionCommand;
import org.fans.command.ChangeSpeedCommand;
import org.fans.common.enums.Direction;
import org.junit.Before;
import org.junit.Test;

public class FanTest {

	private FanController fan;
	private Fan fanCom;
	public static final int OFF = 0;

	@Before
	public void setUp() throws Exception {
		fanCom = new Fan();
		ChangeSpeedCommand speedCord = new ChangeSpeedCommand(fanCom);
		ChangeDirectionCommand directionCord = new ChangeDirectionCommand(fanCom);
		fan = new FanController(speedCord, directionCord);
	}

	@Test
	public void testPullChangeSpeedCord() {
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		assertEquals(OFF, fanCom.getCurrentSpeed());

		fan.pullChangeSpeedCord();
		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		System.out.println(fan.toString());

		fan.pullChangeSpeedCord();
		assertEquals(2, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(3, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(OFF, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		fan.pullChangeSpeedCord();
		
		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
	}
	
	@Test
	public void testPullChangeSpeedInReverseDirection() {
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		assertEquals(OFF, fanCom.getCurrentSpeed());

		fan.pullChangeDirectionCord();
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());
		assertEquals(OFF, fanCom.getCurrentSpeed());

		fan.pullChangeSpeedCord();
		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(2, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(3, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(OFF, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());
		
		fan.pullChangeSpeedCord();
		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());
	}

	@Test
	public void testChangeSpeedInBothDirection() {
		assertEquals(OFF, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		
		fan.pullChangeSpeedCord();
		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(2, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		fan.pullChangeDirectionCord();
		assertEquals(2, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(3, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());

		fan.pullChangeDirectionCord();
		assertEquals(3, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		fan.pullChangeSpeedCord();
		assertEquals(OFF, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

		fan.pullChangeDirectionCord();
		assertEquals(OFF, fanCom.getCurrentSpeed());
		assertEquals(Direction.BACKWARD, fanCom.getCurrentDirection());

	}



}