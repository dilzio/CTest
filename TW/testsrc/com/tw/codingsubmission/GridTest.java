package com.tw.codingsubmission;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {
	

	@SuppressWarnings("unused")
	@Test
	public void testCreateGridOK(){
		Grid underTest = new Grid(new GridCoordinates(5,5));
	}

	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testCreateGridWithZeroCoordinatesFails(){
		Grid underTest = new Grid(new GridCoordinates(0,0));
	}

	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testCreateGridWithNegativeCoordinatesFails(){
		Grid underTest = new Grid(new GridCoordinates(1,-1));
	}
	
	@Test
	public void testValidCoordinatesWork(){
		Grid underTest = new Grid(new GridCoordinates(5,5));
		assertTrue(underTest.isValidCoordinate(0,0));
		assertTrue(underTest.isValidCoordinate(0,1));
		assertTrue(underTest.isValidCoordinate(0,2));
		assertTrue(underTest.isValidCoordinate(0,3));
		assertTrue(underTest.isValidCoordinate(0,4));
		assertTrue(underTest.isValidCoordinate(0,5));
	}

	@Test
	public void testInvalidCoordinatesFail(){
		Grid underTest = new Grid(new GridCoordinates(5,5));
		assertFalse(underTest.isValidCoordinate(6,6));
		assertFalse(underTest.isValidCoordinate(6,-1));
		assertFalse(underTest.isValidCoordinate(-10, 8));
		assertFalse(underTest.isValidCoordinate(5, 10));
		assertFalse(underTest.isValidCoordinate(0, 8));
	}

}
