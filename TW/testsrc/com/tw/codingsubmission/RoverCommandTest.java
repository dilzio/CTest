package com.tw.codingsubmission;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

import org.junit.Test;

public class RoverCommandTest {
	private final Mockery _context = new JUnit4Mockery();

	@Test
	public void testMoveCommand() {
		final IRover mockRover = _context.mock(IRover.class);
		IRoverCommand underTest = new MoveCommand(mockRover);
		_context.checking(new Expectations() {
			{
				oneOf(mockRover).move();
			}
		});
		underTest.doCommand();
	}

	@Test
	public void testRotateLeftCommand() {
		final IRover mockRover = _context.mock(IRover.class);
		IRoverCommand underTest = new RotateLeftCommand(mockRover);
		_context.checking(new Expectations() {
			{
				oneOf(mockRover).rotateLeft();
			}
		});
		underTest.doCommand();
	}

	@Test
	public void testRotateRightCommand() {
		final IRover mockRover = _context.mock(IRover.class);
		IRoverCommand underTest = new RotateRightCommand(mockRover);
		_context.checking(new Expectations() {
			{
				oneOf(mockRover).rotateRight();
			}
		});
		underTest.doCommand();
	}
}
