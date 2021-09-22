# Fan Demo
==========================
This demo demonstrate operation of a Fan.
Fan class represents a fan, whose speed and direction of rotation can be controlled by two cords.

The unit has 2 pull cords:
	
	1.  One increases the speed each time it is pulled.  There are 3 speed settings, and an OFF(speed 0) setting.
		-> If the cord is pulled on speed 3, the fan returns to the OFF setting.
	
	2. One reverses the direction of the fan at the current speed setting.
		-> Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
		We can assume the unit is always powered (no wall switch).
To avoid running a infinite loop for a operational fan, different tests cases simulates change of speed and direction.
				
This demo uses Command Pattern. This way we can decouple the final receiver of the command and if needed, reuse Two-Cord controller to operate any other appliance ( like Dimmable Light Bulb).

To execute the demo run:
FanCommander.java, its main method invokes the Command and Receiver.

To Test :
Execute : FanTest.java in test packages.
