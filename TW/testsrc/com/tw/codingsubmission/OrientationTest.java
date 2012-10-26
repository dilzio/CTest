package com.tw.codingsubmission;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrientationTest {

	@SuppressWarnings("unused")
	@Test
	public void happyCreationShouldWork() {
		Orientation or = new Orientation(OrientationEnum.NORTH);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalStateException.class)
	public void unrecognizedEnumValueShouldThrowException() {
		Orientation or = new Orientation(OrientationEnum.TEST);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void nullEnumValueShouldThrowException() {
		Orientation or = new Orientation(null);
	}

	@Test
	public void turningShouldWorkProperly() {
		Orientation or = new Orientation(OrientationEnum.NORTH);

		OrientationEnum currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.EAST, currentOrientation);
		assertEquals(OrientationEnum.EAST, or.getCurrentOrientation());

		currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.SOUTH, currentOrientation);
		assertEquals(OrientationEnum.SOUTH, or.getCurrentOrientation());

		currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.WEST, currentOrientation);
		assertEquals(OrientationEnum.WEST, or.getCurrentOrientation());

		currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.NORTH, currentOrientation);
		assertEquals(OrientationEnum.NORTH, or.getCurrentOrientation());

		currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.EAST, currentOrientation);
		assertEquals(OrientationEnum.EAST, or.getCurrentOrientation());

		currentOrientation = or.turnLeft();
		assertEquals(OrientationEnum.NORTH, currentOrientation);
		assertEquals(OrientationEnum.NORTH, or.getCurrentOrientation());

		currentOrientation = or.turnLeft();
		assertEquals(OrientationEnum.WEST, currentOrientation);
		assertEquals(OrientationEnum.WEST, or.getCurrentOrientation());

		currentOrientation = or.turnLeft();
		assertEquals(OrientationEnum.SOUTH, currentOrientation);
		assertEquals(OrientationEnum.SOUTH, or.getCurrentOrientation());

		currentOrientation = or.turnLeft();
		assertEquals(OrientationEnum.EAST, currentOrientation);
		assertEquals(OrientationEnum.EAST, or.getCurrentOrientation());

		currentOrientation = or.turnLeft();
		assertEquals(OrientationEnum.NORTH, currentOrientation);
		assertEquals(OrientationEnum.NORTH, or.getCurrentOrientation());

		currentOrientation = or.turnLeft();
		assertEquals(OrientationEnum.WEST, currentOrientation);
		assertEquals(OrientationEnum.WEST, or.getCurrentOrientation());

		currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.NORTH, currentOrientation);
		assertEquals(OrientationEnum.NORTH, or.getCurrentOrientation());

		currentOrientation = or.turnRight();
		assertEquals(OrientationEnum.EAST, currentOrientation);
		assertEquals(OrientationEnum.EAST, or.getCurrentOrientation());
	}

}
