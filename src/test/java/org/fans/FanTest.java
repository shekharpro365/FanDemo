package org.fans;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fans.command.ChangeDirectionCommand;
import org.fans.command.ChangeSpeedCommand;
import org.fans.common.enums.Direction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FanTest {
	private static final Logger log = LogManager.getLogger(FanTest.class);

	private FanController fan;
	private Fan fanCom;
	public static final int OFF = 0;

	/**
	 * Initializes logger just once for all tests.
	 */
	@BeforeClass
	public static void initialize() {
		BasicConfigurator.configure();
	}

	/**
	 * @throws Exception
	 * Executes before each test and initializes all dependencies for test.
	 */
	@Before
	public void setUp() throws Exception {
		log.info("FanTest::setup");
		fanCom = new Fan();
		ChangeSpeedCommand speedCord = new ChangeSpeedCommand(fanCom);
		ChangeDirectionCommand directionCord = new ChangeDirectionCommand(fanCom);
		fan = new FanController(speedCord, directionCord);
	}

	/**
	 * Verifies different states of Fan , when its operated in Forward direction.
	 * Initial state is OFF
	 */
	@Test
	public void testPullChangeSpeedCord() {
		log.info("FanTest::testPullChangeSpeedCord");
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		assertEquals(OFF, fanCom.getCurrentSpeed());
		log.info("Initial direction of fan :" + fanCom.getCurrentDirection());
		log.info("Initial speed of fan :" + fanCom.getCurrentSpeed());

		fan.pullChangeSpeedCord();
		assertEquals(1, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());

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

	/**
	 * Verifies different states of Fan, when its operated in reversed direction.
	 * Initial state is OFF
	 */
	@Test
	public void testPullChangeSpeedInReverseDirection() {
		log.info("FanTest::testPullChangeSpeedInReverseDirection");
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		assertEquals(OFF, fanCom.getCurrentSpeed());
		log.info("Initial direction of fan :" + fanCom.getCurrentDirection());
		log.info("Initial speed of fan :" + fanCom.getCurrentSpeed());

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

	/**
	 * Verifies different states of Fan, when its operated in both direction, starting from forward direction.
	 * Initial state is OFF
	 */
	@Test
	public void testChangeSpeedInBothDirection() {
		log.info("FanTest::testChangeSpeedInBothDirection");

		assertEquals(OFF, fanCom.getCurrentSpeed());
		assertEquals(Direction.FORWARD, fanCom.getCurrentDirection());
		log.info("Initial direction of fan :" + fanCom.getCurrentDirection());
		log.info("Initial speed of fan :" + fanCom.getCurrentSpeed());

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