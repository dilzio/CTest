package com.tw.codingsubmission;

/**
 * A virtual world!
 * 
 * @author mtc
 * 
 */
public class Grid {

	private final GridCoordinates _maxCoordinate;
	private final GridCoordinates _minCoordinate;

	public Grid(GridCoordinates maxCoordinates) {

		// only take positive coordinates for now
		if (maxCoordinates.getX() <= 0 || maxCoordinates.getY() <= 0) {
			throw new IllegalArgumentException(
					"Only Positive X,Y values accepted.");
		}
		_minCoordinate = new GridCoordinates(0, 0);
		_maxCoordinate = maxCoordinates;
	}

	public boolean isValidCoordinate(final int x, final int y) {
		if ((x >= _minCoordinate.getX() && x <= _maxCoordinate.getX())
				&& (y >= _minCoordinate.getY() && y <= _maxCoordinate.getY())) {
			return true;
		}
		return false;
	}

}
