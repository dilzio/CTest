package com.tw.codingsubmission;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoverBuilderTest {
	
	@Test
	public void goodBuildTest(){
		RoverBuilder underTest = new RoverBuilder();
		RoverSpec spec= new RoverSpec('3', '6', 'N', "MRML");
		Grid grid = new Grid(new GridCoordinates(7,7));
		IRover rover = underTest.build(grid, spec);
		assertEquals("3 6 N", rover.getPositionAndHeading());
	}

	@Test(expected=RuntimeException.class)
	public void badDirectionThrowsException(){
		RoverBuilder underTest = new RoverBuilder();
		RoverSpec spec= new RoverSpec('3', '6', 'Q', "MRML");
		Grid grid = new Grid(new GridCoordinates(7,7));
		IRover rover = underTest.build(grid, spec);
	}

	@Test(expected=RuntimeException.class)
	public void badCommandCodeThrowsException(){
		RoverBuilder underTest = new RoverBuilder();
		RoverSpec spec= new RoverSpec('3', '6', 'N', "MRDML");
		Grid grid = new Grid(new GridCoordinates(7,7));
		IRover rover = underTest.build(grid, spec);
	}

}
