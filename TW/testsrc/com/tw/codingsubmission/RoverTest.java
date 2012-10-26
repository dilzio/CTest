package com.tw.codingsubmission;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoverTest {

	@Test
	public void initialPositionShouldBeCorrect() {
		IRover underTest = new BlueRover(new GridCoordinates(5, 5),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		assertEquals(5, underTest.getX());
		assertEquals(5, underTest.getY());
		assertEquals(OrientationEnum.NORTH, underTest.getOrientation());
	}

	@Test
	public void turningShouldGiveProperOrientation() {
		IRover underTest = new BlueRover(new GridCoordinates(5, 5),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		assertEquals(OrientationEnum.NORTH, underTest.getOrientation());
		OrientationEnum currentOrientation = underTest.rotateRight();
		assertEquals(OrientationEnum.EAST, currentOrientation);

		currentOrientation = underTest.rotateRight();
		assertEquals(OrientationEnum.SOUTH, currentOrientation);
		currentOrientation = underTest.rotateRight();
		assertEquals(OrientationEnum.WEST, currentOrientation);
		currentOrientation = underTest.rotateRight();
		assertEquals(OrientationEnum.NORTH, currentOrientation);
		currentOrientation = underTest.rotateLeft();
		assertEquals(OrientationEnum.WEST, currentOrientation);
		currentOrientation = underTest.rotateLeft();
		assertEquals(OrientationEnum.SOUTH, currentOrientation);
		currentOrientation = underTest.rotateLeft();
		assertEquals(OrientationEnum.EAST, currentOrientation);
		currentOrientation = underTest.rotateLeft();
		assertEquals(OrientationEnum.NORTH, currentOrientation);
		currentOrientation = underTest.rotateLeft();
		assertEquals(OrientationEnum.WEST, currentOrientation);
	}

	@Test
	public void movingRoverShouldGiveProperCoordinates() {
		IRover underTest = new BlueRover(new GridCoordinates(0, 0),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		underTest.move();
		assertEquals(0, underTest.getX());
		assertEquals(1, underTest.getY());
		underTest.rotateRight();
		underTest.move();
		assertEquals(1, underTest.getX());
		assertEquals(1, underTest.getY());
		underTest.move();
		assertEquals(2, underTest.getX());
		assertEquals(1, underTest.getY());
		underTest.rotateRight();
		underTest.move();
		assertEquals(2, underTest.getX());
		assertEquals(0, underTest.getY());
		underTest.rotateRight();
		underTest.move();
		assertEquals(1, underTest.getX());
		assertEquals(0, underTest.getY());
		underTest.move();
		assertEquals(0, underTest.getX());
		assertEquals(0, underTest.getY());

		// try to move off grid
		underTest.move();
		assertEquals(0, underTest.getX());
		assertEquals(0, underTest.getY());
	}

	@Test
	public void testTypeWorks() {
		IRover blueRoverUnderTest = new BlueRover(new GridCoordinates(5, 5),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		assertEquals("Blue Rover", blueRoverUnderTest.type());
	}

	@Test
	public void testDumpPositionAndHeadingShouldOutputCorrectly() {
		IRover underTest = new BlueRover(new GridCoordinates(5, 5),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		assertEquals("5 5 N", underTest.getPositionAndHeading());
		underTest.rotateLeft();
		underTest.move();
		assertEquals("4 5 W", underTest.getPositionAndHeading());
		underTest.rotateLeft();
		assertEquals("4 5 S", underTest.getPositionAndHeading());
		underTest.move();
		assertEquals("4 4 S", underTest.getPositionAndHeading());
		underTest.rotateLeft();
		underTest.move();
		assertEquals("5 4 E", underTest.getPositionAndHeading());
		underTest.rotateLeft();
		underTest.move();
		assertEquals("5 5 N", underTest.getPositionAndHeading());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addingNullCommandShouldThrowException() {
		IRover underTest = new BlueRover(new GridCoordinates(0, 0),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		underTest.pushCommand(null);
	}

	@Test
	public void testMovesWorkAsExpected() {
		IRover underTest = new BlueRover(new GridCoordinates(0, 0),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.executeCommands();
		assertEquals("0 4 N", underTest.getPositionAndHeading());
	}

	/**
	 * acceptance test for Rover 1: grid size : 5,5 start pos: 1 2 N command
	 * sequence: LMLMLMLMM
	 * 
	 * result: 1 3 N
	 */
	@Test
	public void assertRover1AcceptanceTest() {
		IRover underTest = new BlueRover(new GridCoordinates(1, 2),
				new Orientation(OrientationEnum.NORTH), new Grid(
						new GridCoordinates(5, 5)));
		underTest.pushCommand(new RotateLeftCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new RotateLeftCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new RotateLeftCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new RotateLeftCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));

		underTest.executeCommands();
		assertEquals("1 3 N", underTest.getPositionAndHeading());
	}

	/**
	 * acceptance test for Rover 2: grid size : 5,5 start pos: 3 3 E command
	 * sequence: MMRMMRMRRM
	 * 
	 * result: 5 1 E
	 */
	@Test
	public void assertRover2AcceptanceTest() {
		IRover underTest = new BlueRover(new GridCoordinates(3, 3),
				new Orientation(OrientationEnum.EAST), new Grid(
						new GridCoordinates(5, 5)));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new RotateRightCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new RotateRightCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));
		underTest.pushCommand(new RotateRightCommand(underTest));
		underTest.pushCommand(new RotateRightCommand(underTest));
		underTest.pushCommand(new MoveCommand(underTest));

		underTest.executeCommands();
		assertEquals("5 1 E", underTest.getPositionAndHeading());
	}

}
