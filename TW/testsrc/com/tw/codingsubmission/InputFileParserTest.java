package com.tw.codingsubmission;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class InputFileParserTest {
	@Test
	public void testParseGoodFile() throws IOException {
		InputFileParser parser = new InputFileParser(
				"../testinputfiles/test-input-good.txt");
		GridCoordinates coordinates = parser.getGridMaxCoordinates();
		assertEquals(5, coordinates.getX());
		assertEquals(5, coordinates.getY());
		List<RoverSpec> specList = parser.getRoverSpecs();
		RoverSpec specA = specList.get(0);
		assertEquals(1, specA.x());
		assertEquals(2, specA.y());
		assertEquals('N', specA.direction());
		assertEquals("LMLMLMLMM", specA.commands());
		RoverSpec specB = specList.get(1);
		assertEquals(3, specB.x());
		assertEquals(3, specB.y());
		assertEquals('E', specB.direction());
		assertEquals("MMRMMRMRRM", specB.commands());
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testParseBadGridDefFile() throws IOException {
		InputFileParser parser = new InputFileParser(
				"../testinputfiles/test-input-bad-grid.txt");
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testParseBadRoverSpecFile() throws IOException {
		InputFileParser parser = new InputFileParser(
				"../testinputfiles/test-input-bad-rover.txt");
	}

}
