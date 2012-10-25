package com.tw.codingsubmission;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridCoordinatesTest {
	

	@Test
	public void testCreateSetGetShouldWork(){
		GridCoordinates underTest = new GridCoordinates(5, 10);
		assertEquals(5, underTest.getX());
		assertEquals(10, underTest.getY());
		underTest.set(34, 67);
		assertEquals(34, underTest.getX());
		assertEquals(67, underTest.getY());
	}
	
	@Test
	public void testToStringIsCorrect(){
		GridCoordinates underTest = new GridCoordinates(5, 10);
		assertEquals("(5,10)", underTest.toString());
	}
	

}
