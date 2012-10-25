package com.tw.codingsubmission;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RoverCommandTest {
	private final Mockery _context = new JUnit4Mockery();
	private IRover _mockRover;
	
		/*underTest.doCommand();*/

	
	/**
	
	@Test
	public void nullTest(){}
	
	@Before
	public void setupMockRover(){
		_mockRover = _context.mock(IRover.class);
	}
	
	@Test
	public void testMoveCommand(){
		IRoverCommand underTest = new MoveCommand(_mockRover);
		_context.checking(new Expectations() {
			{
				oneOf(_mockRover).move();
			}
		});		
	@Test
	public void testMoveCommand(){
		IRoverCommand underTest = new MoveCommand(_mockRover);
		_context.checking(new Expectations() {
			{
				oneOf(_mockRover).move();
			}
		});		
		underTest.doCommand();
	}

	@Test
	@Ignore
	public void testRotateLeftCommand(){
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
	@Ignore
	public void testRotateRightCommand(){
		final IRover mockRover = _context.mock(IRover.class);
		IRoverCommand underTest = new RotateRightCommand(mockRover);
		_context.checking(new Expectations() {
			{
				oneOf(mockRover).rotateRight();
			}
		});		
		underTest.doCommand();
	}
	*/
}
